package DAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import model.DTO.*;

public class AgenteDAO {
   
    private static final String SQL_SELECT_ALL = "SELECT * FROM agentes";
    private static final String SQL_SELECT = "SELECT * FROM agentes WHERE placa = ?";
    private static final String SQL_INSERT = "INSERT INTO agentes(dniAgente, password, imagen, rango) VALUES(?, ?, ?)";
    private static final String SQL_UPDATE = "UPDATE agentes SET dniAgente=?, password=?, imagen=?, rango=? WHERE placa = ?";
    private static final String SQL_DELETE = "DELETE FROM agentes WHERE placa=?";

    private AgenteDTO fromResultSet(ResultSet rs) throws SQLException {
        int placa = rs.getInt("placa");
        
        String dniAgente = rs.getString("dniAgente");
        CiudadanoDTO ciudadano = new CiudadanoDAO().select(dniAgente);

        String password = rs.getString("password");
        String imagen = rs.getString("imagen");
        String rango = rs.getString("rango");

        AgenteDTO agente = new AgenteDTO(placa,ciudadano, password, imagen, rango);

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

    public int insert(AgenteDTO agente) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, agente.getCiudadano().getDni());
            stmt.setString(2, agente.getPassword());
            stmt.setString(3, agente.getEnlaceFotografico());
            stmt.setString(4, agente.getRango());

            System.out.println("ejecutando query:" + SQL_INSERT);
            rows = stmt.executeUpdate();
            System.out.println("Registros afectados:" + rows);
        } catch (SQLException ex) {
            rows = 0;
        }

        return rows;
    }

    public int update(AgenteDTO agente) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            System.out.println("ejecutando query: " + SQL_UPDATE);
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, agente.getCiudadano().getDni());
            stmt.setString(2, agente.getPassword());
            stmt.setString(3, agente.getEnlaceFotografico());
            stmt.setString(4, agente.getRango());
            stmt.setInt(5, agente.getPlaca());

            rows = stmt.executeUpdate();
            System.out.println("Registros actualizado:" + rows);

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
            System.out.println("Ejecutando query:" + SQL_DELETE);
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, agente.getPlaca());
            rows = stmt.executeUpdate();
            System.out.println("Registros eliminados:" + rows);
        } catch (SQLException ex) {
            rows = 0;
        }

        return rows;
    }
}
