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
@Table(name = "tblHouse", catalog = "PE_PRJ301_HCM", schema = "dbo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblHouse.findAll", query = "SELECT t FROM TblHouse t"),
    @NamedQuery(name = "TblHouse.findById", query = "SELECT t FROM TblHouse t WHERE t.id = :id"),
    @NamedQuery(name = "TblHouse.findByName", query = "SELECT t FROM TblHouse t WHERE t.name = :name"),
    @NamedQuery(name = "TblHouse.findByDescription", query = "SELECT t FROM TblHouse t WHERE t.description = :description"),
    @NamedQuery(name = "TblHouse.findByPrice", query = "SELECT t FROM TblHouse t WHERE t.price = :price"),
    @NamedQuery(name = "TblHouse.findBySize", query = "SELECT t FROM TblHouse t WHERE t.size = :size"),
    @NamedQuery(name = "TblHouse.findByStatus", query = "SELECT t FROM TblHouse t WHERE t.status = :status")})
public class TblHouse implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id", nullable = false, length = 5)
    private String id;
    @Basic(optional = false)
    @Column(name = "name", nullable = false, length = 50)
    private String name;
    @Basic(optional = false)
    @Column(name = "description", nullable = false, length = 500)
    private String description;
    @Basic(optional = false)
    @Column(name = "price", nullable = false)
    private double price;
    @Basic(optional = false)
    @Column(name = "size", nullable = false)
    private double size;
    @Basic(optional = false)
    @Column(name = "status", nullable = false)
    private boolean status;

    public TblHouse() {
    }

    public TblHouse(String id) {
        this.id = id;
    }

    public TblHouse(String id, String name, String description, double price, double size, boolean status) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.size = size;
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getSize() {
        return size;
    }

    public void setSize(double size) {
        this.size = size;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblHouse)) {
            return false;
        }
        TblHouse other = (TblHouse) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pe.model.TblHouse[ id=" + id + " ]";
    }
    
}
