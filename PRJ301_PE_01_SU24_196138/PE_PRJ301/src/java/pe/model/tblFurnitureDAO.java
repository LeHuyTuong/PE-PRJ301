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
public class tblFurnitureDAO implements Serializable{
    private List<tblFurnitureDTO> list;
    public List<tblFurnitureDTO> getItem(){
        return list;
    }
    
    public void searchValue(String searchValue)
            throws SQLException, ClassNotFoundException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            con = DBUtils.getConnection();
            if (con != null) {
                
                String sql = "Select id, name, description, price ,dimensions, material , status "
                        + "From tblFurniture "
                        + "Where name like ?";
                
                stm = con.prepareStatement(sql);
                stm.setString(1, "%" + searchValue + "%");
                
                rs = stm.executeQuery();
                
                while (rs.next()) {
                    String id = rs.getString("id");
                    double price = rs.getDouble("price");
                    String description = rs.getString("description");
                    String name = rs.getString("name");
                    String dimensions = rs.getString("dimensions");
                    String material = rs.getString("material");
                    boolean status = rs.getBoolean("status");
                    tblFurnitureDTO dto = new tblFurnitureDTO(id, name, description, price, dimensions, material, status);
                    if (this.list == null) {
                        this.list = new ArrayList<>();
                    }

                    this.list.add(dto);
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
    public boolean updateAccount(String username)
            throws SQLException, ClassNotFoundException {
        boolean result = false;
        Connection con = null;
        PreparedStatement stm = null;
        try {
            con = DBUtils.getConnection();
            if (con != null) {
                String query = "Update tblFurniture "
                        + "SET status = ? "
                        + "Where id = ?";                
                
                stm = con.prepareStatement(query);
                stm.setBoolean(1, false);
                stm.setString(2, username);
                int effectRows = stm.executeUpdate();                
                if (effectRows > 0) {
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
