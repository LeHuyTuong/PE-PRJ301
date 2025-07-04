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
import pe.utils.DbUtils;

/**
 *
 * @author Hi
 */
public class TblUserDAO implements Serializable {

    public TblUserDTO checkLogin(String username, int password, int role) throws
            ClassNotFoundException, SQLException {
        TblUserDTO result = null;

        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            con = DbUtils.getConnection();
            if (con != null) {
                String query = "Select fullName, role "
                        + "From tbl_User "
                        + "Where username = ? "
                        + "And password = ? "
                        + "And role = ?";
                stm = con.prepareStatement(query);
                stm.setString(1, username);
                stm.setInt(2, password);
                if(role == 1){
                    stm.setInt(3, 1);
                }
                else{
                    stm.setInt(3, 0);
                }
                rs = stm.executeQuery();
                if (rs.next()) {
                    String fullName = rs.getString("fullName");
                    boolean dbRole= rs.getBoolean("role");
                    result = new TblUserDTO(username, password, fullName, dbRole);
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

