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
public class DBHeper {
   public static Connection makeConnection()
   throws SQLException, ClassNotFoundException{
       Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        String url= "jdbc:sqlserver://"
                + "localhost:1433;"
                + "databaseName=PRJSE1809";
        //3. Open connect using Driver Manager
        Connection con = DriverManager.getConnection(url, "sa", "12345");
        return con;
   } 
}
