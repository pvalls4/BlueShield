package DAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import model.DTO.*;

public class CiudadanoDAO {

    private static final String SQL_SELECT_ALL = "SELECT * FROM ciudadanos";
    private static final String SQL_SELECT = "SELECT * FROM ciudadanos WHERE dni = ?";
    private static final String SQL_INSERT = "INSERT INTO ciudadanos(dni, nombre, apellidos, fecha_nacimiento, telefono, email, isDeceased, imagen, idDirecciones) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)";
    private static final String SQL_UPDATE = "UPDATE ciudadanos SET nombre=?, apellidos=?, fecha_nacimiento=?, telefono=?, email=?, isDeceased=?, imagen=?, idDirecciones=? WHERE dni = ?";
    private static final String SQL_DELETE = "DELETE FROM ciudadanos WHERE dni=?";

    private CiudadanoDTO fromResultSet(ResultSet rs) throws SQLException {
        String dni = rs.getString("dni");
        String nombre = rs.getString("nombre");
        String apellidos = rs.getString("apellidos");
        Date fecha_nacimiento = rs.getDate("fecha_nacimiento");
        int telefono = rs.getInt("telefono");
        String email = rs.getString("email");
        boolean isDeceased = rs.getBoolean("isDeceased");
        String imagen = rs.getString("imagen");

        int idDirecciones = rs.getInt("idDirecciones");
        DireccionDTO direccion = new DireccionDAO().select(idDirecciones);

        CiudadanoDTO ciudadano = new CiudadanoDTO(dni, nombre, apellidos, fecha_nacimiento, telefono, email, isDeceased, direccion, imagen);

        return ciudadano;
    }

    public List<CiudadanoDTO> selectAll() throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        CiudadanoDTO ciudadano = null;
        List<CiudadanoDTO> ciudadanos = new ArrayList<CiudadanoDTO>();

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT_ALL);
            rs = stmt.executeQuery();
            while (rs.next()) {
                ciudadano = fromResultSet(rs);
                if (ciudadano != null) {
                    ciudadanos.add(ciudadano);
                }
            }
        } catch (SQLException ex) {
            ciudadanos = null;
        }

        return ciudadanos;
    }

    public List<String> selectALL_dni() throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String dni = null;
        List<String> dnis = new ArrayList<String>();

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT_ALL);
            rs = stmt.executeQuery();
            while (rs.next()) {
                dni = rs.getString("dni");
                if (rs != null) {
                    dnis.add(dni);
                }
            }
        } catch (SQLException ex) {
            dnis = null;
        }
        return dnis;
    }

    public CiudadanoDTO select(String dni) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        CiudadanoDTO ciudadano = null;

        try {
            conn = Conexion.getConnection();
            if (conn != null) {
                stmt = conn.prepareStatement(SQL_SELECT);
                stmt.setString(1, dni);
                rs = stmt.executeQuery();
                if (rs.next()) {
                    ciudadano = fromResultSet(rs);
                }
            }
        } catch (SQLException ex) {
            ciudadano = null;
        }
        return ciudadano;
    }

    public int insert(CiudadanoDTO ciudadano) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, ciudadano.getDni());
            stmt.setString(2, ciudadano.getNombre());
            stmt.setString(3, ciudadano.getApellidos());
            stmt.setDate(4, ciudadano.getFecha_nacimiento());
            stmt.setInt(5, ciudadano.getTelefono());
            stmt.setString(6, ciudadano.getEmail());
            stmt.setBoolean(7, ciudadano.isIsDeceased());
            stmt.setString(8, ciudadano.getEnlaceFotografico());
            stmt.setInt(9, ciudadano.getDireccion().getId());

            rows = stmt.executeUpdate();
        } catch (SQLException ex) {
            rows = 0;
        }

        return rows;
    }

    public int update(CiudadanoDTO ciudadano) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, ciudadano.getNombre());
            stmt.setString(2, ciudadano.getApellidos());
            stmt.setDate(3, ciudadano.getFecha_nacimiento());
            stmt.setInt(4, ciudadano.getTelefono());
            stmt.setString(5, ciudadano.getEmail());
            stmt.setBoolean(6, ciudadano.isIsDeceased());
            stmt.setString(7, ciudadano.getEnlaceFotografico());
            stmt.setInt(8, ciudadano.getDireccion().getId());

            stmt.setString(9, ciudadano.getDni());

            rows = stmt.executeUpdate();
        } catch (SQLException ex) {
            rows = 0;
        }

        return rows;
    }

    public int delete(CiudadanoDTO ciudadano) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setString(1, ciudadano.getDni());
            rows = stmt.executeUpdate();
        } catch (SQLException ex) {
            rows = 0;
        }

        return rows;
    }
}
