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
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author MS
 */
@Entity
@Table(name = "ad_bs_calender")
@NamedQueries({
    @NamedQuery(name = "AdBsCalender.findAll", query = "SELECT a FROM AdBsCalender a")})
public class AdBsCalender implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "AD_DATE")
    @Temporal(TemporalType.DATE)
    private Date adDate;
    @Basic(optional = false)
    @Column(name = "BS_DATE")
    private String bsDate;
    @Column(name = "DAY")
    private String day;

    public AdBsCalender() {
    }

    public AdBsCalender(Date adDate) {
        this.adDate = adDate;
    }

    public AdBsCalender(Date adDate, String bsDate) {
        this.adDate = adDate;
        this.bsDate = bsDate;
    }

    public Date getAdDate() {
        return adDate;
    }

    public void setAdDate(String adDate) {
        this.adDate = cvt.Convert.toDate(adDate);
    }

    public String getBsDate() {
        return bsDate;
    }

    public void setBsDate(String bsDate) {
        this.bsDate = bsDate;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (adDate != null ? adDate.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AdBsCalender)) {
            return false;
        }
        AdBsCalender other = (AdBsCalender) object;
        if ((this.adDate == null && other.adDate != null) || (this.adDate != null && !this.adDate.equals(other.adDate))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.assign.AdBsCalender[ adDate=" + adDate + " ]";
    }
    
}
