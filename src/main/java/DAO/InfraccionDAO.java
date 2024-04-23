package DAO;

import model.DTO.InfraccionDTO;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class InfraccionDAO{


    private static final String SQL_SELECT_ALL = "SELECT * FROM infracciones;";
    private static final String SQL_SELECT = "SELECT * FROM infracciones WHERE id = ?;";
    private static final String SQL_INSERT = "INSERT INTO infracciones(articulo, titulo, descripcion, importe) VALUES(?, ?, ?, ?)";
    private static final String SQL_UPDATE = "UPDATE infracciones SET articulo=?, titulo=?, descripcion=?, importe=? WHERE id = ?";
    private static final String SQL_DELETE = "DELETE FROM infracciones WHERE id=?";

    private InfraccionDTO fromResultSet(ResultSet rs) throws SQLException {
        int id = rs.getInt("id");
        String articulo = rs.getString("articulo");
        String codigoPostal = rs.getString("titulo");
        String descripcion = rs.getString("descripcion");
        float importe = rs.getFloat("importe");
    
        InfraccionDTO infraccion = new InfraccionDTO(id, articulo, codigoPostal, descripcion, importe);
            
        return infraccion;
    } 
    
    public List<InfraccionDTO> selectAll() throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        InfraccionDTO infraccion = null;
        List<InfraccionDTO> infracciones = new ArrayList<InfraccionDTO>();

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT_ALL);
            rs = stmt.executeQuery();
            while (rs.next()) {
                infraccion = fromResultSet(rs);
                infracciones.add(infraccion);
            }
        }catch (SQLException ex) {
            infracciones=null;
        }
        return infracciones;
    }
     
    public InfraccionDTO select(int idInfraccion) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        InfraccionDTO infraccion = null;
        try {
            conn = Conexion.getConnection();
            if (conn != null) {
                stmt = conn.prepareStatement(SQL_SELECT);
                stmt.setInt(1, idInfraccion);
                rs = stmt.executeQuery();
                if (rs.next()) {
                    infraccion = fromResultSet(rs);
                }
            }
        }catch (SQLException ex) {
            infraccion=null;
        }
        return infraccion;
    }

    public int insert(InfraccionDTO infraccion) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, infraccion.getArticulo());
            stmt.setString(2, infraccion.getTitulo());
            stmt.setString(3, infraccion.getDescripcion());
            stmt.setFloat(4, infraccion.getImporte());

            System.out.println("ejecutando query:" + SQL_INSERT);
            rows = stmt.executeUpdate();
            System.out.println("Registros afectados:" + rows);
        }catch (SQLException ex) {
            rows = 0;
        }

        return rows;
    }

    public int update(InfraccionDTO infraccion) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            System.out.println("ejecutando query: " + SQL_UPDATE);
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, infraccion.getArticulo());
            stmt.setString(2, infraccion.getTitulo());
            stmt.setString(3, infraccion.getDescripcion());
            stmt.setFloat(4, infraccion.getImporte());
            stmt.setInt(5, infraccion.getId());

            rows = stmt.executeUpdate();
            System.out.println("Registros actualizado:" + rows);

        } catch (SQLException ex) {
            rows = 0;
        }

        return rows;
    }

    public int delete(InfraccionDTO infraccion) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_DELETE);
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, infraccion.getId());
            rows = stmt.executeUpdate();
            System.out.println("Registros eliminados:" + rows);
        }catch (SQLException ex) {
            rows = 0;
        }

        return rows;
    }
}