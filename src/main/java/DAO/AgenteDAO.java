package DAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import model.DTO.*;

public class AgenteDAO {

    private static final String SQL_SELECT_ALL = "SELECT * FROM agentes";
    private static final String SQL_SELECT = "SELECT * FROM agentes WHERE placa = ?";
    private static final String SQL_SELECT_DNI = "SELECT * FROM agentes WHERE dniAgente = ?";
    private static final String SQL_INSERT = "INSERT INTO agentes(dniAgente, password, imagen, rango, isAdmin) VALUES(?, ?, ?, ?, ?)";
    private static final String SQL_UPDATE = "UPDATE agentes SET dniAgente=?, password=?, imagen=?, rango=?, isAdmin=? WHERE placa = ?";
    private static final String SQL_DELETE = "DELETE FROM agentes WHERE placa=?";

    private AgenteDTO fromResultSet(ResultSet rs) throws SQLException {
        int placa = rs.getInt("placa");

        String dniAgente = rs.getString("dniAgente");
        CiudadanoDTO ciudadano = new CiudadanoDAO().select(dniAgente);

        String password = rs.getString("password");
        String imagen = rs.getString("imagen");
        String rango = rs.getString("rango");
        boolean isAdmin = rs.getBoolean("isAdmin");

        AgenteDTO agente = new AgenteDTO(placa, ciudadano, password, imagen, rango, isAdmin);

        return agente;
    }

    public List<AgenteDTO> selectAll() throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        AgenteDTO agente = null;
        List<AgenteDTO> agentes = new ArrayList<AgenteDTO>();

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT_ALL);
            rs = stmt.executeQuery();
            while (rs.next()) {
                agente = fromResultSet(rs);
                if (agente != null) {
                    agentes.add(agente);
                }
            }
        } catch (SQLException ex) {
            agentes = null;
        }

        return agentes;
    }

    public AgenteDTO select(int placa) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        AgenteDTO agente = null;
        try {
            conn = Conexion.getConnection();
            if (conn != null) {
                stmt = conn.prepareStatement(SQL_SELECT);
                stmt.setInt(1, placa);
                rs = stmt.executeQuery();

                if (rs.next()) {
                    agente = fromResultSet(rs);
                }
            }
        } catch (SQLException ex) {
            agente = null;
        }

        return agente;
    }

    public byte select(String dni) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        AgenteDTO agente = null;
        byte rows = 0;
        try {
            conn = Conexion.getConnection();
            if (conn != null) {
                stmt = conn.prepareStatement(SQL_SELECT_DNI);
                stmt.setString(1, dni);
                rs = stmt.executeQuery();

                if (rs.next()) {
                    agente = fromResultSet(rs);
                    rows = 1;
                }
            }
        } catch (SQLException ex) {
            rows = 0;
        }

        return rows;
    }

    public int insert(AgenteDTO agente) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        int generatedId = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT, Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, agente.getCiudadano().getDni());
            stmt.setString(2, agente.getPassword());
            stmt.setString(3, agente.getEnlaceFotografico());
            stmt.setString(4, agente.getRango());
            stmt.setBoolean(5, agente.isAdmin());

            stmt.executeUpdate();
            ResultSet generatedKeys = stmt.getGeneratedKeys();
            generatedId = -1;
            if (generatedKeys.next()) {
                generatedId = generatedKeys.getInt(1);
            } else {
                throw new SQLException("No se generó ningún ID.");
            }
        } catch (SQLException ex) {
            generatedId = 0;
        }
        return generatedId;
    }

    public int update(AgenteDTO agente) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, agente.getCiudadano().getDni());
            stmt.setString(2, agente.getPassword());
            stmt.setString(3, agente.getEnlaceFotografico());
            stmt.setString(4, agente.getRango());
            stmt.setBoolean(5, agente.isAdmin());
            stmt.setInt(6, agente.getPlaca());

            rows = stmt.executeUpdate();

        } catch (SQLException ex) {
            rows = 0;
        }

        return rows;
    }

    public int delete(AgenteDTO agente) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, agente.getPlaca());
            rows = stmt.executeUpdate();
        } catch (SQLException ex) {
            rows = 0;
        }
        return rows;
    }
}
