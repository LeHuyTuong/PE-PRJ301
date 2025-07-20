/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author USER
 */
@Entity
@Table(name = "tblUsers", catalog = "FashionManagement", schema = "dbo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblUsers.findAll", query = "SELECT t FROM TblUsers t"),
    @NamedQuery(name = "TblUsers.findByUserID", query = "SELECT t FROM TblUsers t WHERE t.userID = :userID"),
    @NamedQuery(name = "TblUsers.findByFullName", query = "SELECT t FROM TblUsers t WHERE t.fullName = :fullName"),
    @NamedQuery(name = "TblUsers.findByPassword", query = "SELECT t FROM TblUsers t WHERE t.password = :password"),
    @NamedQuery(name = "TblUsers.findByRoleID", query = "SELECT t FROM TblUsers t WHERE t.roleID = :roleID"),
    @NamedQuery(name = "TblUsers.findByStatus", query = "SELECT t FROM TblUsers t WHERE t.status = :status")})
public class TblUsers implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "userID", nullable = false, length = 50)
    private String userID;
    @Column(name = "fullName", length = 50)
    private String fullName;
    @Column(name = "password", length = 50)
    private String password;
    @Column(name = "roleID", length = 50)
    private String roleID;
    @Column(name = "status")
    private Boolean status;

    public TblUsers() {
    }

    public TblUsers(String userID) {
        this.userID = userID;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRoleID() {
        return roleID;
    }

    public void setRoleID(String roleID) {
        this.roleID = roleID;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (userID != null ? userID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblUsers)) {
            return false;
        }
        TblUsers other = (TblUsers) object;
        if ((this.userID == null && other.userID != null) || (this.userID != null && !this.userID.equals(other.userID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pe.model.TblUsers[ userID=" + userID + " ]";
    }
    
}
