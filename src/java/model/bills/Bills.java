/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.bills;

import java.io.Serializable;
import java.math.BigInteger;
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
@Table(name = "bills")
@NamedQueries({
    @NamedQuery(name = "Bills.findAll", query = "SELECT b FROM Bills b")})
public class Bills implements Serializable {

    private static final long serialVersionUID = 1L;
     @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Basic(optional = false)
    @Column(name = "SN")
    private Integer sn;
    @Column(name = "CUS_ID")
    private String cusId;
    @Column(name = "CUS_NAME")
    private String cusName;
    @Column(name = "ADDRESS")
    private String address;
    @Column(name = "PHONE")
    private String phone;
    @Column(name = "ORG_TYPE")
    private String orgType;
    @Column(name = "CUS_TYPE")
    private String cusType;
    @Column(name = "SERVICE_BILL")
    private String serviceBill;
    @Column(name = "PAN_NO")
    private int panNo;
    @Column(name = "SERVICE_TIMES")
    private String serviceTimes;
    @Column(name = "SERVICE_TYPE")
    private String serviceType;
    @Column(name = "INVOICE")
    private String invoice;
    @Column(name = "BIKE_ID")
    private int bikeId;
    @Column(name = "QUANTITY")
    private int quantity;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "DISCOUNT")
    private Float discount;
    @Column(name = "TOTAL_SP")
    private Float totalSp;
    @Column(name = "VAT")
    private Float vat;
    @Column(name = "TOTAL")
    private Float total;
    @Column(name = "NET_TOTAL")
    private Float netTotal;
    @Column(name = "ADVANCE")
    private Float advance;
    @Column(name = "DUE")
    private Float due;
    @Column(name = "CREATED_DATE")
    @Temporal(TemporalType.DATE)
    private Date createdDate;

    public Bills() {
    }

    public Bills(Integer sn) {
        this.sn = sn;
    }

    public Integer getSn() {
        return sn;
    }

    public void setSn(Integer sn) {
        this.sn = sn;
    }

    public String getCusId() {
        return cusId;
    }

    public void setCusId(String cusId) {
        this.cusId = cusId;
    }

    public String getCusName() {
        return cusName;
    }

    public void setCusName(String cusName) {
        this.cusName = cusName;
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

    public String getOrgType() {
        return orgType;
    }

    public void setOrgType(String orgType) {
        this.orgType = orgType;
    }

    public String getCusType() {
        return cusType;
    }

    public void setCusType(String cusType) {
        this.cusType = cusType;
    }

    public String getServiceBill() {
        return serviceBill;
    }

    public void setServiceBill(String serviceBill) {
        this.serviceBill = serviceBill;
    }

    public int getPanNo() {
        return panNo;
    }

    public void setPanNo(int panNo) {
        this.panNo = panNo;
    }

    public String getServiceTimes() {
        return serviceTimes;
    }

    public void setServiceTimes(String serviceTimes) {
        this.serviceTimes = serviceTimes;
    }

    public String getServiceType() {
        return serviceType;
    }

    public void setServiceType(String serviceType) {
        this.serviceType = serviceType;
    }

    public String getInvoice() {
        return invoice;
    }

    public void setInvoice(String invoice) {
        this.invoice = invoice;
    }

    public Integer getBikeId() {
        return bikeId;
    }

    public void setBikeId(Integer bikeId) {
        this.bikeId = bikeId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Float getDiscount() {
        return discount;
    }

    public void setDiscount(Float discount) {
        this.discount = discount;
    }

    public Float getTotalSp() {
        return totalSp;
    }

    public void setTotalSp(Float totalSp) {
        this.totalSp = totalSp;
    }

    public Float getVat() {
        return vat;
    }

    public void setVat(Float vat) {
        this.vat = vat;
    }

    public Float getNetTotal() {
        return netTotal;
    }

    public void setNetTotal(Float netTotal) {
        this.netTotal = netTotal;
    }

    public Float getAdvance() {
        return advance;
    }

    public void setAdvance(Float advance) {
        this.advance = advance;
    }

    public Float getDue() {
        return due;
    }

    public void setDue(Float due) {
        this.due = due;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
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
        if (!(object instanceof Bills)) {
            return false;
        }
        Bills other = (Bills) object;
        if ((this.sn == null && other.sn != null) || (this.sn != null && !this.sn.equals(other.sn))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {

        return "Bills{" + "sn=" + sn + ", cusId=" + cusId + ", cusName=" + cusName + ", address=" + address + ", phone=" + phone + ", orgType=" + orgType + ", cusType=" + cusType + ", serviceBill=" + serviceBill + ", panNo=" + panNo + ", serviceTimes=" + serviceTimes + ", serviceType=" + serviceType + ", invoice=" + invoice + ", bikeId=" + bikeId + ", quantity=" + quantity + ", discount=" + discount + ", totalSp=" + totalSp + ", vat=" + vat + ", total=" + total + ", netTotal=" + netTotal + ", advance=" + advance + ", due=" + due + ", createdDate=" + createdDate + '}';
    }

}
