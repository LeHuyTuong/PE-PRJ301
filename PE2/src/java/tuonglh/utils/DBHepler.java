/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tuonglh.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author USER
 */
public class DBHepler {
    public static Connection makeConnection()
    throws ClassNotFoundException,SQLException {
        //1. Load Driver
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        
        //2. Create connection String to connect container
        // syntax: jdbc:sqlserver://ip:port;databaseName=PRJSE1809
        
        String url= "jdbc:sqlserver://"
                + "localhost:1433;"
                + "databaseName=PRJSE1809";
        //3. Open connect using Driver Manager
        Connection con = DriverManager.getConnection(url, "sa", "12345");
        return con;
    }
}
