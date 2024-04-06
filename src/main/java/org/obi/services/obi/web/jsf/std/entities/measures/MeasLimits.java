/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.obi.services.obi.web.jsf.std.entities.measures;

import org.obi.services.obi.web.jsf.std.entities.business.Companies;
import org.obi.services.obi.web.jsf.std.entities.business.Businesses;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
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
@Table(name = "meas_limits", catalog = "OBI", schema = "dbo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MeasLimits.findAll", query = "SELECT m FROM MeasLimits m"),
    @NamedQuery(name = "MeasLimits.findById", query = "SELECT m FROM MeasLimits m WHERE m.id = :id"),
    @NamedQuery(name = "MeasLimits.findByDeleted", query = "SELECT m FROM MeasLimits m WHERE m.deleted = :deleted"),
    @NamedQuery(name = "MeasLimits.findByCreated", query = "SELECT m FROM MeasLimits m WHERE m.created = :created"),
    @NamedQuery(name = "MeasLimits.findByChanged", query = "SELECT m FROM MeasLimits m WHERE m.changed = :changed"),
    @NamedQuery(name = "MeasLimits.findByName", query = "SELECT m FROM MeasLimits m WHERE m.name = :name"),
    @NamedQuery(name = "MeasLimits.findByValue", query = "SELECT m FROM MeasLimits m WHERE m.value = :value"),
    @NamedQuery(name = "MeasLimits.findByDelay", query = "SELECT m FROM MeasLimits m WHERE m.delay = :delay"),
    @NamedQuery(name = "MeasLimits.findByHysteresis", query = "SELECT m FROM MeasLimits m WHERE m.hysteresis = :hysteresis"),
    @NamedQuery(name = "MeasLimits.findByTarget", query = "SELECT m FROM MeasLimits m WHERE m.target = :target"),
    @NamedQuery(name = "MeasLimits.findByEnable", query = "SELECT m FROM MeasLimits m WHERE m.enable = :enable"),
    @NamedQuery(name = "MeasLimits.findBySort", query = "SELECT m FROM MeasLimits m WHERE m.sort = :sort")})
public class MeasLimits implements Serializable {

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
    private Boolean target;
    private Boolean enable;
    private Integer sort;
    @Lob
    @Size(max = 2147483647)
    private String description;
    @JoinColumn(name = "business", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.EAGER)
    private Businesses business;
    @JoinColumn(name = "company", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.EAGER)
    private Companies company;
    @JoinColumn(name = "comparator", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private MeasComparators comparator;
    @JoinColumn(name = "\"group\"", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.EAGER)
    private MeasLimitsGroups group1;
    @JoinColumn(name = "tag", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.EAGER)
    private Tags tag;

    public MeasLimits() {
    }

    public MeasLimits(Integer id) {
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

    public Boolean getTarget() {
        return target;
    }

    public void setTarget(Boolean target) {
        this.target = target;
    }

    public Boolean getEnable() {
        return enable;
    }

    public void setEnable(Boolean enable) {
        this.enable = enable;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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
        if (!(object instanceof MeasLimits)) {
            return false;
        }
        MeasLimits other = (MeasLimits) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
//        return "org.obi.services.entities.MeasLimits[ id=" + id + " ]";
        return "" + this.name + "/" +  this.tag.getName() + " - " + this.group1.getDesignation() + " [ id=" + id + " ]";
    }
    
}
