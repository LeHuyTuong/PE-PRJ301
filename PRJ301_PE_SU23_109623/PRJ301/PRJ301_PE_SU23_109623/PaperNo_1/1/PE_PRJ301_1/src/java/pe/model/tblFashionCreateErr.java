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
public class tblFashionCreateErr implements Serializable{
    private String numberFormatWrong;

    public tblFashionCreateErr() {
    }

    /**
     * @return the numberFormatWrong
     */
    public String getNumberFormatWrong() {
        return numberFormatWrong;
    }

    /**
     * @param numberFormatWrong the numberFormatWrong to set
     */
    public void setNumberFormatWrong(String numberFormatWrong) {
        this.numberFormatWrong = numberFormatWrong;
    }
    
}
