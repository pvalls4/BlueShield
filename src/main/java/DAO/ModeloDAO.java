package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.DTO.ModeloDTO;
import model.DTO.VehiculoDTO;

public class ModeloDAO {

    private static final String SQL_SELECT_ALL = "SELECT * FROM modelos";
    private static final String SQL_SELECT = "SELECT * FROM modelos WHERE id= ?";
    private static final String SQL_INSERT = "INSERT INTO modelos(marca, modelo, imagen) VALUES(?, ?, ?)";
    private static final String SQL_UPDATE = "UPDATE modelos SET marca=?, modelo=?, image=? WHERE id = ?";
    private static final String SQL_DELETE = "DELETE FROM modelos WHERE id=?";

    private ModeloDTO fromResultSet(ResultSet rs) throws SQLException {
        String marca = rs.getString("marca");
        String modelo = rs.getString("modelo");
        String imagen = rs.getString("imagen");

        ModeloDTO modeloDTO = new ModeloDTO(marca, modelo, imagen);

        return modeloDTO;
    }

    public List<ModeloDTO> selectAll() throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        ModeloDTO modeloDTO = null;
        List<ModeloDTO> modelos = new ArrayList<ModeloDTO>();

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT_ALL);
            rs = stmt.executeQuery();
            while (rs.next()) {
                modeloDTO = fromResultSet(rs);
                if (modeloDTO != null) {
                    modelos.add(modeloDTO);
                }
            }
        } catch (SQLException ex) {
            modelos=null;
        }

        return modelos;
    }

    public ModeloDTO select(int id) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        ModeloDTO modeloDTO = null;

        try {
            conn = Conexion.getConnection();
            if (conn != null) {
                stmt = conn.prepareStatement(SQL_SELECT);
                stmt.setInt(1, id);
                rs = stmt.executeQuery();
                if (rs.next()) {
                    modeloDTO = fromResultSet(rs);
                }
            }
        } catch (SQLException ex) {
            modeloDTO=null;
        }

        return modeloDTO;
    }

    public int insert(ModeloDTO modeloDTO) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, modeloDTO.getMarca());
            stmt.setString(2, modeloDTO.getModelo());
            stmt.setString(3, modeloDTO.getImagen());

            System.out.println("ejecutando query:" + SQL_INSERT);
            rows = stmt.executeUpdate();
            System.out.println("Registros afectados:" + rows);
        } catch (SQLException ex) {
            rows = 0;
        }

        return rows;
    }

    public int update(ModeloDTO modeloDTO) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            System.out.println("ejecutando query: " + SQL_UPDATE);
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, modeloDTO.getMarca());
            stmt.setString(2, modeloDTO.getModelo());
            stmt.setString(3, modeloDTO.getImagen());
            stmt.setInt(4, modeloDTO.getId());

            rows = stmt.executeUpdate();
            System.out.println("Registros actualizado:" + rows);

        } catch (SQLException ex) {
            rows = 0;
        }

        return rows;
    }

    public int delete(ModeloDTO modeloDTO) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_DELETE);
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, modeloDTO.getId());
            rows = stmt.executeUpdate();
            System.out.println("Registros eliminados:" + rows);
        } catch (SQLException ex) {
            rows = 0;
        }

        return rows;
    }
}
