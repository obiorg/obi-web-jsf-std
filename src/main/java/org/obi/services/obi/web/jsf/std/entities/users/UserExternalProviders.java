/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.obi.services.obi.web.jsf.std.entities.users;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author r.hendrick
 */
@Entity
@Table(name = "user_external_providers", catalog = "OBI", schema = "dbo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UserExternalProviders.findAll", query = "SELECT u FROM UserExternalProviders u"),
    @NamedQuery(name = "UserExternalProviders.findById", query = "SELECT u FROM UserExternalProviders u WHERE u.id = :id"),
    @NamedQuery(name = "UserExternalProviders.findByDeleted", query = "SELECT u FROM UserExternalProviders u WHERE u.deleted = :deleted"),
    @NamedQuery(name = "UserExternalProviders.findByCreated", query = "SELECT u FROM UserExternalProviders u WHERE u.created = :created"),
    @NamedQuery(name = "UserExternalProviders.findByChanged", query = "SELECT u FROM UserExternalProviders u WHERE u.changed = :changed"),
    @NamedQuery(name = "UserExternalProviders.findByName", query = "SELECT u FROM UserExternalProviders u WHERE u.name = :name"),
    @NamedQuery(name = "UserExternalProviders.findByWsEndPoint", query = "SELECT u FROM UserExternalProviders u WHERE u.wsEndPoint = :wsEndPoint")})
public class UserExternalProviders implements Serializable {

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
    @Size(min = 1, max = 45)
    private String name;
    @Size(max = 255)
    private String wsEndPoint;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "externalProvider", fetch = FetchType.EAGER)
    private Collection<UserLoginDataExternal> userLoginDataExternalCollection;

    public UserExternalProviders() {
    }

    public UserExternalProviders(Integer id) {
        this.id = id;
    }

    public UserExternalProviders(Integer id, String name) {
        this.id = id;
        this.name = name;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWsEndPoint() {
        return wsEndPoint;
    }

    public void setWsEndPoint(String wsEndPoint) {
        this.wsEndPoint = wsEndPoint;
    }

    @XmlTransient
    public Collection<UserLoginDataExternal> getUserLoginDataExternalCollection() {
        return userLoginDataExternalCollection;
    }

    public void setUserLoginDataExternalCollection(Collection<UserLoginDataExternal> userLoginDataExternalCollection) {
        this.userLoginDataExternalCollection = userLoginDataExternalCollection;
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
        if (!(object instanceof UserExternalProviders)) {
            return false;
        }
        UserExternalProviders other = (UserExternalProviders) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.obi.services.entities.UserExternalProviders[ id=" + id + " ]";
    }
    
}
