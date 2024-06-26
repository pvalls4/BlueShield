package DAO;

import model.DTO.MultaDTO;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import model.DTO.AgenteDTO;
import model.DTO.CiudadanoDTO;
import model.DTO.InfraccionDTO;
import model.DTO.VehiculoDTO;

public class MultaDAO {

    private static final String SQL_SELECT_ALL = "SELECT * FROM multas;";
    private static final String SQL_SELECT = "SELECT * FROM multas WHERE id = ?;";
    private static final String SQL_SELECT_BASTIDOR = "SELECT * FROM multas WHERE bastidor = ?;";
    private static final String SQL_SELECT_DNI = "SELECT * FROM multas WHERE dniPropietario = ?;";
    private static final String SQL_SELECT_PLACA = "SELECT * FROM multas WHERE idPlaca = ? ORDER BY fecha_emision DESC LIMIT 10;";
    private static final String SQL_INSERT = "INSERT INTO multas(fecha_emision, fecha_limite, importe_total, observaciones, ubicacion, isPagado, idPlaca, dniPropietario, bastidor) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)";
    private static final String SQL_UPDATE = "UPDATE multas SET fecha_emision = ?, fecha_limite = ?, importe_total = ?, observaciones = ?, ubicacion = ?, isPagado = ?, idPlaca = ?, dniPropietario = ?, bastidor = ? WHERE id = ?";
    private static final String SQL_DELETE = "DELETE FROM multas WHERE id=?";

    private MultaDTO fromResultSet(ResultSet rs) throws SQLException {
        int id = rs.getInt("id");
        Date fechaEmision = rs.getDate("fecha_emision");
        Date fechaLimite = rs.getDate("fecha_limite");
        double importeTotal = rs.getDouble("importe_total");
        String ubicacion = rs.getString("ubicacion");
        String observaciones = rs.getString("observaciones");
        Boolean isPagado = rs.getBoolean("isPagado");
        int idPlaca = rs.getInt("idPlaca");
        String dniPropietario = rs.getString("dniPropietario");
        String bastidor = rs.getString("bastidor");
        AgenteDTO agente = new AgenteDAO().select(idPlaca);
        CiudadanoDTO ciudadano = new CiudadanoDAO().select(dniPropietario);
        VehiculoDTO vehiculo = new VehiculoDAO().select(bastidor);

        MultaDTO multa = new MultaDTO(id, fechaEmision, fechaLimite, importeTotal, observaciones, ubicacion, isPagado, agente, ciudadano, vehiculo);

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

    public List<MultaDTO> selectBASTIDOR(String bastidor) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        MultaDTO multa = null;
        List<MultaDTO> multas = new ArrayList<MultaDTO>();

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT_BASTIDOR);
            stmt.setString(1, bastidor);
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

    public int insert(MultaDTO multa, List<InfraccionDTO> infracciones) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT, Statement.RETURN_GENERATED_KEYS);
            stmt.setDate(1, multa.getFecha_emision());
            stmt.setDate(2, multa.getFecha_limite());
            stmt.setDouble(3, multa.getImporte_total());
            stmt.setString(4, multa.getObservaciones());
            stmt.setString(5, multa.getUbicacion());
            stmt.setBoolean(6, multa.isIsPagado());
            stmt.setInt(7, multa.getAgente().getPlaca());
            stmt.setString(8, multa.getCiudadano().getDni());
            // Set null if vehiculo is null, otherwise set the bastidor
            if (multa.getVehiculo() == null) {
                stmt.setNull(9, Types.VARCHAR);
            } else {
                stmt.setString(9, multa.getVehiculo().getBastidor());
            }
            rows = stmt.executeUpdate();
            ResultSet generatedKeys = stmt.getGeneratedKeys();
            int generatedId = -1;
            if (generatedKeys.next()) {
                generatedId = generatedKeys.getInt(1);
            } else {
                throw new SQLException("No se generó ningún ID.");
            }
            int rowMI = new MultaInfraccionDAO().insertALL(generatedId, infracciones);
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
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setDate(1, multa.getFecha_emision());
            stmt.setDate(2, multa.getFecha_limite());
            stmt.setDouble(3, multa.getImporte_total());
            stmt.setString(4, multa.getObservaciones());
            stmt.setString(5, multa.getUbicacion());
            stmt.setBoolean(6, multa.isIsPagado());
            stmt.setInt(7, multa.getAgente().getPlaca());
            stmt.setString(8, multa.getCiudadano().getDni());
            stmt.setString(9, multa.getVehiculo().getBastidor());
            stmt.setInt(10, multa.getId());

            rows = stmt.executeUpdate();
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
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, multa.getId());
            rows = stmt.executeUpdate();
        } catch (SQLException ex) {
            rows = 0;
        }
        return rows;
    }
}
