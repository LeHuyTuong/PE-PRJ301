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
    private String incorrectUserIDorPassword;

    public tblUsersCreateErr() {
    }

    /**
     * @return the incorrectUserIDorPassword
     */
    public String getIncorrectUserIDorPassword() {
        return incorrectUserIDorPassword;
    }

    /**
     * @param incorrectUserIDorPassword the incorrectUserIDorPassword to set
     */
    public void setIncorrectUserIDorPassword(String incorrectUserIDorPassword) {
        this.incorrectUserIDorPassword = incorrectUserIDorPassword;
    }
    
}
