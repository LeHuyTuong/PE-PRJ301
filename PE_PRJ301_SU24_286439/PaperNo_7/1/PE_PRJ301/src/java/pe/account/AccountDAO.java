package pe.account;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import pe.utils.DBUtils;

public class AccountDAO implements Serializable{
    //your code here
    public AccountDTO checkLogin(String username, String password)
    throws SQLException, ClassNotFoundException{
        AccountDTO result = null;
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try{
            con = DBUtils.getConnection();
            if(con != null){
                String query = "Select roleDB, fullName, gender, birthDay, phone, addr "
                        + "From Account "
                        + "Where account = ? "
                        + "And pass = ? ";
                stm = con.prepareStatement(query);
                stm.setString(1, username);
                stm.setString(2,password);
                rs = stm.executeQuery();
                if(rs.next()){
                    String role = rs.getString("roleDB");
                    String name = rs.getString("fullName");
                    boolean gender = rs.getBoolean("gender");
                    Date birthDay = rs.getDate("birthDay");
                    String phone = rs.getString("phone");
                    String addr = rs.getString("addr");
                    result = new AccountDTO(username, password, role, name, gender, birthDay, phone, addr);
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
}
