/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.product;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import pe.users.tblUsersDTO;
import pe.utils.DBUtils;

/**
 *
 * @author USER
 */
public class tblProductDAO implements Serializable{
    private List<tblProductDTO> list;
    public List<tblProductDTO> getList(){
        return list;
    }
    
    public void searchValue(String searchValue) throws SQLException, ClassNotFoundException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try{
            con = DBUtils.getConnection();
            if(con != null){
                String query = "Select id, name, description, price, size, status "
                        + "FROM tblProduct "
                        + "Where description like ? ";
                stm = con.prepareStatement(query);
                stm.setString(1, "%" + searchValue + "%");
                rs = stm.executeQuery();
                while(rs.next()){
                    String id = rs.getString("id");
                    String name = rs.getString("name");
                    String description = rs.getString("description");
                    String size = rs.getString("size");
                    double price = rs.getDouble("price");
                    boolean status = rs.getBoolean("status");
                    
                    tblProductDTO result = new tblProductDTO(id, name, description, price, size, status);
                    if(this.list == null){
                        this.list = new ArrayList<>();
                    }
                    this.list.add(result);
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
   
}
