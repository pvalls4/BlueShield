package DAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import model.DTO.CiudadanoDTO;
import model.DTO.ModeloDTO;
import model.DTO.VehiculoDTO;

public class VehiculoDAO {

    private static final String SQL_SELECT_ALL = "SELECT * FROM vehiculos";
    private static final String SQL_SELECT = "SELECT * FROM vehiculos WHERE bastidor = ?";
    private static final String SQL_INSERT = "INSERT INTO persona(bastidor, matricula, dniPropietario, idModelo) VALUES(?, ?, ?, ?)";
    private static final String SQL_UPDATE = "UPDATE persona SET bastidor=?, matricula=?, dniPropietario=?, idModelo=? WHERE bastidor = ?";
    private static final String SQL_DELETE = "DELETE FROM persona WHERE bastidor=?";

    private VehiculoDTO fromResultSet(ResultSet rs) throws SQLException {
        String bastidor = rs.getString("bastidor");
        String matricula = rs.getString("matricula");
        
        int dniPropietario=Integer.parseInt(rs.getString("dniPropietario"));
        CiudadanoDTO ciudadano = new CiudadanoDAO().select(dniPropietario);
        
        int idModelo=Integer.parseInt(rs.getString("idModelo"));
        ModeloDTO modelo=new ModeloDAO().select(idModelo);

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
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
        }

        return vehiculos;
    }

    public VehiculoDTO select(int bastidor) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        VehiculoDTO vehiculo = null;

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            stmt.setInt(1, bastidor);
            rs = stmt.executeQuery();
            if (rs.next()) {
                vehiculo = fromResultSet(rs);
            }
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
        }

        return vehiculo;
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
        } finally {
            Conexion.close(stmt);
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
            stmt.setString(1, vehiculo.getBastidor());
            stmt.setString(2, vehiculo.getMatricula());
            stmt.setString(3, vehiculo.getCiudadano().getDni());
            stmt.setInt(4, vehiculo.getModelo().getId());

            rows = stmt.executeUpdate();
            System.out.println("Registros actualizado:" + rows);

        } finally {
            Conexion.close(stmt);
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
        } finally {
            Conexion.close(stmt);
        }

        return rows;
    }
}
