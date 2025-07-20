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
public class TblUsersCreateErr implements Serializable{
    private String invalidUserOrPassword;

    public TblUsersCreateErr() {
    }

    /**
     * @return the invalidUserOrPassword
     */
    public String getInvalidUserOrPassword() {
        return invalidUserOrPassword;
    }

    /**
     * @param invalidUserOrPassword the invalidUserOrPassword to set
     */
    public void setInvalidUserOrPassword(String invalidUserOrPassword) {
        this.invalidUserOrPassword = invalidUserOrPassword;
    }
    
}
