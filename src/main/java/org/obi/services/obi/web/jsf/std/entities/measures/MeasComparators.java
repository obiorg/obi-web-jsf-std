/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.obi.services.obi.web.jsf.std.entities.measures;

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
import org.obi.services.obi.web.jsf.std.entities.persistence.PersStandardLimits;

/**
 *
 * @author r.hendrick
 */
@Entity
@Table(name = "meas_comparators", catalog = "OBI", schema = "dbo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MeasComparators.findAll", query = "SELECT m FROM MeasComparators m"),
    @NamedQuery(name = "MeasComparators.findById", query = "SELECT m FROM MeasComparators m WHERE m.id = :id"),
    @NamedQuery(name = "MeasComparators.findByDeleted", query = "SELECT m FROM MeasComparators m WHERE m.deleted = :deleted"),
    @NamedQuery(name = "MeasComparators.findByCreated", query = "SELECT m FROM MeasComparators m WHERE m.created = :created"),
    @NamedQuery(name = "MeasComparators.findByChanged", query = "SELECT m FROM MeasComparators m WHERE m.changed = :changed"),
    @NamedQuery(name = "MeasComparators.findBySymbol", query = "SELECT m FROM MeasComparators m WHERE m.symbol = :symbol"),
    @NamedQuery(name = "MeasComparators.findByName", query = "SELECT m FROM MeasComparators m WHERE m.name = :name")})
public class MeasComparators implements Serializable {

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
    private String symbol;
    @Size(max = 255)
    private String name;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "comparator", fetch = FetchType.EAGER)
    private Collection<MeasLimits> measLimitsCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "comparator", fetch = FetchType.EAGER)
    private Collection<PersStandardLimits> persStandardLimitsCollection;

    public MeasComparators() {
    }

    public MeasComparators(Integer id) {
        this.id = id;
    }

    public MeasComparators(Integer id, String symbol) {
        this.id = id;
        this.symbol = symbol;
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

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @XmlTransient
    public Collection<MeasLimits> getMeasLimitsCollection() {
        return measLimitsCollection;
    }

    public void setMeasLimitsCollection(Collection<MeasLimits> measLimitsCollection) {
        this.measLimitsCollection = measLimitsCollection;
    }

    @XmlTransient
    public Collection<PersStandardLimits> getPersStandardLimitsCollection() {
        return persStandardLimitsCollection;
    }

    public void setPersStandardLimitsCollection(Collection<PersStandardLimits> persStandardLimitsCollection) {
        this.persStandardLimitsCollection = persStandardLimitsCollection;
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
        if (!(object instanceof MeasComparators)) {
            return false;
        }
        MeasComparators other = (MeasComparators) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
//        return "org.obi.services.entities.MeasComparators[ id=" + id + " ]";
        return "" + this.symbol + " - " + this.name + " [ id=" + id + " ]";

    }
    
}
