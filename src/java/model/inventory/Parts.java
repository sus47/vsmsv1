/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.inventory;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import model.customer.Customers;

/**
 *
 * @author susha
 */
@Entity
@Table(name = "parts")
@NamedQueries({
    @NamedQuery(name = "Parts.findAll", query = "SELECT p FROM Parts p")})
public class Parts implements Serializable {

//    @ManyToMany(mappedBy = "partsCollection")
//    private Collection<Customers> customersCollection;
//
//    @OneToMany(mappedBy = "partsId")
//    private Collection<PartsPriceUpdates> partsPriceUpdatesCollection;

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "SN")
    private Integer sn;
    @Column(name = "PARTS_NUMBER")
    private String partsNumber;
    @Column(name = "NAME")
    private String name;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "COST_PRICE")
    private Float costPrice;
    @Column(name = "SELLING_PRICE")
    private Float sellingPrice;
    @Column(name = "QUANTITY")
    private Integer quantity;
    @Column(name = "STATUS")
    private String status;
    @Column(name = "ENTRY_DATE")
    @Temporal(TemporalType.DATE)
    private Date entryDate;
    @Column(name = "CREATED_DATE")
    @Temporal(TemporalType.DATE)
    private Date createdDate;
    @Column(name = "UPDATED_DATE")
    @Temporal(TemporalType.DATE)
    private Date updatedDate;
//    @JoinColumn(name = "BIKE_ID", referencedColumnName = "SN")
//    @ManyToOne
    @Column(name="BIKE_ID")
    private int bikeId;

    public Parts() {
    }

    public Parts(Integer sn) {
        this.sn = sn;
    }

    public Integer getSn() {
        return sn;
    }

    public void setSn(Integer sn) {
        this.sn = sn;
    }

    public String getPartsNumber() {
        return partsNumber;
    }

    public void setPartsNumber(String partsNumber) {
        this.partsNumber = partsNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getEntryDate() {
        return entryDate;
    }

    public void setEntryDate(Date entryDate) {
        this.entryDate = entryDate;
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

    public int getBikeId() {
        return bikeId;
    }

    public void setBikeId(int bikeId) {
        this.bikeId = bikeId;
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
        if (!(object instanceof Parts)) {
            return false;
        }
        Parts other = (Parts) object;
        if ((this.sn == null && other.sn != null) || (this.sn != null && !this.sn.equals(other.sn))) {
            return false;
        }
        return true;
    }

  

//    public Collection<PartsPriceUpdates> getPartsPriceUpdatesCollection() {
//        return partsPriceUpdatesCollection;
//    }
//
//    public void setPartsPriceUpdatesCollection(Collection<PartsPriceUpdates> partsPriceUpdatesCollection) {
//        this.partsPriceUpdatesCollection = partsPriceUpdatesCollection;
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
return "\n{\"sn\": \""+sn+"\",\"partsNumber\": \""+partsNumber+"\",\"name\": \""+name+"\",\"bikeId\": \""+bikeId+"\",\"costPrice\": \""+costPrice+"\",\"sellingPrice\": \""+sellingPrice+"\",\"quantity\": \""+quantity+"\",\"status\": \""+status+"\",\"entryDate\": \""+entryDate+"\",\"createdDate\": \""+createdDate+"\",\"updatedDate\": \""+updatedDate+"\"}";
    }

}
