package DAO;

import model.DTO.DireccionDTO;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DireccionDAO {

    private static final String SQL_SELECT_ALL = "SELECT * FROM direcciones;";
    private static final String SQL_SELECT = "SELECT * FROM direcciones WHERE id = ?;";
    private static final String SQL_INSERT = "INSERT INTO direcciones(municipio, codigo_postal, calle, piso, puerta, numero) VALUES(?, ?, ?, ?, ?, ?)";
    private static final String SQL_UPDATE = "UPDATE direcciones SET municipio=?, codigo_postal=?, calle=?, piso=?, puerta=?, numero=? WHERE id = ?";
    private static final String SQL_DELETE = "DELETE FROM direcciones WHERE id=?";

    private DireccionDTO fromResultSet(ResultSet rs) throws SQLException {
        int id = rs.getInt("id");
        String municipio = rs.getString("municipio");
        String codigoPostal = rs.getString("codigo_postal");
        String calle = rs.getString("calle");
        String puerta = rs.getString("puerta");
        String piso = rs.getString("piso");
        int numero = rs.getInt("numero");

        DireccionDTO direccion = new DireccionDTO(id, municipio, codigoPostal, calle, piso, puerta, numero);

        return direccion;
    }

    public List<DireccionDTO> selectAll() throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        DireccionDTO direccion = null;
        List<DireccionDTO> direcciones = new ArrayList<DireccionDTO>();

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT_ALL);
            rs = stmt.executeQuery();
            while (rs.next()) {
                direccion = fromResultSet(rs);
                direcciones.add(direccion);
            }
        } catch (SQLException ex) {
            direcciones = null;
        }
        return direcciones;
    }

    public DireccionDTO select(int idDireccion) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        DireccionDTO result = null;

        try {
            conn = Conexion.getConnection();
            if (conn != null) {
                stmt = conn.prepareStatement(SQL_SELECT);
                stmt.setInt(1, idDireccion);
                rs = stmt.executeQuery();
                if (rs.next()) {
                    result = fromResultSet(rs);
                }
            }
        } catch (SQLException ex) {
            result = null;
        }
        return result;
    }

    public int insert(DireccionDTO direccion) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        int idDireccion = -1;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT, Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, direccion.getMunicipio());
            stmt.setString(2, direccion.getCodigoPostal());
            stmt.setString(3, direccion.getCalle());
            stmt.setString(4, direccion.getPiso());
            stmt.setString(5, direccion.getPuerta());
            stmt.setInt(6, direccion.getNumero());

            stmt.executeUpdate();
            ResultSet generatedKeys = stmt.getGeneratedKeys();
            if (generatedKeys.next()) {
                idDireccion = generatedKeys.getInt(1);
            } else {
                throw new SQLException("No se generó ningún ID.");
            }
        } catch (SQLException ex) {
            throw new SQLException("Error servidor.");
        }
        return idDireccion;
    }

    public int update(DireccionDTO direccion) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, direccion.getMunicipio());
            stmt.setString(2, direccion.getCodigoPostal());
            stmt.setString(3, direccion.getCalle());
            stmt.setString(4, direccion.getPiso());
            stmt.setString(5, direccion.getPuerta());
            stmt.setInt(6, direccion.getNumero());
            stmt.setInt(7, direccion.getId());

            rows = stmt.executeUpdate();
        } catch (SQLException ex) {
            rows = 0;
        }
        return rows;
    }

    public int delete(DireccionDTO direccion) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, direccion.getId());
            rows = stmt.executeUpdate();
        } catch (SQLException ex) {
            rows = 0;
        }
        return rows;
    }
}
