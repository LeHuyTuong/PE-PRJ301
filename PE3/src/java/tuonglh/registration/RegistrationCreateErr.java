/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tuonglh.registration;

import java.io.Serializable;

/**
 *
 * @author USER
 */
public class RegistrationCreateErr implements Serializable{
    private String usernameNotLength;
    private String passwordNotLength;
    private String confirmNotMatch;
    private String fullnameNotLength;
    private String usernameIsExist;

    public RegistrationCreateErr() {
    }

    /**
     * @return the usernameNotLength
     */
    public String getUsernameNotLength() {
        return usernameNotLength;
    }

    /**
     * @param usernameNotLength the usernameNotLength to set
     */
    public void setUsernameNotLength(String usernameNotLength) {
        this.usernameNotLength = usernameNotLength;
    }

    /**
     * @return the passwordNotLength
     */
    public String getPasswordNotLength() {
        return passwordNotLength;
    }

    /**
     * @param passwordNotLength the passwordNotLength to set
     */
    public void setPasswordNotLength(String passwordNotLength) {
        this.passwordNotLength = passwordNotLength;
    }

    /**
     * @return the confirmNotMatch
     */
    public String getConfirmNotMatch() {
        return confirmNotMatch;
    }

    /**
     * @param confirmNotMatch the confirmNotMatch to set
     */
    public void setConfirmNotMatch(String confirmNotMatch) {
        this.confirmNotMatch = confirmNotMatch;
    }

    /**
     * @return the fullnameNotLength
     */
    public String getFullnameNotLength() {
        return fullnameNotLength;
    }

    /**
     * @param fullnameNotLength the fullnameNotLength to set
     */
    public void setFullnameNotLength(String fullnameNotLength) {
        this.fullnameNotLength = fullnameNotLength;
    }

    /**
     * @return the usernameIsExist
     */
    public String getUsernameIsExist() {
        return usernameIsExist;
    }

    /**
     * @param usernameIsExist the usernameIsExist to set
     */
    public void setUsernameIsExist(String usernameIsExist) {
        this.usernameIsExist = usernameIsExist;
    }
}
