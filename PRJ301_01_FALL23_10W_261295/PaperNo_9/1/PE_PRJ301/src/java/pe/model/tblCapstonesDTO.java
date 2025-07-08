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
public class tblCapstonesDTO implements Serializable{
    private String  capstoneID;
    private String  nameCapstone;
    private String description;
    private String userID; 

    public tblCapstonesDTO() {
    }

    public tblCapstonesDTO(String capstoneID, String nameCapstone, String description, String userID) {
        this.capstoneID = capstoneID;
        this.nameCapstone = nameCapstone;
        this.description = description;
        this.userID = userID;
    }

    /**
     * @return the capstoneID
     */
    public String getCapstoneID() {
        return capstoneID;
    }

    /**
     * @param capstoneID the capstoneID to set
     */
    public void setCapstoneID(String capstoneID) {
        this.capstoneID = capstoneID;
    }

    /**
     * @return the nameCapstone
     */
    public String getNameCapstone() {
        return nameCapstone;
    }

    /**
     * @param nameCapstone the nameCapstone to set
     */
    public void setNameCapstone(String nameCapstone) {
        this.nameCapstone = nameCapstone;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return the userID
     */
    public String getUserID() {
        return userID;
    }

    /**
     * @param userID the userID to set
     */
    public void setUserID(String userID) {
        this.userID = userID;
    }
    
}
