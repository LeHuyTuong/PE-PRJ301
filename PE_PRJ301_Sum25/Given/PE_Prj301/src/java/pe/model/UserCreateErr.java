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
public class UserCreateErr implements Serializable{
    private String ErrPass;

    public UserCreateErr() {
    }

    /**
     * @return the ErrPass
     */
    public String getErrPass() {
        return ErrPass;
    }

    /**
     * @param ErrPass the ErrPass to set
     */
    public void setErrPass(String ErrPass) {
        this.ErrPass = ErrPass;
    }
    
}
