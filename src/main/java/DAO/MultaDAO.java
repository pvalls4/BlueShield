package DAO;

import model.DTO.MultaDTO;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import model.DTO.AgenteDTO;
import model.DTO.CiudadanoDTO;
import model.DTO.VehiculoDTO;

public class MultaDAO {

    private static final String SQL_SELECT_ALL = "SELECT * FROM multas;";
    private static final String SQL_SELECT = "SELECT * FROM multas WHERE id = ?;";
    private static final String SQL_SELECT_DNI = "SELECT * FROM multas WHERE dniPropietario = ?;";
    private static final String SQL_SELECT_PLACA = "SELECT * FROM multas WHERE idPlaca = ?;";
    private static final String SQL_INSERT = "INSERT INTO multas(fecha_emision, fecha_limite, importe_total, observaciones, isPagado, idPlaca, dniPropietario, bastidor) VALUES(?, ?, ?, ?, ?, ?, ?, ?)";
    private static final String SQL_UPDATE = "UPDATE multas SET fecha_emision = ?, fecha_limite = ?, importe_total = ?, observaciones = ?, isPagado = ?, idPlaca = ?, dniPropietario = ?, bastidor = ? WHERE id = ?";
    private static final String SQL_DELETE = "DELETE FROM multas WHERE id=?";

    private MultaDTO fromResultSet(ResultSet rs) throws SQLException {
        int id = rs.getInt("id");
        Date fechaEmision = rs.getDate("fecha_emision");
        Date fechaLimite = rs.getDate("fecha_limite");
        double importeTotal = rs.getDouble("importe_total");
        String observaciones = rs.getString("observaciones");
        Boolean isPagado = rs.getBoolean("isPagado");
        int idPlaca = rs.getInt("idPlaca");
        String dniPropietario = rs.getString("dniPropietario");
        String bastidor = rs.getString("bastidor");
        AgenteDTO agente = new AgenteDAO().select(idPlaca);
        CiudadanoDTO ciudadano = new CiudadanoDAO().select(dniPropietario);
        VehiculoDTO vehiculo = new VehiculoDAO().select(bastidor);

        MultaDTO multa = new MultaDTO(id, fechaEmision, fechaLimite, importeTotal, observaciones, isPagado, agente, ciudadano, vehiculo);

        return multa;
    }

    public List<MultaDTO> selectAll() throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        MultaDTO multa = null;
        List<MultaDTO> multas = new ArrayList<MultaDTO>();

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT_ALL);
            rs = stmt.executeQuery();
            while (rs.next()) {
                multa = fromResultSet(rs);
                multas.add(multa);
            }
        } catch (SQLException ex) {
            multas = null;
        }
        return multas;
    }

    public List<MultaDTO> selectDNI(String dniPropietario) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        MultaDTO multa = null;
        List<MultaDTO> multas = new ArrayList<MultaDTO>();

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT_DNI);
            stmt.setString(1, dniPropietario);
            rs = stmt.executeQuery();
            while (rs.next()) {
                multa = fromResultSet(rs);
                multas.add(multa);
            }
        } catch (SQLException ex) {
            multas = null;
        }
        return multas;
    }

    public List<MultaDTO> selectPlaca(int idPlaca) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        MultaDTO multa = null;
        List<MultaDTO> multas = new ArrayList<MultaDTO>();

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT_PLACA);
            stmt.setInt(1, idPlaca);
            rs = stmt.executeQuery();
            while (rs.next()) {
                multa = fromResultSet(rs);
                multas.add(multa);
            }
        } catch (SQLException ex) {
            multas = null;
        }
        return multas;
    }

    public MultaDTO select(int idMulta) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        MultaDTO result = null;

        try {
            conn = Conexion.getConnection();
            if (conn != null) {
                stmt = conn.prepareStatement(SQL_SELECT);
                stmt.setInt(1, idMulta);
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

    public int insert(MultaDTO multa) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setDate(1, multa.getFecha_emision());
            stmt.setDate(2, multa.getFecha_limite());
            stmt.setDouble(3, multa.getImporte_total());
            stmt.setString(4, multa.getObservaciones());
            stmt.setBoolean(5, multa.isIsPagado());
            stmt.setInt(6, multa.getAgente().getPlaca());
            stmt.setString(7, multa.getCiudadano().getDni());
            stmt.setString(8, multa.getVehiculo().getBastidor());

            System.out.println("ejecutando query:" + SQL_INSERT);
            rows = stmt.executeUpdate();
            System.out.println("Registros afectados:" + rows);
        } catch (SQLException ex) {
            rows = 0;
        }
        return rows;
    }

    public int update(MultaDTO multa) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            System.out.println("ejecutando query: " + SQL_UPDATE);
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setDate(1, multa.getFecha_emision());
            stmt.setDate(2, multa.getFecha_limite());
            stmt.setDouble(3, multa.getImporte_total());
            stmt.setString(4, multa.getObservaciones());
            stmt.setBoolean(5, multa.isIsPagado());
            stmt.setInt(6, multa.getAgente().getPlaca());
            stmt.setString(7, multa.getCiudadano().getDni());
            stmt.setString(8, multa.getVehiculo().getBastidor());
            stmt.setInt(9, multa.getId());

            rows = stmt.executeUpdate();
            System.out.println("Registros actualizado:" + rows);

        } catch (SQLException ex) {
            rows = 0;
        }

        return rows;
    }

    public int delete(MultaDTO multa) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_DELETE);
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, multa.getId());
            rows = stmt.executeUpdate();
            System.out.println("Registros eliminados:" + rows);
        } catch (SQLException ex) {
            rows = 0;
        }
        return rows;
    }
}
