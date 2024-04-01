/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.obi.services.obi.web.jsf.std.entities.locations;

import org.obi.services.obi.web.jsf.std.entities.business.Companies;
import org.obi.services.obi.web.jsf.std.entities.business.Entities;
import org.obi.services.obi.web.jsf.std.entities.business.Businesses;
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
import javax.persistence.ManyToOne;
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
@Table(catalog = "OBI", schema = "dbo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Locations.findAll", query = "SELECT l.id, l.address, l.address1, l.address3, l.bloc, l.changed, l.created, l.deleted, l.designation, l.floor, l.group, l.location, l.number, l.city,  l.country,  l.state FROM Locations l"),
    @NamedQuery(name = "Locations.findById", query = "SELECT l FROM Locations l WHERE l.id = :id"),
    @NamedQuery(name = "Locations.findByDeleted", query = "SELECT l FROM Locations l WHERE l.deleted = :deleted"),
    @NamedQuery(name = "Locations.findByCreated", query = "SELECT l FROM Locations l WHERE l.created = :created"),
    @NamedQuery(name = "Locations.findByChanged", query = "SELECT l FROM Locations l WHERE l.changed = :changed"),
    @NamedQuery(name = "Locations.findByLocation", query = "SELECT l FROM Locations l WHERE l.location = :location"),
    @NamedQuery(name = "Locations.findByDesignation", query = "SELECT l FROM Locations l WHERE l.designation = :designation"),
    @NamedQuery(name = "Locations.findByGroup", query = "SELECT l FROM Locations l WHERE l.group = :group"),
    @NamedQuery(name = "Locations.findByAddress", query = "SELECT l FROM Locations l WHERE l.address = :address"),
    @NamedQuery(name = "Locations.findByAddress1", query = "SELECT l FROM Locations l WHERE l.address1 = :address1"),
    @NamedQuery(name = "Locations.findByAddress3", query = "SELECT l FROM Locations l WHERE l.address3 = :address3"),
    @NamedQuery(name = "Locations.findByBloc", query = "SELECT l FROM Locations l WHERE l.bloc = :bloc"),
    @NamedQuery(name = "Locations.findByFloor", query = "SELECT l FROM Locations l WHERE l.floor = :floor"),
    @NamedQuery(name = "Locations.findByNumber", query = "SELECT l FROM Locations l WHERE l.number = :number")})
public class Locations implements Serializable {

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
    private String location;
    @Size(max = 255)
    private String designation;
    @Size(max = 45)
    @Column(name = "\"group\"")
    private String group;
    @Size(max = 255)
    private String address;
    @Size(max = 255)
    private String address1;
    @Size(max = 255)
    private String address3;
    @Size(max = 45)
    private String bloc;
    private Integer floor;
    @Size(max = 45)
    private String number;
    @OneToMany(mappedBy = "location", fetch = FetchType.LAZY)
    private Collection<Companies> companiesCollection;
    @OneToMany(mappedBy = "location", fetch = FetchType.LAZY)
    private Collection<Businesses> businessesCollection;
    @OneToMany(mappedBy = "location", fetch = FetchType.LAZY)
    private Collection<Entities> entitiesCollection;
    @JoinColumn(name = "city", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private LocCities city;
    @JoinColumn(name = "country", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private LocCountries country;
    @JoinColumn(name = "state", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private LocStates state;

    public Locations() {
    }

    public Locations(Integer id) {
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

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddress1() {
        return address1;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public String getAddress3() {
        return address3;
    }

    public void setAddress3(String address3) {
        this.address3 = address3;
    }

    public String getBloc() {
        return bloc;
    }

    public void setBloc(String bloc) {
        this.bloc = bloc;
    }

    public Integer getFloor() {
        return floor;
    }

    public void setFloor(Integer floor) {
        this.floor = floor;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    @XmlTransient
    public Collection<Companies> getCompaniesCollection() {
        return companiesCollection;
    }

    public void setCompaniesCollection(Collection<Companies> companiesCollection) {
        this.companiesCollection = companiesCollection;
    }

    @XmlTransient
    public Collection<Businesses> getBusinessesCollection() {
        return businessesCollection;
    }

    public void setBusinessesCollection(Collection<Businesses> businessesCollection) {
        this.businessesCollection = businessesCollection;
    }

    @XmlTransient
    public Collection<Entities> getEntitiesCollection() {
        return entitiesCollection;
    }

    public void setEntitiesCollection(Collection<Entities> entitiesCollection) {
        this.entitiesCollection = entitiesCollection;
    }

    public LocCities getCity() {
        return city;
    }

    public void setCity(LocCities city) {
        this.city = city;
    }

    public LocCountries getCountry() {
        return country;
    }

    public void setCountry(LocCountries country) {
        this.country = country;
    }

    public LocStates getState() {
        return state;
    }

    public void setState(LocStates state) {
        this.state = state;
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
        if (!(object instanceof Locations)) {
            return false;
        }
        Locations other = (Locations) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
//        return "org.obi.services.entities.Locations[ id=" + id + " ]";
        return "" + this.location + " - " + this.designation 
                + this.group + " (" + this.getCountry().getName() +"; "
                + this.getState().getName() + "; " + this.city.getName() + ") [ id=" + id + " ]";
    }
    
}
