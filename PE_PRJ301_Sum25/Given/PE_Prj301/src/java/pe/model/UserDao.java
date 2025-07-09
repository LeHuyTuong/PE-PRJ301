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
public class UserDao implements Serializable{
    //-----            your code here   --------------------------------
    public UserDto checkLogin(String userID, String password)
    throws SQLException, ClassNotFoundException{
        UserDto result = null;
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try{
            con = DbUtils.getConnection();
            if(con != null){
                String query = "Select fullName, roleID "
                        + "From tblUsers "
                        + "Where userID = ? "
                        + "And password = ? ";
                stm = con.prepareStatement(query);
                stm.setString(1, userID);
                stm.setString(2, password);
                rs = stm.executeQuery();
                if(rs.next()){
                    String fullName = rs.getString("fullName");
                    String roleID = rs.getString("roleID");
                    result = new UserDto(userID, fullName, roleID, password);
                }
            }
        }finally{
            if(rs != null){
                rs.close();
            }
            if(stm != null){
                stm.close();
            }
            if(con != null){
                con.close();
            }
        }
        
        return result;
    }
}
