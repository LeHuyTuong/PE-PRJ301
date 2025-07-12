/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.account;

import java.io.Serializable;

/**
 *
 * @author USER
 */
public class AccountCreateErr implements Serializable{
    private String errorsPass;

    public AccountCreateErr() {
        this.errorsPass = null;
    }

    /**
     * @return the errorsPass
     */
    public String getErrorsPass() {
        return errorsPass;
    }

    /**
     * @param errorsPass the errorsPass to set
     */
    public void setErrorsPass(String errorsPass) {
        this.errorsPass = errorsPass;
    }
    
}
