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
public class tblCapstonesDAO implements Serializable{
    private List<tblCapstonesDTO> list;
    public List<tblCapstonesDTO> getList(){
        return list;
    }
    public tblCapstonesDTO searchValue(String searchValue)
    throws SQLException, ClassNotFoundException{
        tblCapstonesDTO result = null;
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try{
            con = DBUtils.getConnection();
            if(con != null){
                String query = "Select id, name, description, userID "
                        + "From tblCapstones "
                        + "Where name LIKE ?";
                stm = con.prepareStatement(query);
                stm.setString(1, "%" + searchValue +"%");
                rs = stm.executeQuery();
                while(rs.next()){
                    String idCapstone = rs.getString("id");
                    String name = rs.getString("name");
                    String description = rs.getString("description");
                    String Usid = rs.getString("userID");
                    result = new tblCapstonesDTO(idCapstone, name, description, Usid);
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
        return result;
    }
    
    public boolean deleteValue(String id)
    throws SQLException, ClassNotFoundException{
        boolean result = false;
        Connection con = null;
        PreparedStatement stm = null;
        try{
            con = DBUtils.getConnection();
            if(con != null){
                String query = "DELETE "
                        + "FROM tblCapstones "
                        + "Where id = ? ";
                stm = con.prepareStatement(query);
                stm.setString(1, id);
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
