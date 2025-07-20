/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author hoadnt
 */
public class DBUtils {
    
    private static final String DB_NAME="RoomManagement";
    private static final String USER_NAME="SA";
    private static final String PASSWORD="12345";
    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        Connection conn= null;
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        String url="jdbc:sqlserver://localhost:1433;databaseName="+ DB_NAME;
        conn= DriverManager.getConnection(url, USER_NAME, PASSWORD);
        return conn;
    }
    
}
