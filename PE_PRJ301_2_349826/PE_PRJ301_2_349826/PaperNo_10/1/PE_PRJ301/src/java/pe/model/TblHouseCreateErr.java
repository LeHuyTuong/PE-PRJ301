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
public class TblHouseCreateErr implements Serializable{
    private String notFormat;
    private String duplicateID;
    private String dataType;
    private String minimumSize;
    private String maximumSize;

    public TblHouseCreateErr() {
    }

    /**
     * @return the notFormat
     */
    public String getNotFormat() {
        return notFormat;
    }

    /**
     * @param notFormat the notFormat to set
     */
    public void setNotFormat(String notFormat) {
        this.notFormat = notFormat;
    }

    /**
     * @return the duplicateID
     */
    public String getDuplicateID() {
        return duplicateID;
    }

    /**
     * @param duplicateID the duplicateID to set
     */
    public void setDuplicateID(String duplicateID) {
        this.duplicateID = duplicateID;
    }

    /**
     * @return the dataType
     */
    public String getDataType() {
        return dataType;
    }

    /**
     * @param dataType the dataType to set
     */
    public void setDataType(String dataType) {
        this.dataType = dataType;
    }

    /**
     * @return the minimumSize
     */
    public String getMinimumSize() {
        return minimumSize;
    }

    /**
     * @param minimumSize the minimumSize to set
     */
    public void setMinimumSize(String minimumSize) {
        this.minimumSize = minimumSize;
    }

    /**
     * @return the maximumSize
     */
    public String getMaximumSize() {
        return maximumSize;
    }

    /**
     * @param maximumSize the maximumSize to set
     */
    public void setMaximumSize(String maximumSize) {
        this.maximumSize = maximumSize;
    }
    
}
