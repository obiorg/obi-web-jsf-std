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

/**
 *
 * @author r.hendrick
 */
@Entity
@Table(name = "analyse_methods", catalog = "OBI", schema = "dbo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AnalyseMethods.findAll", query = "SELECT a FROM AnalyseMethods a"),
    @NamedQuery(name = "AnalyseMethods.findById", query = "SELECT a FROM AnalyseMethods a WHERE a.id = :id"),
    @NamedQuery(name = "AnalyseMethods.findByDeleted", query = "SELECT a FROM AnalyseMethods a WHERE a.deleted = :deleted"),
    @NamedQuery(name = "AnalyseMethods.findByCreated", query = "SELECT a FROM AnalyseMethods a WHERE a.created = :created"),
    @NamedQuery(name = "AnalyseMethods.findByChanged", query = "SELECT a FROM AnalyseMethods a WHERE a.changed = :changed"),
    @NamedQuery(name = "AnalyseMethods.findByMethod", query = "SELECT a FROM AnalyseMethods a WHERE a.method = :method"),
    @NamedQuery(name = "AnalyseMethods.findByDesignation", query = "SELECT a FROM AnalyseMethods a WHERE a.designation = :designation"),
    @NamedQuery(name = "AnalyseMethods.findByFilepath", query = "SELECT a FROM AnalyseMethods a WHERE a.filepath = :filepath")})
public class AnalyseMethods implements Serializable {

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
    private String method;
    @Size(max = 255)
    private String designation;
    @Lob
    @Size(max = 2147483647)
    private String description;
    @Size(max = 4096)
    private String filepath;
    @JoinColumn(name = "business", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.EAGER)
    private Businesses business;
    @JoinColumn(name = "company", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.EAGER)
    private Companies company;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "method", fetch = FetchType.EAGER)
    private Collection<AnalyseTypes> analyseTypesCollection;

    public AnalyseMethods() {
    }

    public AnalyseMethods(Integer id) {
        this.id = id;
    }

    public AnalyseMethods(Integer id, String method) {
        this.id = id;
        this.method = method;
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

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
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

    public String getFilepath() {
        return filepath;
    }

    public void setFilepath(String filepath) {
        this.filepath = filepath;
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

    @XmlTransient
    public Collection<AnalyseTypes> getAnalyseTypesCollection() {
        return analyseTypesCollection;
    }

    public void setAnalyseTypesCollection(Collection<AnalyseTypes> analyseTypesCollection) {
        this.analyseTypesCollection = analyseTypesCollection;
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
        if (!(object instanceof AnalyseMethods)) {
            return false;
        }
        AnalyseMethods other = (AnalyseMethods) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
//        return "org.obi.services.entities.AnalyseMethods[ id=" + id + " ]";
        return "" + this.method + " - " + this.designation + " [ id=" + id + " ]";
    }
    
}
