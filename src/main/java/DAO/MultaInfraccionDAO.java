package DAO;

import model.DTO.MultaInfraccionDTO;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import model.DTO.InfraccionDTO;
import model.DTO.MultaDTO;

public class MultaInfraccionDAO {

    private static final String SQL_SELECT_ALL = "SELECT * FROM multas_infracciones;";
    private static final String SQL_SELECT_INFRACCION = "SELECT * FROM multas_infracciones WHERE idInfraccion = ?;";
    private static final String SQL_SELECT_MULTA = "SELECT * FROM multas_infracciones WHERE idMulta = ?;";
    private static final String SQL_SELECT_MULTAINFRACCION = "SELECT * FROM multas_infracciones WHERE idMulta = ? AND idInfraccion = ?;";
    private static final String SQL_INSERT = "INSERT INTO multas_infracciones(idMulta, idInfraccion) VALUES(?, ?)";
    private static final String SQL_UPDATE = "UPDATE multas_infracciones SET idMulta = ?, idInfraccion = ? WHERE idMulta = ?";
    private static final String SQL_DELETE = "DELETE FROM multas_infracciones WHERE idMulta=? AND idInfraccion = ?";

    private MultaInfraccionDTO fromResultSet(ResultSet rs) throws SQLException {
        int idMulta = rs.getInt("idMulta");
        int idInfraccion = rs.getInt("idInfraccion");

        MultaDTO multa = new MultaDAO().select(idMulta);
        InfraccionDTO infraccion = new InfraccionDAO().select(idInfraccion);

        MultaInfraccionDTO multasInfracciones = new MultaInfraccionDTO(multa, infraccion);

        return multasInfracciones;
    }

    public List<MultaInfraccionDTO> selectAll() throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        MultaInfraccionDTO multaInfraccion = null;
        List<MultaInfraccionDTO> multasInfracciones = new ArrayList<MultaInfraccionDTO>();

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT_ALL);
            rs = stmt.executeQuery();
            while (rs.next()) {
                multaInfraccion = fromResultSet(rs);
                multasInfracciones.add(multaInfraccion);
            }
        } catch (SQLException ex) {
            multasInfracciones = null;
        }
        return multasInfracciones;
    }

    public MultaInfraccionDTO selectIdMultaInfraccion(int idMulta, int idInfraccion) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        MultaInfraccionDTO result = null;

        try {
            conn = Conexion.getConnection();
            if (conn != null) {
                stmt = conn.prepareStatement(SQL_SELECT_MULTAINFRACCION);
                stmt.setInt(1, idMulta);
                stmt.setInt(2, idInfraccion);
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

    public List<MultaInfraccionDTO> selectIdMulta(int idMulta) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        MultaInfraccionDTO multaInfraccion = null;
        List<MultaInfraccionDTO> multasInfracciones = new ArrayList<MultaInfraccionDTO>();

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT_MULTA);
            stmt.setInt(1, idMulta);
            rs = stmt.executeQuery();
            while (rs.next()) {
                multaInfraccion = fromResultSet(rs);
                multasInfracciones.add(multaInfraccion);
            }
        } catch (SQLException ex) {
            multasInfracciones = null;
        }
        return multasInfracciones;
    }

    public List<MultaInfraccionDTO> selectIdInfraccion(int idInfraccion) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        MultaInfraccionDTO multaInfraccion = null;
        List<MultaInfraccionDTO> multasInfracciones = new ArrayList<MultaInfraccionDTO>();

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT_INFRACCION);
            stmt.setInt(1, idInfraccion);
            rs = stmt.executeQuery();
            while (rs.next()) {
                multaInfraccion = fromResultSet(rs);
                multasInfracciones.add(multaInfraccion);
            }
        } catch (SQLException ex) {
            multasInfracciones = null;
        }
        return multasInfracciones;
    }

    public int insert(MultaInfraccionDTO multaInfraccion) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setInt(1, multaInfraccion.getMulta().getId());
            stmt.setInt(2, multaInfraccion.getInfraccion().getId());

            rows = stmt.executeUpdate();
        } catch (SQLException ex) {
            rows = 0;
        }
        return rows;
    }

    public int insertALL(int idMulta, List<InfraccionDTO> infracciones) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);

            for (InfraccionDTO infraccion : infracciones) {
                stmt.setInt(1, idMulta);
                stmt.setInt(2, infraccion.getId());
                stmt.addBatch();
            }

            int[] insertedCounts = stmt.executeBatch();
            for (int count : insertedCounts) {
                rows += count;
            }

        } catch (SQLException ex) {
            rows = 0;
        }

        return rows;
    }

    public int update(MultaInfraccionDTO multaInfraccion) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setInt(1, multaInfraccion.getMulta().getId());
            stmt.setInt(2, multaInfraccion.getInfraccion().getId());

            rows = stmt.executeUpdate();
        } catch (SQLException ex) {
            rows = 0;
        }

        return rows;
    }

    public int delete(MultaInfraccionDTO multaInfraccion) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, multaInfraccion.getMulta().getId());
            stmt.setInt(2, multaInfraccion.getInfraccion().getId());
            rows = stmt.executeUpdate();
        } catch (SQLException ex) {
            rows = 0;
        }
        return rows;
    }
}
