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
        InfraccionDTO inf = null;
        List<InfraccionDTO> infracciones = new ArrayList<InfraccionDTO>();

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT_ALL);
            rs = stmt.executeQuery();
            while (rs.next()) {
                InfraccionDTO infraccion = fromResultSet(rs);
                infracciones.add(infraccion);
            }
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
        }
        return infracciones;
    }
     
    public InfraccionDTO select(int idDireccion) throws SQLException {
        InfraccionDTO result = null;
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = Conexion.getConnection();
            if (conn != null) {
                PreparedStatement st = conn.prepareStatement(SQL_SELECT);
                st.setInt(1, idDireccion);
                rs = st.executeQuery();
                if (rs.next()) {
                    result = fromResultSet(rs);
                }
            }
        }finally {
            Conexion.close(rs);
            Conexion.close(stmt);
        }
        return result;
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
        } finally {
            Conexion.close(stmt);
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
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, infraccion.getArticulo());
            stmt.setString(2, infraccion.getTitulo());
            stmt.setString(3, infraccion.getDescripcion());
            stmt.setFloat(4, infraccion.getImporte());

            rows = stmt.executeUpdate();
            System.out.println("Registros actualizado:" + rows);

        } finally {
            Conexion.close(stmt);
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
        } finally {
            Conexion.close(stmt);
        }

        return rows;
    }
}