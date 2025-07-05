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
import pe.utils.DBHepler;

/**
 *
 * @author USER
 */
public class tblPaintingDAO implements Serializable {

    private List<tblPaintingDTO> paintings;

    public List<tblPaintingDTO> getPainting() {
        return paintings;
    }

    public void searchPainting(String description, boolean status)
            throws SQLException, ClassNotFoundException {
        tblPaintingDTO result = null;
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            con = DBHepler.getConnection();
            if (con != null) {
                String query = "Select creator, id, height, width, price "
                        + "From tblPainting "
                        + "Where description LIKE ? "
                        + "And status = ? ";
                stm = con.prepareStatement(query);
                stm.setString(1, "%" + description + "%");
                stm.setBoolean(2, true);
                rs = stm.executeQuery();
                while(rs.next()){
                    String creator = rs.getString("creator");
                    String id = rs.getString("id");
                    int height = rs.getInt("height");
                    int width = rs.getInt("width");
                    double price = rs.getDouble("price");
                    result = new tblPaintingDTO(id, creator, description, height, width, price, status);
                    if(this.paintings == null){
                        this.paintings = new ArrayList<>();
                    }
                    this.paintings.add(result);
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
    
    public boolean deletePainting(String id)
            throws SQLException, ClassNotFoundException {
        boolean result = false;
        Connection con = null;
        PreparedStatement stm = null;
        try {
            con = DBHepler.getConnection();
            if (con != null) {
                String query = "Update tblPainting "
                        + "SET status = ? "
                        + "Where id = ? ";
                stm = con.prepareStatement(query);
                stm.setBoolean(1, false);
                stm.setString(2, id);
                int effectRows = stm.executeUpdate();
                if(effectRows > 0){
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
