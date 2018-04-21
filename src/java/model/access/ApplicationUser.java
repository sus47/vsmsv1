
package model.access;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
//import model.inventory.Ledger;


@Entity
@Table(name = "application_user")
@NamedQueries({
    @NamedQuery(name = "ApplicationUser.findAll", query = "SELECT a FROM ApplicationUser a")})
public class ApplicationUser implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "USER_CODE")
    private String userCode;
    @Basic(optional = false)
    @Column(name = "USER_NAME")
    private String userName;
    @Basic(optional = false)
    @Column(name = "USER_PASSWORD")
    private String userPassword;
    @Column(name = "EMAIL")
    private String email;
    @Column(name = "MOBILE")
    private String mobile;
    @Column(name = "LAST_LOGIN")
    @Temporal(TemporalType.DATE)
    private Date lastLogin;
    @Column(name = "TOKEN")
    private String token;
    @Column(name = "STATUS")
    private String status;
//    @JoinColumn(name = "MUNICIPAL", referencedColumnName = "SN")
//    private Ledger municipal;
    @Column(name = "API_KEY")
    private String apiKey;
    @Column(name = "TOKEN_EXP_TIME")
    @Temporal(TemporalType.TIMESTAMP)
    private Date tokenExpTime;

    public Date getTokenExpTime() {
        return tokenExpTime;
    }

    public void setTokenExpTime(Date tokenExpTime) {
        this.tokenExpTime = tokenExpTime;
    }
       

    public String getApiKey() {
        return apiKey;
    }

    public void setApiKey(String apiKey) {
        this.apiKey = apiKey;
    }
    

    public ApplicationUser() {
    }

    public ApplicationUser(String userCode) {
        this.userCode = userCode;
    }

    public ApplicationUser(String userCode, String userName, String userPassword) {
        this.userCode = userCode;
        this.userName = userName;
        this.userPassword = userPassword;
    }

    public String getUserCode() {
        return userCode;
    }
//

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public Date getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(Date lastLogin) {
        this.lastLogin = lastLogin;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

   

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (userCode != null ? userCode.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ApplicationUser)) {
            return false;
        }
        ApplicationUser other = (ApplicationUser) object;
        if ((this.userCode == null && other.userCode != null) || (this.userCode != null && !this.userCode.equals(other.userCode))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ApplicationUser{" + "userCode=" + userCode + ", userName=" + userName + ", userPassword=" + userPassword + ", email=" + email + ", mobile=" + mobile + ", lastLogin=" + lastLogin + ", token=" + token + ", status=" + status + ", apiKey=" + apiKey + ", tokenExpTime=" + tokenExpTime + '}';
    }

    
    
}
