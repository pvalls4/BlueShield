package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.DTO.*;

public class TokensDAO {

    private static final String SQL_SELECT_ALL = "SELECT * FROM tokens;";
    private static final String SQL_SELECT = "SELECT * FROM tokens WHERE id = ?;";
    private static final String SQL_INSERT = "INSERT INTO tokens(token, estado, tipo, idAdmins, idAgentes) VALUES(?, ?, ?, ?, ?)";
    private static final String SQL_UPDATE = "UPDATE tokens SET token=?, estado=?, tipo=?, idAdmins=?, idAgentes=? WHERE id = ?";
    private static final String SQL_DELETE = "DELETE FROM tokens WHERE id=?";

    private TokensDTO fromResultSet(ResultSet rs) throws SQLException {
        int id = rs.getInt("id");
        String token = rs.getString("token");
        TokensDTO.Estado estado = TokensDTO.Estado.valueOf(rs.getString("estado"));
        TokensDTO.Tipo tipo = TokensDTO.Tipo.valueOf(rs.getString("tipo"));
       
        int idAdmins = rs.getInt("idAdmins");
        AdminDTO admin=new AdminDAO().select(idAdmins);
        
        int idAgentes = rs.getInt("idAgentes");
        AgenteDTO agente=null; //new AgenteDAO().select(idAgentes);

        TokensDTO tokensDTO = new TokensDTO(id, token, estado, tipo, admin, agente);

        return tokensDTO;
    }

    public List<TokensDTO> selectAll() throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        TokensDTO tokensDTO = null;
        List<TokensDTO> tokens = new ArrayList<TokensDTO>();

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT_ALL);
            rs = stmt.executeQuery();
            while (rs.next()) {
                tokensDTO = fromResultSet(rs);
                tokens.add(tokensDTO);
            }
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
        }
        return tokens;
    }

    public TokensDTO select(int id) throws SQLException {
        TokensDTO tokenDTO = null;
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = Conexion.getConnection();
            if (conn != null) {
                stmt = conn.prepareStatement(SQL_SELECT);
                stmt.setInt(1, id);
                rs = stmt.executeQuery();
                if (rs.next()) {
                    tokenDTO = fromResultSet(rs);
                }
            }
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
        }
        return tokenDTO;
    }

    public int insert(TokensDTO tokens) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, tokens.getToken());
            stmt.setString(2, tokens.getEstado().name());
            stmt.setString(3, tokens.getTipo().name());
            stmt.setInt(4, tokens.getAdmin().getId());
            stmt.setInt(5, tokens.getAgente().getPlaca());

            System.out.println("ejecutando query:" + SQL_INSERT);
            rows = stmt.executeUpdate();
            System.out.println("Registros afectados:" + rows);
        } finally {
            Conexion.close(stmt);
        }

        return rows;
    }

    public int update(TokensDTO tokens) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            System.out.println("ejecutando query: " + SQL_UPDATE);
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, tokens.getToken());
            stmt.setString(2, tokens.getEstado().name());
            stmt.setString(3, tokens.getTipo().name());
            stmt.setInt(4, tokens.getAdmin().getId());
            stmt.setInt(5, tokens.getAgente().getPlaca());
            stmt.setInt(6, tokens.getId());

            rows = stmt.executeUpdate();
            System.out.println("Registros actualizado:" + rows);

        } finally {
            Conexion.close(stmt);
        }

        return rows;
    }

    public int delete(TokensDTO tokens) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_DELETE);
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, tokens.getId());
            rows = stmt.executeUpdate();
            System.out.println("Registros eliminados:" + rows);
        } finally {
            Conexion.close(stmt);
        }

        return rows;
    }
}
