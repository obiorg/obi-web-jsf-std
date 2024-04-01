/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.obi.services.obi.web.jsf.std.entities.locations;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
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
@Table(name = "loc_subregions", catalog = "OBI", schema = "dbo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "LocSubregions.findAll", query = "SELECT l FROM LocSubregions l"),
    @NamedQuery(name = "LocSubregions.findById", query = "SELECT l FROM LocSubregions l WHERE l.id = :id"),
    @NamedQuery(name = "LocSubregions.findByName", query = "SELECT l FROM LocSubregions l WHERE l.name = :name"),
    @NamedQuery(name = "LocSubregions.findByCreatedAt", query = "SELECT l FROM LocSubregions l WHERE l.createdAt = :createdAt"),
    @NamedQuery(name = "LocSubregions.findByUpdatedAt", query = "SELECT l FROM LocSubregions l WHERE l.updatedAt = :updatedAt"),
    @NamedQuery(name = "LocSubregions.findByFlag", query = "SELECT l FROM LocSubregions l WHERE l.flag = :flag"),
    @NamedQuery(name = "LocSubregions.findByWikiDataId", query = "SELECT l FROM LocSubregions l WHERE l.wikiDataId = :wikiDataId")})
public class LocSubregions implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    private String name;
    @Lob
    @Size(max = 2147483647)
    private String translations;
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
    @OneToMany(mappedBy = "subregionId", fetch = FetchType.LAZY)
    private Collection<LocCountries> locCountriesCollection;
    @JoinColumn(name = "region_id", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private LocRegions regionId;

    public LocSubregions() {
    }

    public LocSubregions(Integer id) {
        this.id = id;
    }

    public LocSubregions(Integer id, String name, Date updatedAt, boolean flag) {
        this.id = id;
        this.name = name;
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

    public String getTranslations() {
        return translations;
    }

    public void setTranslations(String translations) {
        this.translations = translations;
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

    @XmlTransient
    public Collection<LocCountries> getLocCountriesCollection() {
        return locCountriesCollection;
    }

    public void setLocCountriesCollection(Collection<LocCountries> locCountriesCollection) {
        this.locCountriesCollection = locCountriesCollection;
    }

    public LocRegions getRegionId() {
        return regionId;
    }

    public void setRegionId(LocRegions regionId) {
        this.regionId = regionId;
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
        if (!(object instanceof LocSubregions)) {
            return false;
        }
        LocSubregions other = (LocSubregions) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
//        return "org.obi.services.entities.LocSubregions[ id=" + id + " ]";
        return "" + this.name + " (> " + this.getRegionId().getName() + ") [ id=" + id + " ]";
    }
    
}
