/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.obi.services.obi.web.jsf.std.entities.persistence;

import org.obi.services.obi.web.jsf.std.entities.measures.MeasLimitsGroups;
import org.obi.services.obi.web.jsf.std.entities.measures.MeasComparators;
import org.obi.services.obi.web.jsf.std.entities.business.Companies;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import org.obi.services.obi.web.jsf.std.entities.tags.Tags;

/**
 *
 * @author r.hendrick
 */
@Entity
@Table(name = "pers_standard_limits", catalog = "OBI", schema = "dbo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PersStandardLimits.findAll", query = "SELECT p FROM PersStandardLimits p"),
    @NamedQuery(name = "PersStandardLimits.findById", query = "SELECT p FROM PersStandardLimits p WHERE p.id = :id"),
    @NamedQuery(name = "PersStandardLimits.findByDeleted", query = "SELECT p FROM PersStandardLimits p WHERE p.deleted = :deleted"),
    @NamedQuery(name = "PersStandardLimits.findByCreated", query = "SELECT p FROM PersStandardLimits p WHERE p.created = :created"),
    @NamedQuery(name = "PersStandardLimits.findByChanged", query = "SELECT p FROM PersStandardLimits p WHERE p.changed = :changed"),
    @NamedQuery(name = "PersStandardLimits.findByName", query = "SELECT p FROM PersStandardLimits p WHERE p.name = :name"),
    @NamedQuery(name = "PersStandardLimits.findByValue", query = "SELECT p FROM PersStandardLimits p WHERE p.value = :value"),
    @NamedQuery(name = "PersStandardLimits.findByDelay", query = "SELECT p FROM PersStandardLimits p WHERE p.delay = :delay"),
    @NamedQuery(name = "PersStandardLimits.findByHysteresis", query = "SELECT p FROM PersStandardLimits p WHERE p.hysteresis = :hysteresis"),
    @NamedQuery(name = "PersStandardLimits.findBySort", query = "SELECT p FROM PersStandardLimits p WHERE p.sort = :sort"),
    @NamedQuery(name = "PersStandardLimits.findByHit", query = "SELECT p FROM PersStandardLimits p WHERE p.hit = :hit"),
    @NamedQuery(name = "PersStandardLimits.findByReached", query = "SELECT p FROM PersStandardLimits p WHERE p.reached = :reached")})
public class PersStandardLimits implements Serializable {

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
    @Size(max = 255)
    private String name;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    private Double value;
    private Integer delay;
    private Double hysteresis;
    private Integer sort;
    private Boolean hit;
    private Boolean reached;
    @JoinColumn(name = "company", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Companies company;
    @JoinColumn(name = "comparator", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private MeasComparators comparator;
    @JoinColumn(name = "\"group\"", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    private MeasLimitsGroups group1;
    @JoinColumn(name = "pers_standard", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private PersStandard persStandard;
    @JoinColumn(name = "tag", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Tags tag;

    public PersStandardLimits() {
    }

    public PersStandardLimits(Integer id) {
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public Integer getDelay() {
        return delay;
    }

    public void setDelay(Integer delay) {
        this.delay = delay;
    }

    public Double getHysteresis() {
        return hysteresis;
    }

    public void setHysteresis(Double hysteresis) {
        this.hysteresis = hysteresis;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public Boolean getHit() {
        return hit;
    }

    public void setHit(Boolean hit) {
        this.hit = hit;
    }

    public Boolean getReached() {
        return reached;
    }

    public void setReached(Boolean reached) {
        this.reached = reached;
    }

    public Companies getCompany() {
        return company;
    }

    public void setCompany(Companies company) {
        this.company = company;
    }

    public MeasComparators getComparator() {
        return comparator;
    }

    public void setComparator(MeasComparators comparator) {
        this.comparator = comparator;
    }

    public MeasLimitsGroups getGroup1() {
        return group1;
    }

    public void setGroup1(MeasLimitsGroups group1) {
        this.group1 = group1;
    }

    public PersStandard getPersStandard() {
        return persStandard;
    }

    public void setPersStandard(PersStandard persStandard) {
        this.persStandard = persStandard;
    }

    public Tags getTag() {
        return tag;
    }

    public void setTag(Tags tag) {
        this.tag = tag;
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
        if (!(object instanceof PersStandardLimits)) {
            return false;
        }
        PersStandardLimits other = (PersStandardLimits) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
//        return "org.obi.services.entities.PersStandardLimits[ id=" + id + " ]";
        return "" + this.name  + " - " 
                + this.tag.getName() + " - " 
                + this.persStandard + " - "
                + this.value + " - "
                + this.comparator.getSymbol() + " - " 
                + " [ id=" + id + " ]";
    }
    
}
