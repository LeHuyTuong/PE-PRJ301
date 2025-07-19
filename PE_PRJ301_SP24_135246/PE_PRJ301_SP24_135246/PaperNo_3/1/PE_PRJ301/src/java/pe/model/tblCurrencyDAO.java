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
public class tblCurrencyDAO implements Serializable{
    private List<tblCurrencyDTO> list;

    public List<tblCurrencyDTO> getList() {
        return list;
    }

    public void searchValue(String searchCode, String searchName )
            throws SQLException, ClassNotFoundException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            con = DBUtils.getConnection();
            if (con != null) {
                
                String sql = "Select code, name, description, rate "
                        + "From tblCurrency "
                        + "Where name like ? "
                        + "AND code like ? ";
                
                stm = con.prepareStatement(sql);
                stm.setString(1, "%" + searchName + "%");
                stm.setString(2, "%" + searchCode + "%");
                
                rs = stm.executeQuery();
                
                while (rs.next()) {
                    String code = rs.getString("code");
                    String description = rs.getString("description");
                    String name = rs.getString("name");
                    double rate = rs.getDouble("rate");
                    tblCurrencyDTO dto = new tblCurrencyDTO(code, name, description, rate);
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
    public boolean updateItem(String name, String code, String description, double rate)
            throws SQLException, ClassNotFoundException {
        boolean result = false;
        Connection con = null;
        PreparedStatement stm = null;
        try {
            con = DBUtils.getConnection();
            if (con != null) {
                String query = "UPDATE  tblCurrency "
                        + "SET description = ? ,"
                        + "rate = ? "
                        + "WHERE name = ? "
                        + "And code = ?";                
                
                stm = con.prepareStatement(query);
                stm.setString(1, description);
                stm.setDouble(2, rate);
                stm.setString(3, name);
                stm.setString(4, code);
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
