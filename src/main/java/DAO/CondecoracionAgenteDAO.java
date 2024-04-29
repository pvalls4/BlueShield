package DAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import model.DTO.*;

public class CondecoracionAgenteDAO {

    private static final String SQL_SELECT_ALL = "SELECT * FROM condecoraciones_agentes";
    private static final String SQL_SELECT_BY_COND = "SELECT * FROM condecoraciones_agentes WHERE idCondecoracion = ?";
    private static final String SQL_SELECT_BY_AGENTE = "SELECT * FROM condecoraciones_agentes WHERE idAgente = ?";
    private static final String SQL_INSERT = "INSERT INTO condecoraciones_agentes(idCondecoracion, idAgente, fecha_emision) VALUES(?, ?, ?)";
    private static final String SQL_UPDATE = "UPDATE condecoraciones_agentes SET fecha_emision=? WHERE idCondecoracion = ? AND idAgente = ?";
    private static final String SQL_DELETE = "DELETE FROM condecoraciones_agentes WHERE idCondecoracion = ? AND idAgente = ?";

    private CondecoracionAgenteDTO fromResultSet(ResultSet rs) throws SQLException {
        int idCondecoracion = rs.getInt("idCondecoracion");
        int idAgente = rs.getInt("idAgente");
        Date fecha_emision = rs.getDate("fecha_emision");
        
        CondecoracionDTO condecoracion = new CondecoracionDAO().select(idCondecoracion);
        AgenteDTO agente = new AgenteDAO().select(idAgente);

        CondecoracionAgenteDTO condecoracionAgente = new CondecoracionAgenteDTO(condecoracion, agente, fecha_emision);

        return condecoracionAgente;
    }

    public List<CondecoracionAgenteDTO> selectAll() throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        CondecoracionAgenteDTO condecoracionAgente = null;
        List<CondecoracionAgenteDTO> condecoracionesAgentes = new ArrayList<CondecoracionAgenteDTO>();

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT_ALL);
            rs = stmt.executeQuery();
            while (rs.next()) {
                condecoracionAgente = fromResultSet(rs);
                if (condecoracionAgente != null) {
                    condecoracionesAgentes.add(condecoracionAgente);
                }
            }
        }  catch (SQLException ex) {
            System.out.println(ex);
            condecoracionesAgentes = null;
        }

        return condecoracionesAgentes;
    }
    
    public List<CondecoracionAgenteDTO> selectByAgente(int idAgente) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        CondecoracionAgenteDTO condecoracionAgente = null;
        List<CondecoracionAgenteDTO> condecoracionesAgentes = new ArrayList<CondecoracionAgenteDTO>();

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT_BY_AGENTE);
            stmt.setInt(1, idAgente);
            rs = stmt.executeQuery();
            while (rs.next()) {
                condecoracionAgente = fromResultSet(rs);
                if (condecoracionAgente != null) {
                    condecoracionesAgentes.add(condecoracionAgente);
                }
            }
        }  catch (SQLException ex) {
            System.out.println(ex);
            condecoracionesAgentes = null;
        }

        return condecoracionesAgentes;
    }

    public List<CondecoracionAgenteDTO> selectByCond(int idCondecoracion) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        CondecoracionAgenteDTO agenteCondecoracion = null;
        List<CondecoracionAgenteDTO> agentesCondecoracion = new ArrayList<CondecoracionAgenteDTO>();

        try {
            conn = Conexion.getConnection();
            if (conn != null) {
                stmt = conn.prepareStatement(SQL_SELECT_BY_COND);
                stmt.setInt(1, idCondecoracion);
                rs = stmt.executeQuery();
                while (rs.next()) {
                    agenteCondecoracion = fromResultSet(rs);
                    if (agenteCondecoracion != null) {
                        agentesCondecoracion.add(agenteCondecoracion);
                    }
                }
            }
        } catch (SQLException ex) {
            agentesCondecoracion = null;
        }

        return agentesCondecoracion;
    }

    public int insert(CondecoracionAgenteDTO condecoracionAgente) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setInt(1, condecoracionAgente.getCondecoracion().getId());
            stmt.setInt(2, condecoracionAgente.getAgente().getPlaca());
            stmt.setDate(3, condecoracionAgente.getFecha_emision());
            rows = stmt.executeUpdate();
        } catch (SQLException ex) {
            rows = 0;
        }

        return rows;
    }

    public int update(CondecoracionAgenteDTO condecoracionAgente) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setDate(1, condecoracionAgente.getFecha_emision());

            //set del id a cambiar
            stmt.setInt(2, condecoracionAgente.getCondecoracion().getId());
            stmt.setInt(3, condecoracionAgente.getAgente().getPlaca());

            rows = stmt.executeUpdate();
        } catch (SQLException ex) {
            rows = 0;
        }

        return rows;
    }

    public int delete(CondecoracionAgenteDTO condecoracionAgente) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, condecoracionAgente.getCondecoracion().getId());
            stmt.setInt(2, condecoracionAgente.getAgente().getPlaca());
            rows = stmt.executeUpdate();
        } catch (SQLException ex) {
            rows = 0;
        }

        return rows;
    }
}