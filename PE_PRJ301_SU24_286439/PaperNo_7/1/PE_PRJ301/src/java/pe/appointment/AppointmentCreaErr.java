/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.appointment;

import java.io.Serializable;

/**
 *
 * @author USER
 */
public class AppointmentCreaErr implements Serializable{
    private String wrongTimeFormat;
    private String wrongExpenseFormat;
    private String phoneFormat;
    private String nameFormat;
    private String emptyInfo;
    public AppointmentCreaErr() {
    }

    /**
     * @return the wrongTimeFormat
     */
    public String getWrongTimeFormat() {
        return wrongTimeFormat;
    }

    /**
     * @param wrongTimeFormat the wrongTimeFormat to set
     */
    public void setWrongTimeFormat(String wrongTimeFormat) {
        this.wrongTimeFormat = wrongTimeFormat;
    }

    /**
     * @return the wrongExpenseFormat
     */
    public String getWrongExpenseFormat() {
        return wrongExpenseFormat;
    }

    /**
     * @param wrongExpenseFormat the wrongExpenseFormat to set
     */
    public void setWrongExpenseFormat(String wrongExpenseFormat) {
        this.wrongExpenseFormat = wrongExpenseFormat;
    }

    /**
     * @return the phoneFormat
     */
    public String getPhoneFormat() {
        return phoneFormat;
    }

    /**
     * @param phoneFormat the phoneFormat to set
     */
    public void setPhoneFormat(String phoneFormat) {
        this.phoneFormat = phoneFormat;
    }

    /**
     * @return the nameFormat
     */
    public String getNameFormat() {
        return nameFormat;
    }

    /**
     * @param nameFormat the nameFormat to set
     */
    public void setNameFormat(String nameFormat) {
        this.nameFormat = nameFormat;
    }

    /**
     * @return the emptyInfo
     */
    public String getEmptyInfo() {
        return emptyInfo;
    }

    /**
     * @param emptyInfo the emptyInfo to set
     */
    public void setEmptyInfo(String emptyInfo) {
        this.emptyInfo = emptyInfo;
    }

    
    
}
