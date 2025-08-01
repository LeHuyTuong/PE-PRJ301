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
    public boolean deleteAccount(String username) throws SQLException, ClassNotFoundException{
        //1 connect 
        boolean result =false;
        Connection con = null;
        //2 get statemet 
        PreparedStatement stm = null;
        try{
            con = DBHepler.makeConnection();
            if(con != null){
                String query = "Delete "
                        + "From Registration "
                        + "Where username = ? ";
                stm = con.prepareStatement(query);
                stm.setString(1, username);
                int effectRows = stm.executeUpdate(); // vi delete update insert tra ve so dong hieu luc
                if(effectRows > 0){
                    result = true;
                }
            }
        }finally{
            if(stm != null){
                stm.close();
            }
            if(con != null){
                con.close();
            }
        }
        return result;
    }
    public boolean updateAccount(String username,String password, String role ) 
            throws SQLException, ClassNotFoundException{
        //1 connect 
        boolean result =false;
        Connection con = null;
        //2 get statemet 
        PreparedStatement stm = null;
        try{
            con = DBHepler.makeConnection();
            if(con != null){
                String query = "UPDATE Registration "
                        + "SET password = ? , "
                        + "isAdmin = ? "
                        + "Where username = ? ";
                stm = con.prepareStatement(query);
                stm.setString(1, password);
                if(role != null){
                    stm.setBoolean(2, true);
                }else{
                    stm.setBoolean(2, false);
                }
                stm.setString(3, username);
                int effectRows = stm.executeUpdate(); // vi delete update insert tra ve so dong hieu luc
                if(effectRows > 0){
                    result = true;
                }
            }
        }finally{
            if(stm != null){
                stm.close();
            }
            if(con != null){
                con.close();
            }
        }
        return result;
    }
    
    public boolean insertAccount (RegistrationDTO accounts)
            throws SQLException, ClassNotFoundException{
        //1 connect 
        boolean result =false;
        Connection con = null;
        //2 get statemet 
        PreparedStatement stm = null;
        try{
            con = DBHepler.makeConnection();
            if(con != null){
                String query = "INSERT INTO Registration ("
                        + "username , password , lastname , isAdmin ) "
                        + "Values (?, ?, ?, ?"
                        + ")";
                stm = con.prepareStatement(query);
                stm.setString(1, accounts.getUsername());
                stm.setString(2, accounts.getPassword());
                stm.setString(3, accounts.getFullname());
                stm.setBoolean(4, accounts.isRole());
                int effectRows = stm.executeUpdate(); // vi delete update insert tra ve so dong hieu luc
                if(effectRows > 0){
                    result = true;
                }
            }
        }finally{
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
