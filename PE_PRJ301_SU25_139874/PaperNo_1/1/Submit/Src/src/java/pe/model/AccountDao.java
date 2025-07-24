/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.model;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import pe.utils.DbUtils;

/**
 *
 * @author Computing Fundamental - HCM Campus
 */
public class AccountDao implements Serializable{
    //-----            your code here   --------------------------------
    public AccountDto checkLogin(String username, String password)
            throws SQLException, ClassNotFoundException {
        AccountDto result = null;
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            con = DbUtils.getConnection();            
            if (con != null) {
                
                String sql = "Select fullName, phone, email, status,role "
                        + "From Account  "
                        + "Where username = ? "
                        + "And password = ?";                
                
                stm = con.prepareStatement(sql);
                stm.setString(1, username);                
                stm.setString(2, password);
                rs = stm.executeQuery();
                if (rs.next()) {
                    String fullName = rs.getString("fullName");
                    String phone = rs.getString("phone");
                    String email = rs.getString("email");
                    boolean status = rs.getBoolean("status");
                    boolean role = rs.getBoolean("role");
                    result = new AccountDto(username, password, fullName, phone, email, status, role);
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
