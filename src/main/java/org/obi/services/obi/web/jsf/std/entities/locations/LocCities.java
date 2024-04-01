/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.obi.services.obi.web.jsf.std.entities.locations;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
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

/**
 *
 * @author r.hendrick
 */
@Entity
@Table(name = "loc_cities", catalog = "OBI", schema = "dbo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "LocCities.findAll", query = "SELECT l FROM LocCities l"),
    @NamedQuery(name = "LocCities.findById", query = "SELECT l FROM LocCities l WHERE l.id = :id"),
    @NamedQuery(name = "LocCities.findByName", query = "SELECT l FROM LocCities l WHERE l.name = :name"),
    @NamedQuery(name = "LocCities.findByStateCode", query = "SELECT l FROM LocCities l WHERE l.stateCode = :stateCode"),
    @NamedQuery(name = "LocCities.findByCountryCode", query = "SELECT l FROM LocCities l WHERE l.countryCode = :countryCode"),
    @NamedQuery(name = "LocCities.findByLatitude", query = "SELECT l FROM LocCities l WHERE l.latitude = :latitude"),
    @NamedQuery(name = "LocCities.findByLongitude", query = "SELECT l FROM LocCities l WHERE l.longitude = :longitude"),
    @NamedQuery(name = "LocCities.findByCreatedAt", query = "SELECT l FROM LocCities l WHERE l.createdAt = :createdAt"),
    @NamedQuery(name = "LocCities.findByUpdatedAt", query = "SELECT l FROM LocCities l WHERE l.updatedAt = :updatedAt"),
    @NamedQuery(name = "LocCities.findByFlag", query = "SELECT l FROM LocCities l WHERE l.flag = :flag"),
    @NamedQuery(name = "LocCities.findByWikiDataId", query = "SELECT l FROM LocCities l WHERE l.wikiDataId = :wikiDataId")})
public class LocCities implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    private String name;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "state_code")
    private String stateCode;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "country_code")
    private String countryCode;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    private BigDecimal latitude;
    @Basic(optional = false)
    @NotNull
    private BigDecimal longitude;
    @Basic(optional = false)
    @NotNull
    @Column(name = "created_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;
    @Basic(optional = false)
    @NotNull
    @Column(name = "updated_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;
    @Basic(optional = false)
    @NotNull
    private boolean flag;
    @Size(max = 255)
    private String wikiDataId;
    @JoinColumn(name = "country_id", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private LocCountries countryId;
    @JoinColumn(name = "state_id", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private LocStates stateId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "city", fetch = FetchType.LAZY)
    private Collection<Locations> locationsCollection;

    public LocCities() {
    }

    public LocCities(Integer id) {
        this.id = id;
    }

    public LocCities(Integer id, String name, String stateCode, String countryCode, BigDecimal latitude, BigDecimal longitude, Date createdAt, Date updatedAt, boolean flag) {
        this.id = id;
        this.name = name;
        this.stateCode = stateCode;
        this.countryCode = countryCode;
        this.latitude = latitude;
        this.longitude = longitude;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.flag = flag;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStateCode() {
        return stateCode;
    }

    public void setStateCode(String stateCode) {
        this.stateCode = stateCode;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public BigDecimal getLatitude() {
        return latitude;
    }

    public void setLatitude(BigDecimal latitude) {
        this.latitude = latitude;
    }

    public BigDecimal getLongitude() {
        return longitude;
    }

    public void setLongitude(BigDecimal longitude) {
        this.longitude = longitude;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public boolean getFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public String getWikiDataId() {
        return wikiDataId;
    }

    public void setWikiDataId(String wikiDataId) {
        this.wikiDataId = wikiDataId;
    }

    public LocCountries getCountryId() {
        return countryId;
    }

    public void setCountryId(LocCountries countryId) {
        this.countryId = countryId;
    }

    public LocStates getStateId() {
        return stateId;
    }

    public void setStateId(LocStates stateId) {
        this.stateId = stateId;
    }

    @XmlTransient
    public Collection<Locations> getLocationsCollection() {
        return locationsCollection;
    }

    public void setLocationsCollection(Collection<Locations> locationsCollection) {
        this.locationsCollection = locationsCollection;
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
        if (!(object instanceof LocCities)) {
            return false;
        }
        LocCities other = (LocCities) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
//        return "org.obi.services.entities.LocCities[ id=" + id + " ]";
        return "" + this.name + " ( > " + this.countryId.getName() + " > " + this.getStateId().getName() +") [ id=" + id + " ]";
    }
    
}
