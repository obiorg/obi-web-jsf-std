/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.obi.services.obi.web.jsf.std.entities.analyses;

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
import org.obi.services.obi.web.jsf.std.entities.business.Companies;
import org.obi.services.obi.web.jsf.std.entities.tags.Tags;

/**
 *
 * @author r.hendrick
 */
@Entity
@Table(name = "analyse_allowed", catalog = "OBI", schema = "dbo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AnalyseAllowed.findAll", query = "SELECT a FROM AnalyseAllowed a"),
    @NamedQuery(name = "AnalyseAllowed.findById", query = "SELECT a FROM AnalyseAllowed a WHERE a.id = :id"),
    @NamedQuery(name = "AnalyseAllowed.findByDeleted", query = "SELECT a FROM AnalyseAllowed a WHERE a.deleted = :deleted"),
    @NamedQuery(name = "AnalyseAllowed.findByCreated", query = "SELECT a FROM AnalyseAllowed a WHERE a.created = :created"),
    @NamedQuery(name = "AnalyseAllowed.findByChanged", query = "SELECT a FROM AnalyseAllowed a WHERE a.changed = :changed"),
    @NamedQuery(name = "AnalyseAllowed.findByDesignation", query = "SELECT a FROM AnalyseAllowed a WHERE a.designation = :designation"),
    @NamedQuery(name = "AnalyseAllowed.findByEnable", query = "SELECT a FROM AnalyseAllowed a WHERE a.enable = :enable")})
public class AnalyseAllowed implements Serializable {

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
    private String designation;
    private Boolean enable;
    @Lob
    @Size(max = 2147483647)
    private String description;
    @JoinColumn(name = "point", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private AnalysePoints point;
    @JoinColumn(name = "type", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private AnalyseTypes type;
    @JoinColumn(name = "company", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Companies company;
    @JoinColumn(name = "tag", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Tags tag;

    public AnalyseAllowed() {
    }

    public AnalyseAllowed(Integer id) {
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

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public Boolean getEnable() {
        return enable;
    }

    public void setEnable(Boolean enable) {
        this.enable = enable;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public AnalysePoints getPoint() {
        return point;
    }

    public void setPoint(AnalysePoints point) {
        this.point = point;
    }

    public AnalyseTypes getType() {
        return type;
    }

    public void setType(AnalyseTypes type) {
        this.type = type;
    }

    public Companies getCompany() {
        return company;
    }

    public void setCompany(Companies company) {
        this.company = company;
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
        if (!(object instanceof AnalyseAllowed)) {
            return false;
        }
        AnalyseAllowed other = (AnalyseAllowed) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
//        return "org.obi.services.entities.AnalyseAllowed[ id=" + id + " ]";
        return "[" + this.point.toString() + "] - [" + this.type.toString() + "] (" + this.tag.getName() + ") [ id=" + id + " ]";
      }
    
}
