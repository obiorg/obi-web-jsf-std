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
@Table(name = "loc_states", catalog = "OBI", schema = "dbo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "LocStates.findAll", query = "SELECT l FROM LocStates l"),
    @NamedQuery(name = "LocStates.findById", query = "SELECT l FROM LocStates l WHERE l.id = :id"),
    @NamedQuery(name = "LocStates.findByName", query = "SELECT l FROM LocStates l WHERE l.name = :name"),
    @NamedQuery(name = "LocStates.findByCountryCode", query = "SELECT l FROM LocStates l WHERE l.countryCode = :countryCode"),
    @NamedQuery(name = "LocStates.findByFipsCode", query = "SELECT l FROM LocStates l WHERE l.fipsCode = :fipsCode"),
    @NamedQuery(name = "LocStates.findByIso2", query = "SELECT l FROM LocStates l WHERE l.iso2 = :iso2"),
    @NamedQuery(name = "LocStates.findByType", query = "SELECT l FROM LocStates l WHERE l.type = :type"),
    @NamedQuery(name = "LocStates.findByLatitude", query = "SELECT l FROM LocStates l WHERE l.latitude = :latitude"),
    @NamedQuery(name = "LocStates.findByLongitude", query = "SELECT l FROM LocStates l WHERE l.longitude = :longitude"),
    @NamedQuery(name = "LocStates.findByCreatedAt", query = "SELECT l FROM LocStates l WHERE l.createdAt = :createdAt"),
    @NamedQuery(name = "LocStates.findByUpdatedAt", query = "SELECT l FROM LocStates l WHERE l.updatedAt = :updatedAt"),
    @NamedQuery(name = "LocStates.findByFlag", query = "SELECT l FROM LocStates l WHERE l.flag = :flag"),
    @NamedQuery(name = "LocStates.findByWikiDataId", query = "SELECT l FROM LocStates l WHERE l.wikiDataId = :wikiDataId")})
public class LocStates implements Serializable {

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
    @Size(min = 1, max = 2)
    @Column(name = "country_code")
    private String countryCode;
    @Size(max = 255)
    @Column(name = "fips_code")
    private String fipsCode;
    @Size(max = 255)
    private String iso2;
    @Size(max = 191)
    private String type;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    private BigDecimal latitude;
    private BigDecimal longitude;
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
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private LocCountries countryId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "stateId", fetch = FetchType.EAGER)
    private Collection<LocCities> locCitiesCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "state", fetch = FetchType.EAGER)
    private Collection<Locations> locationsCollection;

    public LocStates() {
    }

    public LocStates(Integer id) {
        this.id = id;
    }

    public LocStates(Integer id, String name, String countryCode, Date updatedAt, boolean flag) {
        this.id = id;
        this.name = name;
        this.countryCode = countryCode;
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

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getFipsCode() {
        return fipsCode;
    }

    public void setFipsCode(String fipsCode) {
        this.fipsCode = fipsCode;
    }

    public String getIso2() {
        return iso2;
    }

    public void setIso2(String iso2) {
        this.iso2 = iso2;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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

    @XmlTransient
    public Collection<LocCities> getLocCitiesCollection() {
        return locCitiesCollection;
    }

    public void setLocCitiesCollection(Collection<LocCities> locCitiesCollection) {
        this.locCitiesCollection = locCitiesCollection;
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
        if (!(object instanceof LocStates)) {
            return false;
        }
        LocStates other = (LocStates) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
//        return "org.obi.services.entities.LocStates[ id=" + id + " ]";
        return "" + this.name + " (> " + this.getCountryId().getName() + ") [ id=" + id + " ]";
    }
    
}
