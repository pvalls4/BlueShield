package DAO;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Conexion {

    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
//    private static final String connectionString = System.getenv("AZURE_MYSQL_CONNECTIONSTRING");
    private static final Properties properties = new Properties();

    static {
        try (InputStream inputStream = Conexion.class.getClassLoader().getResourceAsStream("./config/config.properties")) {
            properties.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static final String DB_URL = properties.getProperty("JDBC_URL");
    private static final String DB_USER = properties.getProperty("JDBC_USER");
    private static final String DB_PASSWORD = properties.getProperty("JDBC_PASS");

    public static Connection getConnection() throws SQLException {
        Connection conn = null;
        try {
            Class.forName(DRIVER);
            conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
//            conn = DriverManager.getConnection(connectionString);
        } catch (SQLException e) {
            throw e;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return conn;
    }
}
