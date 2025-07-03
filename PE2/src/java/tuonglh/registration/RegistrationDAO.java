/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tuonglh.registration;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import tuonglh.utils.DBHepler;

/**
 *
 * @author USER
 */
public class RegistrationDAO implements Serializable {

    public RegistrationDTO checkLogin(String username, String password)
            throws SQLException, ClassNotFoundException {
        //b1 Tra ve kieu du lieu 
        RegistrationDTO result = null;
        //b2 ket noi db
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            con = DBHepler.makeConnection();
            if (con != null) {
                //3. String query
                String query = "Select lastname, isAdmin "
                        + "From Registration "
                        + "Where username = ? "
                        + "And password = ? "; // co 2 thjam chieu do co 2 ?
                stm = con.prepareStatement(query); // add statement vao trong tham chieu
                stm.setString(1, username);
                stm.setString(2, password);

                //4 Tra ket qua cua query ve result set 
                rs = stm.executeQuery();
                if (rs.next()) { // result set co nhieu dong nen phai su dunjg while 
                    String fullName = rs.getString("lastname");
                    boolean role = rs.getBoolean("isAdmin");
                    result = new RegistrationDTO(username, password, fullName, role);
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
    private List<RegistrationDTO> accounts;

    public List<RegistrationDTO> getAccount() {
        return accounts;
    }

    public void searchAccount(String searchValue) throws SQLException, ClassNotFoundException {
        //b1 Tra ve kieu du lieu 
        //b2 ket noi db
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            con = DBHepler.makeConnection();
            if (con != null) {
                //3. String query
                String query = "Select username, password, lastname, isAdmin "
                        + "From Registration "
                        + "Where lastname like ?";
                stm = con.prepareStatement(query); // add statement vao trong tham chieu
                stm.setString(1, "%" + searchValue + "%");

                //4 Tra ket qua cua query ve result set 
                rs = stm.executeQuery();
                while (rs.next()) { // result set co nhieu dong nen phai su dunjg while 
                    String username = rs.getString("username");
                    String password = rs.getString("password");
                    String fullName = rs.getString("lastname");
                    boolean role = rs.getBoolean("isAdmin");
                    RegistrationDTO result = new RegistrationDTO(username, password, fullName, role);

                    if (this.accounts == null) {
                        this.accounts = new ArrayList<>();
                    }
                    this.accounts.add(result);
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

    }
    
    
    public boolean deleteAccount(String username)throws SQLException, ClassNotFoundException {
        //b1 Tra ve kieu du lieu 
        //b2 ket noi db
        boolean result = false;
        Connection con = null;
        PreparedStatement stm = null;
        try {
            con = DBHepler.makeConnection();
            if (con != null) {
                //3. String query
                String query = "Delete "
                        + "From Registration "
                        + "Where username = ? ";
                stm = con.prepareStatement(query); // add statement vao trong tham chieu
                stm.setString(1, username);
                //4 Tra ket qua cua query ve result set 
                int effectRows = stm.executeUpdate();
                if(effectRows > 0){
                    result = true;
                }
            }
        } finally {
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return result;
    }
    
    public boolean updateAccount(String username,String password, String role)
            throws SQLException, ClassNotFoundException {
        //b1 Tra ve kieu du lieu 
        //b2 ket noi db
        boolean result = false;
        Connection con = null;
        PreparedStatement stm = null;
        try {
            con = DBHepler.makeConnection();
            if (con != null) {
                //3. String query
                String query = "UPDATE Registration "
                        + "Set password = ? , "
                        + "isAdmin = ? "
                        + "Where username = ? ";
                stm = con.prepareStatement(query); // add statement vao trong tham chieu
                stm.setString(1, password);
                if(role != null){
                    stm.setBoolean(2, true);
                }else{
                    stm.setBoolean(2, false);
                }
                stm.setString(3, username);
                //4 Tra ket qua cua query ve result set 
                int effectRows = stm.executeUpdate();
                if(effectRows > 0){
                    result = true;
                }
            }
        } finally {
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
