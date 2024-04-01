/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.obi.services.obi.web.jsf.std.entities.analyses;

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
import org.obi.services.obi.web.jsf.std.entities.business.Companies;
import org.obi.services.obi.web.jsf.std.entities.maintenance.Equipements;

/**
 *
 * @author r.hendrick
 */
@Entity
@Table(name = "analyse_points", catalog = "OBI", schema = "dbo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AnalysePoints.findAll", query = "SELECT a FROM AnalysePoints a"),
    @NamedQuery(name = "AnalysePoints.findById", query = "SELECT a FROM AnalysePoints a WHERE a.id = :id"),
    @NamedQuery(name = "AnalysePoints.findByDeleted", query = "SELECT a FROM AnalysePoints a WHERE a.deleted = :deleted"),
    @NamedQuery(name = "AnalysePoints.findByCreated", query = "SELECT a FROM AnalysePoints a WHERE a.created = :created"),
    @NamedQuery(name = "AnalysePoints.findByChanged", query = "SELECT a FROM AnalysePoints a WHERE a.changed = :changed"),
    @NamedQuery(name = "AnalysePoints.findByPoint", query = "SELECT a FROM AnalysePoints a WHERE a.point = :point"),
    @NamedQuery(name = "AnalysePoints.findByDesignation", query = "SELECT a FROM AnalysePoints a WHERE a.designation = :designation"),
    @NamedQuery(name = "AnalysePoints.findByAvailable", query = "SELECT a FROM AnalysePoints a WHERE a.available = :available"),
    @NamedQuery(name = "AnalysePoints.findByPicture", query = "SELECT a FROM AnalysePoints a WHERE a.picture = :picture")})
public class AnalysePoints implements Serializable {

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
    private String point;
    @Size(max = 255)
    private String designation;
    private Boolean available;
    @Size(max = 4096)
    private String picture;
    @Lob
    @Size(max = 2147483647)
    private String description;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "point", fetch = FetchType.LAZY)
    private Collection<AnalyseAllowed> analyseAllowedCollection;
    @JoinColumn(name = "company", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Companies company;
    @JoinColumn(name = "equipement", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Equipements equipement;

    public AnalysePoints() {
    }

    public AnalysePoints(Integer id) {
        this.id = id;
    }

    public AnalysePoints(Integer id, String point) {
        this.id = id;
        this.point = point;
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

    public String getPoint() {
        return point;
    }

    public void setPoint(String point) {
        this.point = point;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public Boolean getAvailable() {
        return available;
    }

    public void setAvailable(Boolean available) {
        this.available = available;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @XmlTransient
    public Collection<AnalyseAllowed> getAnalyseAllowedCollection() {
        return analyseAllowedCollection;
    }

    public void setAnalyseAllowedCollection(Collection<AnalyseAllowed> analyseAllowedCollection) {
        this.analyseAllowedCollection = analyseAllowedCollection;
    }

    public Companies getCompany() {
        return company;
    }

    public void setCompany(Companies company) {
        this.company = company;
    }

    public Equipements getEquipement() {
        return equipement;
    }

    public void setEquipement(Equipements equipement) {
        this.equipement = equipement;
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
        if (!(object instanceof AnalysePoints)) {
            return false;
        }
        AnalysePoints other = (AnalysePoints) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
//        return "org.obi.services.entities.AnalysePoints[ id=" + id + " ]";
        return "" + this.point + " - " + this.designation + " [ id=" + id + " ]";
    }

}
