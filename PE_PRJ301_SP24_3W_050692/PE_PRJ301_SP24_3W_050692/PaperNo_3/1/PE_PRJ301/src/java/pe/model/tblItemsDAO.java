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
public class tblItemsDAO implements Serializable {

    private List<tblItemsDTO> items;

    public List<tblItemsDTO> getItems() {
        return items;
    }

    public void searchItems(String value1, String value2)
            throws SQLException, ClassNotFoundException {
        tblItemsDTO result = null;
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            con = DBUtils.getConnection();
            if (con != null) {
                String query = "select id, name, price, quantity "
                        + "from tblItems "
                        + "Where price >= ? "
                        + "AND price <= ? ";
                stm = con.prepareStatement(query);
                stm.setString(1, value1);
                stm.setString(2, value2);
                rs = stm.executeQuery();
                while(rs.next()){
                    String id = rs.getString("id");
                    String name = rs.getString("name");
                    double price = rs.getDouble("price");
                    int quantity = rs.getInt("quantity");
                    result = new tblItemsDTO(id, name, price, quantity);
                    if(this.items == null){
                        this.items = new ArrayList<>();
                    }
                    this.items.add(result);
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
