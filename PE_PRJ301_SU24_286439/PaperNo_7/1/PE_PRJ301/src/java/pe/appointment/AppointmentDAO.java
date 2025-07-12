package pe.appointment;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import pe.account.AccountDTO;
import pe.utils.DBUtils;

public class AppointmentDAO implements Serializable{
    //your code here
    private List<AppointmentDTO> items;
    public List<AppointmentDTO> getItems(){
        return this.items;
    }
    
    public void setAppointment()throws SQLException, ClassNotFoundException{
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try{
            con = DBUtils.getConnection();
            if(con != null){
                String query = "Select idApp, account, partnerPhone, partnerName, timeToMeet, place, expense, note "
                        + "From Appointments";
                stm = con.prepareStatement(query);
                rs = stm.executeQuery();
                while(rs.next()){
                    
                    int id = rs.getInt("idApp");
                    String account = rs.getString("account");
                    String partnerPhone = rs.getString("partnerPhone");
                    String partnerName = rs.getString("partnerName");
                    Timestamp timeToMeet = rs.getTimestamp("timeToMeet");
                    String place = rs.getString("place");
                    Double expense = rs.getDouble("expense");
                    String note = rs.getString("note");
                    AppointmentDTO dto = new AppointmentDTO(id, account, partnerPhone, partnerName, timeToMeet, place, expense, note);
                    if(this.items == null){
                        this.items = new ArrayList<>();
                    }
                    this.items.add(dto);
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
