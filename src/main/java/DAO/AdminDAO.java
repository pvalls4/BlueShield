package DAO;

import model.DTO.AdminDTO;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AdminDAO{


    private static final String SQL_SELECT_ALL = "SELECT * FROM admins;";
    private static final String SQL_SELECT = "SELECT * FROM admins WHERE id = ?;";
    private static final String SQL_INSERT = "INSERT INTO admins(email, password) VALUES(?, ?)";
    private static final String SQL_UPDATE = "UPDATE admins SET email=?, password=? WHERE id = ?";
    private static final String SQL_DELETE = "DELETE FROM admins WHERE id=?";

    private AdminDTO fromResultSet(ResultSet rs) throws SQLException {
        int id = rs.getInt("id");
        String email = rs.getString("email");
        String password = rs.getString("password");
    
        AdminDTO admin = new AdminDTO(id, email, password);
            
        return admin;
    } 
    
    public List<AdminDTO> selectAll() throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        AdminDTO admin = null;
        List<AdminDTO> admines = new ArrayList<AdminDTO>();

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT_ALL);
            rs = stmt.executeQuery();
            while (rs.next()) {
                admin = fromResultSet(rs);
                admines.add(admin);
            }
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
        }
        return admines;
    }
     
    public AdminDTO select(int idAdmin) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        AdminDTO result = null;
        
        try {
            conn = Conexion.getConnection();
            if (conn != null) {
                stmt = conn.prepareStatement(SQL_SELECT);
                stmt.setInt(1, idAdmin);
                rs = stmt.executeQuery();
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

    public int insert(AdminDTO admin) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, admin.getEmail());
            stmt.setString(2, admin.getPassword());

            System.out.println("ejecutando query:" + SQL_INSERT);
            rows = stmt.executeUpdate();
            System.out.println("Registros afectados:" + rows);
        } finally {
            Conexion.close(stmt);
        }

        return rows;
    }

    public int update(AdminDTO admin) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            System.out.println("ejecutando query: " + SQL_UPDATE);
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, admin.getEmail());
            stmt.setString(2, admin.getPassword());
            stmt.setInt(3, admin.getId());

            rows = stmt.executeUpdate();
            System.out.println("Registros actualizado:" + rows);

        } finally {
            Conexion.close(stmt);
        }

        return rows;
    }

    public int delete(AdminDTO admin) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_DELETE);
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, admin.getId());
            rows = stmt.executeUpdate();
            System.out.println("Registros eliminados:" + rows);
        } finally {
            Conexion.close(stmt);
        }

        return rows;
    }
}