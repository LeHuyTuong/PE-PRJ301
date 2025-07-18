/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.model;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import pe.utils.DBUtils;

/**
 *
 * @author USER
 */
public class tblUsersDAO implements Serializable{
    public tblUsersDTO checkLogin(String username, String password)
            throws SQLException, ClassNotFoundException {
        tblUsersDTO result = null;
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            con = DBUtils.getConnection();            
            if (con != null) {
                
                String sql = "Select fullName, roleID "
                        + "From tblUsers "
                        + "Where userID = ? "
                        + "And password = ?";                
                
                stm = con.prepareStatement(sql);
                stm.setString(1, username);                
                stm.setString(2, password);
                rs = stm.executeQuery();
                if (rs.next()) {
                    String fullName = rs.getString("fullName");
                    String role = rs.getString("roleID");
                    
                    result = new tblUsersDTO(username, password, fullName, role);
                    
                }
            }
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return result;
    }
}
