/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.obi.services.obi.web.jsf.std.entities.users;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author r.hendrick
 */
@Entity
@Table(name = "user_login_data", catalog = "OBI", schema = "dbo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UserLoginData.findAll", query = "SELECT u FROM UserLoginData u"),
    @NamedQuery(name = "UserLoginData.findById", query = "SELECT u FROM UserLoginData u WHERE u.id = :id"),
    @NamedQuery(name = "UserLoginData.findByDeleted", query = "SELECT u FROM UserLoginData u WHERE u.deleted = :deleted"),
    @NamedQuery(name = "UserLoginData.findByCreated", query = "SELECT u FROM UserLoginData u WHERE u.created = :created"),
    @NamedQuery(name = "UserLoginData.findByChanged", query = "SELECT u FROM UserLoginData u WHERE u.changed = :changed"),
    @NamedQuery(name = "UserLoginData.findByLoginName", query = "SELECT u FROM UserLoginData u WHERE u.loginName = :loginName"),
    @NamedQuery(name = "UserLoginData.findByPasswordHash", query = "SELECT u FROM UserLoginData u WHERE u.passwordHash = :passwordHash"),
    @NamedQuery(name = "UserLoginData.findByPasswordSalt", query = "SELECT u FROM UserLoginData u WHERE u.passwordSalt = :passwordSalt"),
    @NamedQuery(name = "UserLoginData.findByEmail", query = "SELECT u FROM UserLoginData u WHERE u.email = :email"),
    @NamedQuery(name = "UserLoginData.findByTokenConfirmation", query = "SELECT u FROM UserLoginData u WHERE u.tokenConfirmation = :tokenConfirmation"),
    @NamedQuery(name = "UserLoginData.findByTokenGenerationTime", query = "SELECT u FROM UserLoginData u WHERE u.tokenGenerationTime = :tokenGenerationTime"),
    @NamedQuery(name = "UserLoginData.findByTokenPasswordRecovery", query = "SELECT u FROM UserLoginData u WHERE u.tokenPasswordRecovery = :tokenPasswordRecovery"),
    @NamedQuery(name = "UserLoginData.findByTokenTimeRecovery", query = "SELECT u FROM UserLoginData u WHERE u.tokenTimeRecovery = :tokenTimeRecovery"),
    @NamedQuery(name = "UserLoginData.findByImage", query = "SELECT u FROM UserLoginData u WHERE u.image = :image")})
public class UserLoginData implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    private Integer id;
    private Boolean deleted;
    @Temporal(TemporalType.TIMESTAMP)
    private Date created;
    @Temporal(TemporalType.TIMESTAMP)
    private Date changed;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    private String loginName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    private String passwordHash;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    private String passwordSalt;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    private String email;
    @Size(max = 255)
    private String tokenConfirmation;
    @Temporal(TemporalType.TIMESTAMP)
    private Date tokenGenerationTime;
    @Size(max = 255)
    private String tokenPasswordRecovery;
    @Temporal(TemporalType.TIMESTAMP)
    private Date tokenTimeRecovery;
    @Size(max = 1024)
    private String image;
    @JoinColumn(name = "emailVerified", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.EAGER)
    private UserEmailVerified emailVerified;
    @JoinColumn(name = "hashAlgorithm", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private UserHashingAlgorithms hashAlgorithm;

    public UserLoginData() {
    }

    public UserLoginData(Integer id) {
        this.id = id;
    }

    public UserLoginData(Integer id, String loginName, String passwordHash, String passwordSalt, String email) {
        this.id = id;
        this.loginName = loginName;
        this.passwordHash = passwordHash;
        this.passwordSalt = passwordSalt;
        this.email = email;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getChanged() {
        return changed;
    }

    public void setChanged(Date changed) {
        this.changed = changed;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    public String getPasswordSalt() {
        return passwordSalt;
    }

    public void setPasswordSalt(String passwordSalt) {
        this.passwordSalt = passwordSalt;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTokenConfirmation() {
        return tokenConfirmation;
    }

    public void setTokenConfirmation(String tokenConfirmation) {
        this.tokenConfirmation = tokenConfirmation;
    }

    public Date getTokenGenerationTime() {
        return tokenGenerationTime;
    }

    public void setTokenGenerationTime(Date tokenGenerationTime) {
        this.tokenGenerationTime = tokenGenerationTime;
    }

    public String getTokenPasswordRecovery() {
        return tokenPasswordRecovery;
    }

    public void setTokenPasswordRecovery(String tokenPasswordRecovery) {
        this.tokenPasswordRecovery = tokenPasswordRecovery;
    }

    public Date getTokenTimeRecovery() {
        return tokenTimeRecovery;
    }

    public void setTokenTimeRecovery(Date tokenTimeRecovery) {
        this.tokenTimeRecovery = tokenTimeRecovery;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public UserEmailVerified getEmailVerified() {
        return emailVerified;
    }

    public void setEmailVerified(UserEmailVerified emailVerified) {
        this.emailVerified = emailVerified;
    }

    public UserHashingAlgorithms getHashAlgorithm() {
        return hashAlgorithm;
    }

    public void setHashAlgorithm(UserHashingAlgorithms hashAlgorithm) {
        this.hashAlgorithm = hashAlgorithm;
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
        if (!(object instanceof UserLoginData)) {
            return false;
        }
        UserLoginData other = (UserLoginData) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.obi.services.entities.UserLoginData[ id=" + id + " ]";
    }
    
}
