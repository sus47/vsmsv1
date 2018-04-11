/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.customer;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import model.inventory.Bikes;
import model.inventory.Parts;
import model.sales.PartsSales;

/**
 *
 * @author susha
 */
@Entity
@Table(name = "customers")
@NamedQueries({
    @NamedQuery(name = "Customers.findAll", query = "SELECT c FROM Customers c")})
public class Customers implements Serializable {

//    @OneToMany(mappedBy = "customerId")
//    private Collection<PartsSales> partsSalesCollection;
//    @JoinColumn(name = "BIKES_ID", referencedColumnName = "SN")
//    @ManyToOne
    
    private int bikeId;

    private static final long serialVersionUID = 1L;
     @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Column(name="CUS_ID")
    private String customerId;
    @Column(name = "NAME")
    private String name;
    @Column(name = "ADDRESS")
    private String address;
    @Column(name = "PHONE")
    private String phone;
    @Column(name = "PAN")
    private Integer pan;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
 
    @Column(name = "INVOICE")
    private String invoice;
//    @JoinTable(name = "customer_parts_purchase", joinColumns = {
//        @JoinColumn(name = "CUSTOMER_ID", referencedColumnName = "ID")}, inverseJoinColumns = {
//        @JoinColumn(name = "PARTS_ID", referencedColumnName = "SN")})
//    @ManyToMany
//    private Collection<Parts> partsCollection;
//    @JoinColumn(name = "BIKES_ID", referencedColumnName = "SN")
//    @ManyToOne
//    private Bikes bikesId;

    public Customers() {
    }

    public Customers(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getPan() {
        return pan;
    }

    public void setPan(Integer pan) {
        this.pan = pan;
    }

 
    public String getInvoice() {
        return invoice;
    }

    public void setInvoice(String invoice) {
        this.invoice = invoice;
    }

    public int getBikeId() {
        return bikeId;
    }

    public void setBikeId(int bikeId) {
        this.bikeId = bikeId;
    }

//    public Collection<Parts> getPartsCollection() {
//        return partsCollection;
//    }
//
//    public void setPartsCollection(Collection<Parts> partsCollection) {
//        this.partsCollection = partsCollection;
//    }
//
//    public Bikes getBikesId() {
//        return bikesId;
//    }
//
//    public void setBikesId(Bikes bikesId) {
//        this.bikesId = bikesId;
//    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Customers)) {
            return false;
        }
        Customers other = (Customers) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.customer.Customers[ id=" + id + " ]";
    }

  
    
}
