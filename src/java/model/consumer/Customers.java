/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.consumer;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author susha
 */
@Entity
@Table(name = "customers")
@NamedQueries({
    @NamedQuery(name = "Customers.findAll", query = "SELECT c FROM Customers c")})
public class Customers implements Serializable {

    

    private static final long serialVersionUID = 1L;
     @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer sn;
    @Column(name="CUS_ID")
    private String customerId;
    @Column(name = "NAME")
    private String name;
    @Column(name = "ADDRESS")
    private String address;
    @Column(name = "PHONE")
    private String phone;
 
    @Column(name = "INVOICE")
    private String invoice;

    @Column(name = "PAN")
    private int pan;
    @Column(name = "PARTS_ID")
    private Integer partsId;
    @Column(name = "CREATED_DATE")
    @Temporal(TemporalType.DATE)
    private Date createdDate;
    @Column(name="BIKES_ID")
    private int bikeId=0;
    @Column(name="TYPE")
    private String customerType;
    public Customers() {
    }

    public Customers(Integer sn) {
        this.sn = sn;
    }

    public Integer getId() {
        return sn;
    }

    public void setId(Integer sn) {
        this.sn = sn;
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

    public int getPan() {
        return pan;
    }

    public void setPan(int pan) {
        this.pan = pan;
    }

    public Integer getPartsId() {
        return partsId;
    }

    public void setPartsId(Integer partsId) {
        this.partsId = partsId;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public String getCustomerType() {
        return customerType;
    }

    public void setCustomerType(String customerType) {
        this.customerType = customerType;
    }

    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (sn != null ? sn.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Customers)) {
            return false;
        }
        Customers other = (Customers) object;
        if ((this.sn == null && other.sn != null) || (this.sn != null && !this.sn.equals(other.sn))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Customers{" + "sn=" + sn + ", customerId=" + customerId + ", name=" + name + ", address=" + address + ", phone=" + phone + ", invoice=" + invoice + ", pan=" + pan + ", partsId=" + partsId + ", createdDate=" + createdDate + ", bikeId=" + bikeId + ", customerType=" + customerType + '}';
    }

   

}
