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
import tuonglh.util.DBHepler;

/**
 *
 * @author USER
 */
public class RegistrationDAO implements Serializable{
    public RegistrationDTO checkLogin(String username, String password)
    throws SQLException, ClassNotFoundException{
        RegistrationDTO result = null;
        //1 connect 
        Connection con = null;
        //2 get statemet 
        PreparedStatement stm = null;
        //3 tra ve result set
        ResultSet rs = null;
        try{
            con = DBHepler.makeConnection();
            if(con != null){
                String query = "Select lastname, isAdmin "
                        + "From Registration     "
                        + "Where username = ? "
                        + "And password = ? ";
                stm = con.prepareStatement(query);
                stm.setString(1, username);
                stm.setString(2, password);
                rs = stm.executeQuery();
                if(rs.next()){
                    String fullname = rs.getString("lastname");
                    boolean role = rs.getBoolean("isAdmin");
                    result = new RegistrationDTO(username, password, fullname, role);
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
    
    private List<RegistrationDTO> accounts;
    public List<RegistrationDTO> getAccounts(){
        return accounts;
    }
    
    public void searchLastName(String searchValue)throws SQLException, ClassNotFoundException{
        //1 connect 
        Connection con = null;
        //2 get statemet 
        PreparedStatement stm = null;
        //3 tra ve result set
        ResultSet rs = null;
        try{
            con = DBHepler.makeConnection();
            if(con != null){
                String query = "Select username, password, lastname, isAdmin "
                        + "From Registration "
                        + "Where lastname like ?";
                stm = con.prepareStatement(query);
                stm.setString(1, "%" + searchValue +"%");
                rs = stm.executeQuery();
                while(rs.next()){
                    String username = rs.getString("username");
                    String password = rs.getString("password");
                    String fullname = rs.getString("lastname");
                    boolean role = rs.getBoolean("isAdmin");
                    RegistrationDTO result = new RegistrationDTO(username, password, fullname, role);
                    
                    if(this.accounts == null){
                        this.accounts = new ArrayList<>();
                    }
                    this.accounts.add(result);
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
        
    }
}
