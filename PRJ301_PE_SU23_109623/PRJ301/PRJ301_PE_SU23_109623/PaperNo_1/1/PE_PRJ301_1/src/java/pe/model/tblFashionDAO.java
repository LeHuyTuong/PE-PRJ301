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
import java.util.ArrayList;
import java.util.List;
import pe.utils.DBUtils;

/**
 *
 * @author USER
 */
public class tblFashionDAO implements Serializable{
    private List<tblFashionDTO> items;
    public List<tblFashionDTO> getItems(){
        return this.items;
    }
    public void searchValue(String searchValue)throws SQLException, ClassNotFoundException{
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try{
            con = DBUtils.getConnection();
            if(con != null){
                String query = "Select id, name, description, price, size, status "
                        + "From tblFashion "
                        + "Where name like ? ";
                stm = con.prepareStatement(query);
                stm.setString(1, "%" + searchValue + "%");
                rs = stm.executeQuery();
                while(rs.next()){
                    String description = rs.getString("description");
                    String name = rs.getString("name");
                    String id = rs.getString("id");
                    Double price = rs.getDouble("price");
                    String size = rs.getString("size");
                    boolean status = rs.getBoolean("status");
                    tblFashionDTO dto = new tblFashionDTO(id, name , description, price, size, status);
                    if(this.items == null){
                        this.items = new ArrayList<>();
                    }
                    this.items.add(dto);
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
    public boolean updateValue(String id, String name, String description, double price, String size)throws SQLException, ClassNotFoundException{
        boolean result = false;
        Connection con = null;
        PreparedStatement stm = null;
        try{
            con = DBUtils.getConnection();
            if(con != null){
                String query = "Update tblFashion "
                        + "Set name = ?, "
                        + "description = ? ,"
                        + "price = ? ,"
                        + "size = ? "
                        + "Where id = ? ";
                stm = con.prepareStatement(query);
                stm.setString(1, name);
                stm.setString(2, description);
                stm.setDouble(3, price);
                stm.setString(4,size);
                stm.setString(5, id);
                int effectRows = stm.executeUpdate();
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
