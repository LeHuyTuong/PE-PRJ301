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
public class FashionCreateErr implements Serializable{
    private String numberFormat;

    public FashionCreateErr() {
    }

    /**
     * @return the numberFormat
     */
    public String getNumberFormat() {
        return numberFormat;
    }

    /**
     * @param numberFormat the numberFormat to set
     */
    public void setNumberFormat(String numberFormat) {
        this.numberFormat = numberFormat;
    }
    
}
