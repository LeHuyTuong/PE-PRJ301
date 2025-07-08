/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.model;

import java.io.Serializable;

/**
 *
 * @author USER
 */
public class tblUsersCreateErr implements Serializable{
    private String incorrectErr;

    public tblUsersCreateErr() {
    }

    /**
     * @return the incorrectErr
     */
    public String getIncorrectErr() {
        return incorrectErr;
    }

    /**
     * @param incorrectErr the incorrectErr to set
     */
    public void setIncorrectErr(String incorrectErr) {
        this.incorrectErr = incorrectErr;
    }
    
}
