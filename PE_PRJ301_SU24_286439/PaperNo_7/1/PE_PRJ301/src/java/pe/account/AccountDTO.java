package pe.account;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;

public class AccountDTO implements Serializable{
    //your code here
    private String account;
    private String pass; 
    private String roleDB;
    private String fullName;
    private boolean gender;
    private Date birthDay;
    private String phone;
    private String addrr;

    public AccountDTO() {
    }

    public AccountDTO(String account, String pass, String roleDB, String fullName, boolean gender, Date birthDay, String phone, String addrr) {
        this.account = account;
        this.pass = pass;
        this.roleDB = roleDB;
        this.fullName = fullName;
        this.gender = gender;
        this.birthDay = birthDay;
        this.phone = phone;
        this.addrr = addrr;
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
     * @return the pass
     */
    public String getPass() {
        return pass;
    }

    /**
     * @param pass the pass to set
     */
    public void setPass(String pass) {
        this.pass = pass;
    }

    /**
     * @return the roleDB
     */
    public String getRoleDB() {
        return roleDB;
    }

    /**
     * @param roleDB the roleDB to set
     */
    public void setRoleDB(String roleDB) {
        this.roleDB = roleDB;
    }

    /**
     * @return the fullName
     */
    public String getFullName() {
        return fullName;
    }

    /**
     * @param fullName the fullName to set
     */
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    /**
     * @return the gender
     */
    public boolean isGender() {
        return gender;
    }

    /**
     * @param gender the gender to set
     */
    public void setGender(boolean gender) {
        this.gender = gender;
    }

    /**
     * @return the birthDay
     */
    public Date getBirthDay() {
        return birthDay;
    }

    /**
     * @param birthDay the birthDay to set
     */
    public void setBirthDay(Date birthDay) {
        this.birthDay = birthDay;
    }

    /**
     * @return the phone
     */
    public String getPhone() {
        return phone;
    }

    /**
     * @param phone the phone to set
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * @return the addrr
     */
    public String getAddrr() {
        return addrr;
    }

    /**
     * @param addrr the addrr to set
     */
    public void setAddrr(String addrr) {
        this.addrr = addrr;
    }

    
    
}
