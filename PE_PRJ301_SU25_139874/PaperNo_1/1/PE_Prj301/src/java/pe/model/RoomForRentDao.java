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
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import pe.utils.DbUtils;

/**
 *
 * @author Computing Fundamental - HCM Campus
 */
public class RoomForRentDao implements Serializable {

    //-----            your code here   --------------------------------
    private List<RoomForRentDto> list;

    public List<RoomForRentDto> getList() {
        return this.list;
    }

    public void searchValue(String searchValue)
            throws SQLException, ClassNotFoundException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            con = DbUtils.getConnection();
            if (con != null) {

                String sql = "Select id, title, price, location ,description ,postedDate , status,username "
                        + "From RoomForRent "
                        + "Where location like ?";

                stm = con.prepareStatement(sql);
                stm.setString(1, "%" + searchValue + "%");

                rs = stm.executeQuery();

                while (rs.next()) {
                    int id = rs.getInt("id");
                    String title = rs.getString("title");
                    String location = rs.getString("location");
                    String description = rs.getString("description");
                    Timestamp postedDate = rs.getTimestamp("postedDate");
                    String username = rs.getString("username");
                    double price = rs.getDouble("price");
                    int status = rs.getInt("status");
                    RoomForRentDto dto = new RoomForRentDto(id, title, description, location, username, price, postedDate, status);
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

    public boolean deleteItem(String id)
            throws SQLException, ClassNotFoundException {
        boolean result = false;
        Connection con = null;
        PreparedStatement stm = null;
        try {
            con = DbUtils.getConnection();
            if (con != null) {
                String query = "UPDATE  RoomForRent "
                        + "SET status = ? "
                        + "WHERE id = ?";

                stm = con.prepareStatement(query);
                stm.setString(1, "-2");
                stm.setString(2, id);
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
