/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.obi.services.obi.web.jsf.std.entities.measures;

import org.obi.services.obi.web.jsf.std.entities.business.Companies;
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
import org.obi.services.obi.web.jsf.std.entities.persistence.PersStandardLimits;

/**
 *
 * @author r.hendrick
 */
@Entity
@Table(name = "meas_limits_groups", catalog = "OBI", schema = "dbo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MeasLimitsGroups.findAll", query = "SELECT m FROM MeasLimitsGroups m"),
    @NamedQuery(name = "MeasLimitsGroups.findById", query = "SELECT m FROM MeasLimitsGroups m WHERE m.id = :id"),
    @NamedQuery(name = "MeasLimitsGroups.findByDeleted", query = "SELECT m FROM MeasLimitsGroups m WHERE m.deleted = :deleted"),
    @NamedQuery(name = "MeasLimitsGroups.findByCreated", query = "SELECT m FROM MeasLimitsGroups m WHERE m.created = :created"),
    @NamedQuery(name = "MeasLimitsGroups.findByChanged", query = "SELECT m FROM MeasLimitsGroups m WHERE m.changed = :changed"),
    @NamedQuery(name = "MeasLimitsGroups.findByGroup", query = "SELECT m FROM MeasLimitsGroups m WHERE m.group = :group"),
    @NamedQuery(name = "MeasLimitsGroups.findByDesignation", query = "SELECT m FROM MeasLimitsGroups m WHERE m.designation = :designation")})
public class MeasLimitsGroups implements Serializable {

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
    
    @Column(name = "\"group\"")
    private String group;
    @Size(max = 255)
    private String designation;
    @Lob
    @Size(max = 2147483647)
    private String description;
    @OneToMany(mappedBy = "group1", fetch = FetchType.EAGER)
    private Collection<MeasLimits> measLimitsCollection;
    @OneToMany(mappedBy = "group1", fetch = FetchType.EAGER)
    private Collection<PersStandardLimits> persStandardLimitsCollection;
    @JoinColumn(name = "business", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.EAGER)
    private Businesses business;
    @JoinColumn(name = "company", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.EAGER)
    private Companies company;

    public MeasLimitsGroups() {
    }

    public MeasLimitsGroups(Integer id) {
        this.id = id;
    }

    public MeasLimitsGroups(Integer id, String group) {
        this.id = id;
        this.group = group;
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

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public Businesses getBusiness() {
        return business;
    }

    public void setBusiness(Businesses business) {
        this.business = business;
    }

    public Companies getCompany() {
        return company;
    }

    public void setCompany(Companies company) {
        this.company = company;
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
        if (!(object instanceof MeasLimitsGroups)) {
            return false;
        }
        MeasLimitsGroups other = (MeasLimitsGroups) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
//        return "org.obi.services.entities.MeasLimitsGroups[ id=" + id + " ]";
        return "" + this.group + " - " + this.designation + " [ id=" + id + " ]";
    }
    
}
