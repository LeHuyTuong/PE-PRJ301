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
public class tblCurrencyCreateErr implements Serializable{
    private String emptyRate;

    public tblCurrencyCreateErr() {
    }

    /**
     * @return the emptyRate
     */
    public String getEmptyRate() {
        return emptyRate;
    }

    /**
     * @param emptyRate the emptyRate to set
     */
    public void setEmptyRate(String emptyRate) {
        this.emptyRate = emptyRate;
    }
    
}
