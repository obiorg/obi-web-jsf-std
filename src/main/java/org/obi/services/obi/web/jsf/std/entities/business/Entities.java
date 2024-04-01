/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.obi.services.obi.web.jsf.std.entities.business;

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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
import org.obi.services.obi.web.jsf.std.entities.locations.Locations;
import org.obi.services.obi.web.jsf.std.entities.measures.MeasUnits;
import org.obi.services.obi.web.jsf.std.entities.users.UserRolePermissions;
import org.obi.services.obi.web.jsf.std.entities.users.UserRoles;

/**
 *
 * @author r.hendrick
 */
@Entity
@Table(catalog = "OBI", schema = "dbo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Entities.findAll", query = "SELECT e FROM Entities e"),
    @NamedQuery(name = "Entities.findById", query = "SELECT e FROM Entities e WHERE e.id = :id"),
    @NamedQuery(name = "Entities.findByDeleted", query = "SELECT e FROM Entities e WHERE e.deleted = :deleted"),
    @NamedQuery(name = "Entities.findByCreated", query = "SELECT e FROM Entities e WHERE e.created = :created"),
    @NamedQuery(name = "Entities.findByChanged", query = "SELECT e FROM Entities e WHERE e.changed = :changed"),
    @NamedQuery(name = "Entities.findByEntity", query = "SELECT e FROM Entities e WHERE e.entity = :entity"),
    @NamedQuery(name = "Entities.findByDesignation", query = "SELECT e FROM Entities e WHERE e.designation = :designation"),
    @NamedQuery(name = "Entities.findByBuilded", query = "SELECT e FROM Entities e WHERE e.builded = :builded"),
    @NamedQuery(name = "Entities.findByMain", query = "SELECT e FROM Entities e WHERE e.main = :main"),
    @NamedQuery(name = "Entities.findByActivated", query = "SELECT e FROM Entities e WHERE e.activated = :activated"),
    @NamedQuery(name = "Entities.findByLogoPath", query = "SELECT e FROM Entities e WHERE e.logoPath = :logoPath")})
public class Entities implements Serializable {

    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private int id;
    private Boolean deleted = false;
    @Temporal(TemporalType.TIMESTAMP)
    private Date created;
    @Temporal(TemporalType.TIMESTAMP)
    private Date changed;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    private String entity;
    @Size(max = 255)
    private String designation;
    private Integer builded;
    private Boolean main;
    private Boolean activated;
    @Size(max = 512)
    private String logoPath;
    @OneToMany(mappedBy = "entity", fetch = FetchType.LAZY)
    private Collection<UserRolePermissions> userRolePermissionsCollection;
    @OneToMany(mappedBy = "entity", fetch = FetchType.LAZY)
    private Collection<UserRoles> userRolesCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "entity", fetch = FetchType.LAZY)
    private Collection<Businesses> businessesCollection;
    @JoinColumn(name = "location", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Locations location;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "entity", fetch = FetchType.LAZY)
    private Collection<MeasUnits> measUnitsCollection;

    public Entities() {
    }

    public Entities(String entity) {
        this.entity = entity;
    }

    public Entities(String entity, int id) {
        this.entity = entity;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public String getEntity() {
        return entity;
    }

    public void setEntity(String entity) {
        this.entity = entity;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public Integer getBuilded() {
        return builded;
    }

    public void setBuilded(Integer builded) {
        this.builded = builded;
    }

    public Boolean getMain() {
        return main;
    }

    public void setMain(Boolean main) {
        this.main = main;
    }

    public Boolean getActivated() {
        return activated;
    }

    public void setActivated(Boolean activated) {
        this.activated = activated;
    }

    public String getLogoPath() {
        return logoPath;
    }

    public void setLogoPath(String logoPath) {
        this.logoPath = logoPath;
    }

    @XmlTransient
    public Collection<UserRolePermissions> getUserRolePermissionsCollection() {
        return userRolePermissionsCollection;
    }

    public void setUserRolePermissionsCollection(Collection<UserRolePermissions> userRolePermissionsCollection) {
        this.userRolePermissionsCollection = userRolePermissionsCollection;
    }

    @XmlTransient
    public Collection<UserRoles> getUserRolesCollection() {
        return userRolesCollection;
    }

    public void setUserRolesCollection(Collection<UserRoles> userRolesCollection) {
        this.userRolesCollection = userRolesCollection;
    }

    @XmlTransient
    public Collection<Businesses> getBusinessesCollection() {
        return businessesCollection;
    }

    public void setBusinessesCollection(Collection<Businesses> businessesCollection) {
        this.businessesCollection = businessesCollection;
    }

    public Locations getLocation() {
        return location;
    }

    public void setLocation(Locations location) {
        this.location = location;
    }

    @XmlTransient
    public Collection<MeasUnits> getMeasUnitsCollection() {
        return measUnitsCollection;
    }

    public void setMeasUnitsCollection(Collection<MeasUnits> measUnitsCollection) {
        this.measUnitsCollection = measUnitsCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (entity != null ? entity.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Entities)) {
            return false;
        }
        Entities other = (Entities) object;
        if ((this.entity == null && other.entity != null) || (this.entity != null && !this.entity.equals(other.entity))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
//        return "org.obi.services.entities.Entities[ entity=" + entity + " ]";
        return "" + this.entity + " - " + this.designation + " [ id=" + id + " ]";
    }
  
}
