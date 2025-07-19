/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import pe.utils.DbUtils;

/**
 *
 * @author Computing Fundamental - HCM Campus
 */
public class FashionDao {
    //-----            your code here   --------------------------------

    private List<FashionDto> list;

    public List<FashionDto> getItem() {
        return list;
    }

    public void searchLastName(String searchValue)
            throws SQLException, ClassNotFoundException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            con = DbUtils.getConnection();
            if (con != null) {

                String sql = "Select id, name, description, price ,size , status "
                        + "From TblFashion "
                        + "Where name like ?";

                stm = con.prepareStatement(sql);
                stm.setString(1, "%" + searchValue + "%");

                rs = stm.executeQuery();

                while (rs.next()) {
                    String id = rs.getString("id");
                    String description = rs.getString("description");
                    String name = rs.getString("name");
                    double price = rs.getDouble("price");
                    String size= rs.getString("size");
                    boolean status = rs.getBoolean("status");
                    FashionDto dto = new FashionDto(id, name, description, price, size, status);
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
}
