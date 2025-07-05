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
    private String PasswordNotCorrect;

    public tblUsersCreateErr() {
    }

    /**
     * @return the PasswordNotCorrect
     */
    public String getPasswordNotCorrect() {
        return PasswordNotCorrect;
    }

    /**
     * @param PasswordNotCorrect the PasswordNotCorrect to set
     */
    public void setPasswordNotCorrect(String PasswordNotCorrect) {
        this.PasswordNotCorrect = PasswordNotCorrect;
    }
    
}
