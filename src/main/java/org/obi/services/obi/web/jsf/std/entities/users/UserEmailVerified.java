/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.obi.services.obi.web.jsf.std.entities.users;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author r.hendrick
 */
@Entity
@Table(name = "user_email_verified", catalog = "OBI", schema = "dbo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UserEmailVerified.findAll", query = "SELECT u FROM UserEmailVerified u"),
    @NamedQuery(name = "UserEmailVerified.findById", query = "SELECT u FROM UserEmailVerified u WHERE u.id = :id"),
    @NamedQuery(name = "UserEmailVerified.findByDeleted", query = "SELECT u FROM UserEmailVerified u WHERE u.deleted = :deleted"),
    @NamedQuery(name = "UserEmailVerified.findByCreated", query = "SELECT u FROM UserEmailVerified u WHERE u.created = :created"),
    @NamedQuery(name = "UserEmailVerified.findByChanged", query = "SELECT u FROM UserEmailVerified u WHERE u.changed = :changed"),
    @NamedQuery(name = "UserEmailVerified.findByStatusDescription", query = "SELECT u FROM UserEmailVerified u WHERE u.statusDescription = :statusDescription")})
public class UserEmailVerified implements Serializable {

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
    @Size(max = 45)
    private String statusDescription;
    @OneToMany(mappedBy = "emailVerified", fetch = FetchType.EAGER)
    private Collection<UserLoginData> userLoginDataCollection;

    public UserEmailVerified() {
    }

    public UserEmailVerified(Integer id) {
        this.id = id;
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

    public String getStatusDescription() {
        return statusDescription;
    }

    public void setStatusDescription(String statusDescription) {
        this.statusDescription = statusDescription;
    }

    @XmlTransient
    public Collection<UserLoginData> getUserLoginDataCollection() {
        return userLoginDataCollection;
    }

    public void setUserLoginDataCollection(Collection<UserLoginData> userLoginDataCollection) {
        this.userLoginDataCollection = userLoginDataCollection;
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
        if (!(object instanceof UserEmailVerified)) {
            return false;
        }
        UserEmailVerified other = (UserEmailVerified) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.obi.services.entities.UserEmailVerified[ id=" + id + " ]";
    }
    
}
