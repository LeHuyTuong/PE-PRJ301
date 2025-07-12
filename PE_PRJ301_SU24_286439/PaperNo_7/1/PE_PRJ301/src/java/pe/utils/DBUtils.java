package pe.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Do not change this code
 */
public class DBUtils {

    private static final String DB_NAME = "AppointmentManagement";
    private static final String PASSWORD = "12345";
    private static final String USER_NAME = "SA";

    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        Connection conn = null;
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        String url = "jdbc:sqlserver://localhost:1433;databaseName=" + DB_NAME;
        conn = DriverManager.getConnection(url, USER_NAME, PASSWORD);
        return conn;
    }

}
