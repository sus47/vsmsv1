/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.inventory;

import cvt.Convert;
import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import model.customer.Customers;
import model.sales.BikesSales;

/**
 *
 * @author susha
 */
@Entity
@Table(name = "bikes")
@NamedQueries({
    @NamedQuery(name = "Bikes.findAll", query = "SELECT b FROM Bikes b")})
public class Bikes implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Basic(optional = false)
    @Column(name = "SN")
    private Integer sn;
    @Column(name = "MODEL")
    private String model;
    @Column(name = "COLOR")
    private String color;
    @Column(name = "ENGINE_NUMBER")
    private String engineNumber;
    @Column(name = "CHASIS_NUMBER")
    private String chasisNumber;
    @Column(name = "REG_NO")
    private String regNo;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "COST_PRICE")
    private Float costPrice;
    @Column(name = "SELLING_PRICE")
    private Float sellingPrice;
    @Column(name = "QUANTITY")
    private Integer quantity;
    @Column(name = "ENTRY_DATE")
    private String entryDate;
    @Column(name = "STATUS")
    private String status;
    @Column(name = "CREATED_DATE")
    @Temporal(TemporalType.DATE)
    private Date createdDate;
    @Column(name = "UPDATED_DATE")
    @Temporal(TemporalType.DATE)
    private Date updatedDate;

    public Bikes() {
    }

    public Bikes(Integer sn) {
        this.sn = sn;
    }

    public Integer getSn() {
        return sn;
    }

    public void setSn(Integer sn) {
        this.sn = sn;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getEngineNumber() {
        return engineNumber;
    }

    public void setEngineNumber(String engineNumber) {
        this.engineNumber = engineNumber;
    }

    public String getChasisNumber() {
        return chasisNumber;
    }

    public void setChasisNumber(String chasisNumber) {
        this.chasisNumber = chasisNumber;
    }

    public String getRegNo() {
        return regNo;
    }

    public void setRegNo(String regNo) {
        this.regNo = regNo;
    }

    public Float getCostPrice() {
        return costPrice;
    }

    public void setCostPrice(Float costPrice) {
        this.costPrice = costPrice;
    }

    public Float getSellingPrice() {
        return sellingPrice;
    }

    public void setSellingPrice(Float sellingPrice) {
        this.sellingPrice = sellingPrice;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getEntryDate() {
        return entryDate;
    }

    public void setEntryDate(String entryDate) {
        this.entryDate = entryDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(Date updatedDate) {
        this.updatedDate = updatedDate;
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
        if (!(object instanceof Bikes)) {
            return false;
        }
        Bikes other = (Bikes) object;
        if ((this.sn == null && other.sn != null) || (this.sn != null && !this.sn.equals(other.sn))) {
            return false;
        }
        return true;
    }

//    public Collection<BikePriceUpdates> getBikePriceUpdatesCollection() {
//        return bikePriceUpdatesCollection;
//    }
//
//    public void setBikePriceUpdatesCollection(Collection<BikePriceUpdates> bikePriceUpdatesCollection) {
//        this.bikePriceUpdatesCollection = bikePriceUpdatesCollection;
//    }
//
//    public Collection<Parts> getPartsCollection() {
//        return partsCollection;
//    }
//
//    public void setPartsCollection(Collection<Parts> partsCollection) {
//        this.partsCollection = partsCollection;
//    }
//
//    public Collection<Customers> getCustomersCollection() {
//        return customersCollection;
//    }
//
//    public void setCustomersCollection(Collection<Customers> customersCollection) {
//        this.customersCollection = customersCollection;
//    }
    @Override
    public String toString() {
        return "\n{\"sn\": \"" + sn + "\",\"model\": \"" + model + "\",\"color\": \"" + color + "\",\"engineNumber\": \"" + engineNumber + "\",\"chasisNumber\": \"" + chasisNumber + "\",\"regNo\": \"" + regNo + "\",\"costPrice\": \"" + costPrice + "\",\"sellingPrice\": \"" + sellingPrice + "\",\"quantity\": \"" + quantity + "\",\"entryDate\": \"" + entryDate + "\",\"status\": \"" + status + "\",\"createdDate\": \"" + createdDate + "\",\"updatedDate\": \"" + updatedDate + "\"}";
    }

}
