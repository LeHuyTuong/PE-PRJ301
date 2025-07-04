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
import pe.utils.DbUtils;

/**
 *
 * @author Hi
 */
public class TblWatchDAO implements Serializable {

    private List<TblWatchDTO> accounts;

    public List<TblWatchDTO> getAcccount() {
        return accounts;
    }

    public void searchAccount(String minValue, String maxValue) throws
            ClassNotFoundException, SQLException {
        TblWatchDTO result = null;
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            con = DbUtils.getConnection();
            if (con != null) {
                String query = "Select id, name, brandName, price, size, quantity, description "
                        + "From tbl_Watch "
                        + "Where quantity >= ? "
                        + "And quantity <= ? "
                        + "Order by quantity DESC";
                stm = con.prepareStatement(query);
                stm.setInt(1, Integer.parseInt(minValue));
                stm.setInt(2, Integer.parseInt(maxValue));
                rs = stm.executeQuery();
                while (rs.next()) {
                    int ordinaryNumber = rs.getInt("id");
                    String name = rs.getString("name");
                    String brandName = rs.getString("brandName");
                    double price = rs.getDouble("price");
                    int size = rs.getInt("size");
                    int quantity = rs.getInt("quantity");
                    String description = rs.getString("description");
                    result = new TblWatchDTO(ordinaryNumber, name, brandName, price, size, quantity, description);
                    if(this.accounts == null){
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
    public boolean updateAccount(int id, String description, int price) throws
            ClassNotFoundException, SQLException {
        boolean result = false;
        Connection con = null;
        PreparedStatement stm = null;
        try {
            con = DbUtils.getConnection();
            if (con != null) {
                String query = "UPDATE tbl_Watch ("
                        + "id, )";
                stm = con.prepareStatement(query);
 
                
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
