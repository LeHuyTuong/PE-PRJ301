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
    private String errorPass;

    public tblUsersCreateErr() {
    }

    /**
     * @return the errorPass
     */
    public String getErrorPass() {
        return errorPass;
    }

    /**
     * @param errorPass the errorPass to set
     */
    public void setErrorPass(String errorPass) {
        this.errorPass = errorPass;
    }
    
}
