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
import sample.utils.DBUtils;

/**
 *
 * @author USER
 */
public class tblRoomsDAO implements Serializable{
    private List<tblRoomsDTO> list;
    public List<tblRoomsDTO> getList(){
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
                
                String sql = "Select id, name, description, price ,area , status "
                        + "From tblRooms "
                        + "Where name like ?";
                
                stm = con.prepareStatement(sql);
                stm.setString(1, "%" + searchValue + "%");
                
                rs = stm.executeQuery();
                
                while (rs.next()) {
                    String id = rs.getString("id");
                    String description = rs.getString("description");
                    String name = rs.getString("name");
                    double price = rs.getDouble("price");
                    double area = rs.getDouble("area");
                    boolean status = rs.getBoolean("status");
                    tblRoomsDTO dto = new tblRoomsDTO(id, name, description, price, area, status);
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
    public boolean updateRoom(String id, String name, String description, double price, double area)
            throws SQLException, ClassNotFoundException {
        boolean result = false;
        Connection con = null;
        PreparedStatement stm = null;
        try {
            con = DBUtils.getConnection();
            if (con != null) {
                String query = "UPDATE  tblRooms "
                        + "SET name = ? ,"
                        + "description = ? ,"
                        + "price = ?, "
                        + "area = ? "
                        + "WHERE id = ?";                
                
                stm = con.prepareStatement(query);
                stm.setString(1, name);
                stm.setString(2, description);
                stm.setDouble(3, price);
                stm.setDouble(4, area);
                stm.setString(5, id);
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
