package DAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import model.DTO.*;

public class CondecoracionDAO {

    private static final String SQL_SELECT_ALL = "SELECT * FROM condecoraciones";
    private static final String SQL_SELECT = "SELECT * FROM condecoraciones WHERE id = ?";
    private static final String SQL_INSERT = "INSERT INTO condecoraciones(id, titulo, descripcion, foto) VALUES(?, ?, ?, ?)";
    private static final String SQL_UPDATE = "UPDATE condecoraciones SET titulo=?, descripcion=?, foto=? WHERE id = ?";
    private static final String SQL_DELETE = "DELETE FROM condecoraciones WHERE id=?";

    private CondecoracionDTO fromResultSet(ResultSet rs) throws SQLException {
        int id = rs.getInt("id");
        String titulo = rs.getString("titulo");
        String descripcion = rs.getString("descripcion");
        String foto = rs.getString("foto");

        CondecoracionDTO condecoracion = new CondecoracionDTO(id, titulo, descripcion, foto);

        return condecoracion;
    }

    public List<CondecoracionDTO> selectAll() throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        CondecoracionDTO condecoracion = null;
        List<CondecoracionDTO> condecoraciones = new ArrayList<CondecoracionDTO>();

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT_ALL);
            rs = stmt.executeQuery();
            while (rs.next()) {
                condecoracion = fromResultSet(rs);
                if (condecoracion != null) {
                    condecoraciones.add(condecoracion);
                }
            }
        } catch (SQLException ex) {
            condecoraciones = null;
        }

        return condecoraciones;
    }

    public CondecoracionDTO select(int id) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        CondecoracionDTO condecoracion = null;

        try {
            conn = Conexion.getConnection();
            if (conn != null) {
                stmt = conn.prepareStatement(SQL_SELECT);
                stmt.setInt(1, id);
                rs = stmt.executeQuery();
                if (rs.next()) {
                    condecoracion = fromResultSet(rs);
                }
            }
        } catch (SQLException ex) {
            condecoracion = null;
        }

        return condecoracion;
    }

    public int insert(CondecoracionDTO condecoracion) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setInt(1, condecoracion.getId());
            stmt.setString(2, condecoracion.getTitulo());
            stmt.setString(3, condecoracion.getDescripcion());
            stmt.setString(4, condecoracion.getFoto());
            rows = stmt.executeUpdate();
        } catch (SQLException ex) {
            rows = 0;
        }

        return rows;
    }

    public int update(CondecoracionDTO condecoracion) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, condecoracion.getTitulo());
            stmt.setString(2, condecoracion.getDescripcion());
            stmt.setString(3, condecoracion.getFoto());
            stmt.setInt(4, condecoracion.getId());

            rows = stmt.executeUpdate();
        } catch (SQLException ex) {
            rows = 0;
        }

        return rows;
    }

    public int delete(CondecoracionDTO condecoracion) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, condecoracion.getId());
            rows = stmt.executeUpdate();
        } catch (SQLException ex) {
            rows = 0;
        }

        return rows;
    }
}
