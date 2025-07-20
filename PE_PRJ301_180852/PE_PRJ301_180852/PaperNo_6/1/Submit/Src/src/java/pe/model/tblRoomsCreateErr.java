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
public class tblRoomsCreateErr implements Serializable{
    private String priceIsNotFormat;
    private String areaIsNotFormat;

    public tblRoomsCreateErr() {
    }

    /**
     * @return the priceIsNotFormat
     */
    public String getPriceIsNotFormat() {
        return priceIsNotFormat;
    }

    /**
     * @param priceIsNotFormat the priceIsNotFormat to set
     */
    public void setPriceIsNotFormat(String priceIsNotFormat) {
        this.priceIsNotFormat = priceIsNotFormat;
    }

    /**
     * @return the areaIsNotFormat
     */
    public String getAreaIsNotFormat() {
        return areaIsNotFormat;
    }

    /**
     * @param areaIsNotFormat the areaIsNotFormat to set
     */
    public void setAreaIsNotFormat(String areaIsNotFormat) {
        this.areaIsNotFormat = areaIsNotFormat;
    }
    
    
}
