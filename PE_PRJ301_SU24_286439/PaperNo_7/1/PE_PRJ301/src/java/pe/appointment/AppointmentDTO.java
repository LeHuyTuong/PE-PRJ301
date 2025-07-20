package pe.appointment;

import java.io.Serializable;
import java.sql.Date;

public class AppointmentDTO implements Serializable{
    //your code here
    private int idApp;
    private String account, partnerPhone, partnerName;
    private Date timeToMeet;
    private String place;
    private double expense;
    private String note;

    public AppointmentDTO() {
    }

    public AppointmentDTO(int idApp, String account, String partnerPhone, String partnerName, Date timeToMeet, String place, double expense, String note) {
        this.idApp = idApp;
        this.account = account;
        this.partnerPhone = partnerPhone;
        this.partnerName = partnerName;
        this.timeToMeet = timeToMeet;
        this.place = place;
        this.expense = expense;
        this.note = note;
    }

    /**
     * @return the idApp
     */
    public int getIdApp() {
        return idApp;
    }

    /**
     * @param idApp the idApp to set
     */
    public void setIdApp(int idApp) {
        this.idApp = idApp;
    }

    /**
     * @return the account
     */
    public String getAccount() {
        return account;
    }

    /**
     * @param account the account to set
     */
    public void setAccount(String account) {
        this.account = account;
    }

    /**
     * @return the partnerPhone
     */
    public String getPartnerPhone() {
        return partnerPhone;
    }

    /**
     * @param partnerPhone the partnerPhone to set
     */
    public void setPartnerPhone(String partnerPhone) {
        this.partnerPhone = partnerPhone;
    }

    /**
     * @return the partnerName
     */
    public String getPartnerName() {
        return partnerName;
    }

    /**
     * @param partnerName the partnerName to set
     */
    public void setPartnerName(String partnerName) {
        this.partnerName = partnerName;
    }

    /**
     * @return the timeToMeet
     */
    public Date getTimeToMeet() {
        return timeToMeet;
    }

    /**
     * @param timeToMeet the timeToMeet to set
     */
    public void setTimeToMeet(Date timeToMeet) {
        this.timeToMeet = timeToMeet;
    }

    /**
     * @return the place
     */
    public String getPlace() {
        return place;
    }

    /**
     * @param place the place to set
     */
    public void setPlace(String place) {
        this.place = place;
    }

    /**
     * @return the expense
     */
    public double getExpense() {
        return expense;
    }

    /**
     * @param expense the expense to set
     */
    public void setExpense(double expense) {
        this.expense = expense;
    }

    /**
     * @return the note
     */
    public String getNote() {
        return note;
    }

    /**
     * @param note the note to set
     */
    public void setNote(String note) {
        this.note = note;
    }
    
}
