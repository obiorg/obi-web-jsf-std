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
@Table(name = "loc_countries", catalog = "OBI", schema = "dbo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "LocCountries.findAll", query = "SELECT l FROM LocCountries l"),
    @NamedQuery(name = "LocCountries.findById", query = "SELECT l FROM LocCountries l WHERE l.id = :id"),
    @NamedQuery(name = "LocCountries.findByName", query = "SELECT l FROM LocCountries l WHERE l.name = :name"),
    @NamedQuery(name = "LocCountries.findByIso3", query = "SELECT l FROM LocCountries l WHERE l.iso3 = :iso3"),
    @NamedQuery(name = "LocCountries.findByNumericCode", query = "SELECT l FROM LocCountries l WHERE l.numericCode = :numericCode"),
    @NamedQuery(name = "LocCountries.findByIso2", query = "SELECT l FROM LocCountries l WHERE l.iso2 = :iso2"),
    @NamedQuery(name = "LocCountries.findByPhonecode", query = "SELECT l FROM LocCountries l WHERE l.phonecode = :phonecode"),
    @NamedQuery(name = "LocCountries.findByCapital", query = "SELECT l FROM LocCountries l WHERE l.capital = :capital"),
    @NamedQuery(name = "LocCountries.findByCurrency", query = "SELECT l FROM LocCountries l WHERE l.currency = :currency"),
    @NamedQuery(name = "LocCountries.findByCurrencyName", query = "SELECT l FROM LocCountries l WHERE l.currencyName = :currencyName"),
    @NamedQuery(name = "LocCountries.findByCurrencySymbol", query = "SELECT l FROM LocCountries l WHERE l.currencySymbol = :currencySymbol"),
    @NamedQuery(name = "LocCountries.findByTld", query = "SELECT l FROM LocCountries l WHERE l.tld = :tld"),
    @NamedQuery(name = "LocCountries.findByNative1", query = "SELECT l FROM LocCountries l WHERE l.native1 = :native1"),
    @NamedQuery(name = "LocCountries.findByRegion", query = "SELECT l FROM LocCountries l WHERE l.region = :region"),
    @NamedQuery(name = "LocCountries.findBySubregion", query = "SELECT l FROM LocCountries l WHERE l.subregion = :subregion"),
    @NamedQuery(name = "LocCountries.findByNationality", query = "SELECT l FROM LocCountries l WHERE l.nationality = :nationality"),
    @NamedQuery(name = "LocCountries.findByLatitude", query = "SELECT l FROM LocCountries l WHERE l.latitude = :latitude"),
    @NamedQuery(name = "LocCountries.findByLongitude", query = "SELECT l FROM LocCountries l WHERE l.longitude = :longitude"),
    @NamedQuery(name = "LocCountries.findByEmoji", query = "SELECT l FROM LocCountries l WHERE l.emoji = :emoji"),
    @NamedQuery(name = "LocCountries.findByEmojiU", query = "SELECT l FROM LocCountries l WHERE l.emojiU = :emojiU"),
    @NamedQuery(name = "LocCountries.findByCreatedAt", query = "SELECT l FROM LocCountries l WHERE l.createdAt = :createdAt"),
    @NamedQuery(name = "LocCountries.findByUpdatedAt", query = "SELECT l FROM LocCountries l WHERE l.updatedAt = :updatedAt"),
    @NamedQuery(name = "LocCountries.findByFlag", query = "SELECT l FROM LocCountries l WHERE l.flag = :flag"),
    @NamedQuery(name = "LocCountries.findByWikiDataId", query = "SELECT l FROM LocCountries l WHERE l.wikiDataId = :wikiDataId")})
public class LocCountries implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    private String name;
    @Size(max = 3)
    private String iso3;
    @Size(max = 3)
    @Column(name = "numeric_code")
    private String numericCode;
    @Size(max = 2)
    private String iso2;
    @Size(max = 255)
    private String phonecode;
    @Size(max = 255)
    private String capital;
    @Size(max = 255)
    private String currency;
    @Size(max = 255)
    @Column(name = "currency_name")
    private String currencyName;
    @Size(max = 255)
    @Column(name = "currency_symbol")
    private String currencySymbol;
    @Size(max = 255)
    private String tld;
    @Size(max = 255)
    @Column(name = "native")
    private String native1;
    @Size(max = 255)
    private String region;
    @Size(max = 255)
    private String subregion;
    @Size(max = 255)
    private String nationality;
    @Lob
    @Size(max = 2147483647)
    private String timezones;
    @Lob
    @Size(max = 2147483647)
    private String translations;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    private BigDecimal latitude;
    private BigDecimal longitude;
    @Size(max = 191)
    private String emoji;
    @Size(max = 191)
    private String emojiU;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "countryId", fetch = FetchType.EAGER)
    private Collection<LocStates> locStatesCollection;
    @JoinColumn(name = "region_id", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.EAGER)
    private LocRegions regionId;
    @JoinColumn(name = "subregion_id", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.EAGER)
    private LocSubregions subregionId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "countryId", fetch = FetchType.EAGER)
    private Collection<LocCities> locCitiesCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "country", fetch = FetchType.EAGER)
    private Collection<Locations> locationsCollection;

    public LocCountries() {
    }

    public LocCountries(Integer id) {
        this.id = id;
    }

    public LocCountries(Integer id, String name, Date updatedAt, boolean flag) {
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

    public String getIso3() {
        return iso3;
    }

    public void setIso3(String iso3) {
        this.iso3 = iso3;
    }

    public String getNumericCode() {
        return numericCode;
    }

    public void setNumericCode(String numericCode) {
        this.numericCode = numericCode;
    }

    public String getIso2() {
        return iso2;
    }

    public void setIso2(String iso2) {
        this.iso2 = iso2;
    }

    public String getPhonecode() {
        return phonecode;
    }

    public void setPhonecode(String phonecode) {
        this.phonecode = phonecode;
    }

    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getCurrencyName() {
        return currencyName;
    }

    public void setCurrencyName(String currencyName) {
        this.currencyName = currencyName;
    }

    public String getCurrencySymbol() {
        return currencySymbol;
    }

    public void setCurrencySymbol(String currencySymbol) {
        this.currencySymbol = currencySymbol;
    }

    public String getTld() {
        return tld;
    }

    public void setTld(String tld) {
        this.tld = tld;
    }

    public String getNative1() {
        return native1;
    }

    public void setNative1(String native1) {
        this.native1 = native1;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getSubregion() {
        return subregion;
    }

    public void setSubregion(String subregion) {
        this.subregion = subregion;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getTimezones() {
        return timezones;
    }

    public void setTimezones(String timezones) {
        this.timezones = timezones;
    }

    public String getTranslations() {
        return translations;
    }

    public void setTranslations(String translations) {
        this.translations = translations;
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

    public String getEmoji() {
        return emoji;
    }

    public void setEmoji(String emoji) {
        this.emoji = emoji;
    }

    public String getEmojiU() {
        return emojiU;
    }

    public void setEmojiU(String emojiU) {
        this.emojiU = emojiU;
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
    public Collection<LocStates> getLocStatesCollection() {
        return locStatesCollection;
    }

    public void setLocStatesCollection(Collection<LocStates> locStatesCollection) {
        this.locStatesCollection = locStatesCollection;
    }

    public LocRegions getRegionId() {
        return regionId;
    }

    public void setRegionId(LocRegions regionId) {
        this.regionId = regionId;
    }

    public LocSubregions getSubregionId() {
        return subregionId;
    }

    public void setSubregionId(LocSubregions subregionId) {
        this.subregionId = subregionId;
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
        if (!(object instanceof LocCountries)) {
            return false;
        }
        LocCountries other = (LocCountries) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
//        return "org.obi.services.entities.LocCountries[ id=" + id + " ]";
        return "" + this.iso3 + " - " + this.name 
                + " (> " + this.region + "/" + this.subregion + ") [ id=" + id + " ]";
    }
    
}
