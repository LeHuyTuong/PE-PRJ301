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
    private String notMatch;

    public tblUsersCreateErr() {
    }

    /**
     * @return the notMatch
     */
    public String getNotMatch() {
        return notMatch;
    }

    /**
     * @param notMatch the notMatch to set
     */
    public void setNotMatch(String notMatch) {
        this.notMatch = notMatch;
    }
    
}
