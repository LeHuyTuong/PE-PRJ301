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
    private String userNotMatch;

    public tblUsersCreateErr() {
    }

    /**
     * @return the userNotMatch
     */
    public String getUserNotMatch() {
        return userNotMatch;
    }

    /**
     * @param userNotMatch the userNotMatch to set
     */
    public void setUserNotMatch(String userNotMatch) {
        this.userNotMatch = userNotMatch;
    }
    
}
