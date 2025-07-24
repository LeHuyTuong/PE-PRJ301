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
public class AccountCreateErr implements Serializable{
    private String invalidPass;

    public AccountCreateErr() {
    }

    public AccountCreateErr(String invalidPass) {
        this.invalidPass = invalidPass;
    }

    /**
     * @return the invalidPass
     */
    public String getInvalidPass() {
        return invalidPass;
    }

    /**
     * @param invalidPass the invalidPass to set
     */
    public void setInvalidPass(String invalidPass) {
        this.invalidPass = invalidPass;
    }
    
}
