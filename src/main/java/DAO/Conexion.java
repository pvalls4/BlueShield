package DAO;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sql.DataSource;
import org.apache.commons.dbcp2.BasicDataSource;

public class Conexion {
    public static final Properties properties = new Properties();

    static {
        String filename = "config.properties";
        try (InputStream input = Conexion.class.getClassLoader().getResourceAsStream(filename)) {
            if(input==null){
                throw new RuntimeException("Sorry, unable to find " + filename);
            }

            //load a properties file from class path
            properties.load(input);

        } catch (IOException ex) {
            ex.printStackTrace();
        }  
    }

    private static final String JDBC_URL = properties.getProperty("JDBC_URL");
    private static final String JDBC_USER = properties.getProperty("JDBC_USER");
    private static final String JDBC_PASS = properties.getProperty("JDBC_PASS");
    private static BasicDataSource dataSource;
    
    public static DataSource getDataSource() {
        if (dataSource == null) {
            dataSource = new BasicDataSource();
            dataSource.setUrl(JDBC_URL);
            dataSource.setUsername(JDBC_USER);
            dataSource.setPassword(JDBC_PASS);
            dataSource.setInitialSize(50);
        }
        return dataSource;
    }
    
    public static Connection getConnection() throws SQLException {
        return getDataSource().getConnection();
    }
    
    public static void close(ResultSet rs) {
        try {
            rs.close();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
    }

    public static void close(PreparedStatement stmt) {
        try {
            stmt.close();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
    }

    public static void close(Connection conn) {
        try {
            conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
    }
}