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
import org.obi.services.obi.web.jsf.std.entities.business.Businesses;
import org.obi.services.obi.web.jsf.std.entities.business.Companies;
import org.obi.services.obi.web.jsf.std.entities.measures.MeasUnits;

/**
 *
 * @author r.hendrick
 */
@Entity
@Table(name = "analyse_types", catalog = "OBI", schema = "dbo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AnalyseTypes.findAll", query = "SELECT a FROM AnalyseTypes a"),
    @NamedQuery(name = "AnalyseTypes.findById", query = "SELECT a FROM AnalyseTypes a WHERE a.id = :id"),
    @NamedQuery(name = "AnalyseTypes.findByDeleted", query = "SELECT a FROM AnalyseTypes a WHERE a.deleted = :deleted"),
    @NamedQuery(name = "AnalyseTypes.findByCreated", query = "SELECT a FROM AnalyseTypes a WHERE a.created = :created"),
    @NamedQuery(name = "AnalyseTypes.findByChanged", query = "SELECT a FROM AnalyseTypes a WHERE a.changed = :changed"),
    @NamedQuery(name = "AnalyseTypes.findByType", query = "SELECT a FROM AnalyseTypes a WHERE a.type = :type"),
    @NamedQuery(name = "AnalyseTypes.findByDesignation", query = "SELECT a FROM AnalyseTypes a WHERE a.designation = :designation")})
public class AnalyseTypes implements Serializable {

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
    private String type;
    @Size(max = 255)
    private String designation;
    @Lob
    @Size(max = 2147483647)
    private String description;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "type", fetch = FetchType.EAGER)
    private Collection<AnalyseAllowed> analyseAllowedCollection;
    @JoinColumn(name = "category", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private AnalyseCategories category;
    @JoinColumn(name = "method", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private AnalyseMethods method;
    @JoinColumn(name = "business", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.EAGER)
    private Businesses business;
    @JoinColumn(name = "company", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.EAGER)
    private Companies company;
    @JoinColumn(name = "unit", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private MeasUnits unit;

    public AnalyseTypes() {
    }

    public AnalyseTypes(Integer id) {
        this.id = id;
    }

    public AnalyseTypes(Integer id, String type) {
        this.id = id;
        this.type = type;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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
    public Collection<AnalyseAllowed> getAnalyseAllowedCollection() {
        return analyseAllowedCollection;
    }

    public void setAnalyseAllowedCollection(Collection<AnalyseAllowed> analyseAllowedCollection) {
        this.analyseAllowedCollection = analyseAllowedCollection;
    }

    public AnalyseCategories getCategory() {
        return category;
    }

    public void setCategory(AnalyseCategories category) {
        this.category = category;
    }

    public AnalyseMethods getMethod() {
        return method;
    }

    public void setMethod(AnalyseMethods method) {
        this.method = method;
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

    public MeasUnits getUnit() {
        return unit;
    }

    public void setUnit(MeasUnits unit) {
        this.unit = unit;
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
        if (!(object instanceof AnalyseTypes)) {
            return false;
        }
        AnalyseTypes other = (AnalyseTypes) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
//        return "org.obi.services.entities.AnalyseTypes[ id=" + id + " ]";
        return "" + this.type + " - " + this.designation + " [ id=" + id + " ]";
    }

}
