/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.model;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 *
 * @author Computing Fundamental - HCM Campus
 */
public class RoomForRentDto implements Serializable{
    //-----            your code here   --------------------------------
    private int id;
    private String title;
    private String description;
    private String location;
    private String username;
    private double price;
    private Timestamp postedDate;
    private int status;

    public RoomForRentDto() {
    }

    public RoomForRentDto(int id, String title, String description, String location, String username, double price, Timestamp postedDate, int status) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.location = location;
        this.username = username;
        this.price = price;
        this.postedDate = postedDate;
        this.status = status;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @param title the title to set
     */
    public void setTitle(String title) {
        this.title = title;
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
     * @return the location
     */
    public String getLocation() {
        return location;
    }

    /**
     * @param location the location to set
     */
    public void setLocation(String location) {
        this.location = location;
    }

    /**
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username the username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return the price
     */
    public double getPrice() {
        return price;
    }

    /**
     * @param price the price to set
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * @return the postedDate
     */
    public Timestamp getPostedDate() {
        return postedDate;
    }

    /**
     * @param postedDate the postedDate to set
     */
    public void setPostedDate(Timestamp postedDate) {
        this.postedDate = postedDate;
    }

    /**
     * @return the status
     */
    public int getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(int status) {
        this.status = status;
    }
    
    
}
