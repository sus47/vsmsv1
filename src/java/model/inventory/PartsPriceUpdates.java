/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.inventory;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "parts_price_updates")
@NamedQueries({
    @NamedQuery(name = "PartsPriceUpdates.findAll", query = "SELECT p FROM PartsPriceUpdates p")})
public class PartsPriceUpdates implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Basic(optional = false)
    @Column(name = "SN")
    private Integer sn;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "OLD_PRICE")
    private Float oldPrice;
    @Column(name = "NEW_PRICE")
    private Float newPrice;
    @Column(name = "UPDATED_DATE")
    @Temporal(TemporalType.DATE)
    private Date updatedDate;
//    @JoinColumn(name = "PARTS_ID", referencedColumnName = "SN")
//    @ManyToOne
    @Column(name="PARTS_ID")
    private int partsId;

    public PartsPriceUpdates() {
    }

    public PartsPriceUpdates(Integer sn) {
        this.sn = sn;
    }

    public Integer getSn() {
        return sn;
    }

    public void setSn(Integer sn) {
        this.sn = sn;
    }

    public Float getOldPrice() {
        return oldPrice;
    }

    public void setOldPrice(Float oldPrice) {
        this.oldPrice = oldPrice;
    }

    public Float getNewPrice() {
        return newPrice;
    }

    public void setNewPrice(Float newPrice) {
        this.newPrice = newPrice;
    }

    public Date getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(Date updatedDate) {
        this.updatedDate = updatedDate;
    }

    public int getPartsId() {
        return partsId;
    }

    public void setPartsId(int partsId) {
        this.partsId = partsId;
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
        if (!(object instanceof PartsPriceUpdates)) {
            return false;
        }
        PartsPriceUpdates other = (PartsPriceUpdates) object;
        if ((this.sn == null && other.sn != null) || (this.sn != null && !this.sn.equals(other.sn))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.inventory.PartsPriceUpdates[ sn=" + sn + " ]";
    }

}
