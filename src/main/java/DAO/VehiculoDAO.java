package DAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import model.DTO.*;

public class VehiculoDAO {

    private static final String SQL_SELECT_ALL = "SELECT * FROM vehiculos";
    private static final String SQL_SELECT = "SELECT * FROM vehiculos WHERE bastidor = ?";
    private static final String SQL_SELECT_MATRICULA = "SELECT * FROM vehiculos WHERE matricula = ?";
    private static final String SQL_SELECT_DNI = "SELECT * FROM vehiculos WHERE dniPropietario = ?;";
    private static final String SQL_INSERT = "INSERT INTO vehiculos(bastidor, matricula, dniPropietario, idModelo) VALUES(?, ?, ?, ?)";
    private static final String SQL_UPDATE = "UPDATE vehiculos SET matricula=?, dniPropietario=?, idModelo=? WHERE bastidor = ?";
    private static final String SQL_DELETE = "DELETE FROM vehiculos WHERE bastidor=?";

    private VehiculoDTO fromResultSet(ResultSet rs) throws SQLException {
        String bastidor = rs.getString("bastidor");
        String matricula = rs.getString("matricula");

        String dniPropietario = rs.getString("dniPropietario");
        CiudadanoDTO ciudadano = new CiudadanoDAO().select(dniPropietario);

        int idModelo = rs.getInt("idModelo");
        ModeloDTO modelo = new ModeloDAO().select(idModelo);

        VehiculoDTO vehiculo = new VehiculoDTO(bastidor, matricula, ciudadano, modelo);

        return vehiculo;
    }

    public List<VehiculoDTO> selectAll() throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        VehiculoDTO vehiculo = null;
        List<VehiculoDTO> vehiculos = new ArrayList<VehiculoDTO>();

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT_ALL);
            rs = stmt.executeQuery();
            while (rs.next()) {
                vehiculo = fromResultSet(rs);
                if (vehiculo != null) {
                    vehiculos.add(vehiculo);
                }
            }
        } catch (SQLException ex) {
            vehiculos = null;
        }

        return vehiculos;
    }

    public VehiculoDTO select(String bastidor) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        VehiculoDTO vehiculo = null;

        try {
            conn = Conexion.getConnection();
            if (conn != null) {
                stmt = conn.prepareStatement(SQL_SELECT);
                stmt.setString(1, bastidor);
                rs = stmt.executeQuery();
                if (rs.next()) {
                    vehiculo = fromResultSet(rs);
                }
            }
        } catch (SQLException ex) {
            vehiculo = null;
        }

        return vehiculo;
    }
    
    public VehiculoDTO selectMATRICULA(String matricula) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        VehiculoDTO vehiculo = null;

        try {
            conn = Conexion.getConnection();
            if (conn != null) {
                stmt = conn.prepareStatement(SQL_SELECT_MATRICULA);
                stmt.setString(1, matricula);
                rs = stmt.executeQuery();
                if (rs.next()) {
                    vehiculo = fromResultSet(rs);
                }
            }
        } catch (SQLException ex) {
            vehiculo = null;
        }

        return vehiculo;
    }
    
    
    public List<VehiculoDTO> selectDNI(String dniPropietario) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        VehiculoDTO vehiculo = null;
        List<VehiculoDTO> vehiculos = new ArrayList<VehiculoDTO>();

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT_DNI);
            stmt.setString(1, dniPropietario);
            rs = stmt.executeQuery();
            while (rs.next()) {
                vehiculo = fromResultSet(rs);
                vehiculos.add(vehiculo);
            }
        } catch (SQLException ex) {
            vehiculos = null;
        }
        return vehiculos;
    }


    public int insert(VehiculoDTO vehiculo) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, vehiculo.getBastidor());
            stmt.setString(2, vehiculo.getMatricula());
            stmt.setString(3, vehiculo.getCiudadano().getDni());
            stmt.setInt(4, vehiculo.getModelo().getId());

            System.out.println("ejecutando query:" + SQL_INSERT);
            rows = stmt.executeUpdate();
            System.out.println("Registros afectados:" + rows);
        } catch (SQLException ex) {
            rows=0;
        }

        return rows;
    }

    public int update(VehiculoDTO vehiculo) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            System.out.println("ejecutando query: " + SQL_UPDATE);
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, vehiculo.getMatricula());
            stmt.setString(2, vehiculo.getCiudadano().getDni());
            stmt.setInt(3, vehiculo.getModelo().getId());
            stmt.setString(4, vehiculo.getBastidor());


            rows = stmt.executeUpdate();
            System.out.println("Registros actualizado:" + rows);

        } catch (SQLException ex) {
            rows=0;
        }

        return rows;
    }

    public int delete(VehiculoDTO vehiculo) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_DELETE);
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setString(1, vehiculo.getBastidor());
            rows = stmt.executeUpdate();
            System.out.println("Registros eliminados:" + rows);
        } catch (SQLException ex) {
            rows=0;
        }
        return rows;
    }
}
