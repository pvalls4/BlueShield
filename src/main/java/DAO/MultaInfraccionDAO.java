package DAO;

import model.DTO.MultaInfraccionDTO;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import model.DTO.InfraccionDTO;
import model.DTO.MultaDTO;

public class MultaInfraccionDAO{


    private static final String SQL_SELECT_ALL = "SELECT * FROM multas_infracciones;";
    private static final String SQL_SELECT_INFRACCION = "SELECT * FROM multas_infracciones WHERE idInfraccion = ?;";
    private static final String SQL_SELECT_MULTA = "SELECT * FROM multas_infracciones WHERE idMulta = ?;";
    private static final String SQL_INSERT = "INSERT INTO multas_infracciones(idMulta, idInfraccion) VALUES(?, ?)";
    private static final String SQL_UPDATE = "UPDATE multas_infracciones SET idMulta = ?, idInfraccion = ? WHERE idMulta = ?";
    private static final String SQL_DELETE = "DELETE FROM multas_infracciones WHERE idMulta=?";

    private MultaInfraccionDTO fromResultSet(ResultSet rs) throws SQLException {
        int idMulta = rs.getInt("idMulta");
        int idInfraccion = rs.getInt("idInfraccion");
        
        MultaDTO multa = new MultaDAO().select(idMulta);
        InfraccionDTO infraccion = new InfraccionDAO().select(idInfraccion);
        
        MultaInfraccionDTO multasInfracciones = new MultaInfraccionDTO(multa,infraccion);
            
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
            stmt = conn.prepareStatement(SQL_SELECT_MULTA);
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
            
            System.out.println("ejecutando query:" + SQL_INSERT);
            rows = stmt.executeUpdate();
            System.out.println("Registros afectados:" + rows);
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
            System.out.println("ejecutando query: " + SQL_UPDATE);
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setInt(1, multaInfraccion.getMulta().getId());
            stmt.setInt(2, multaInfraccion.getInfraccion().getId());
 
            rows = stmt.executeUpdate();
            System.out.println("Registros actualizado:" + rows);

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
            System.out.println("Ejecutando query:" + SQL_DELETE);
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, multaInfraccion.getMulta().getId());
            rows = stmt.executeUpdate();
            System.out.println("Registros eliminados:" + rows);
        }catch (SQLException ex) {
            rows = 0;
        }
        return rows;
    }
}