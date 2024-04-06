/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.obi.services.obi.web.jsf.std.entities.persistence;

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
@Table(catalog = "OBI", schema = "dbo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Persistence.findAll", query = "SELECT p FROM Persistence p"),
    @NamedQuery(name = "Persistence.findById", query = "SELECT p FROM Persistence p WHERE p.id = :id"),
    @NamedQuery(name = "Persistence.findByDeleted", query = "SELECT p FROM Persistence p WHERE p.deleted = :deleted"),
    @NamedQuery(name = "Persistence.findByCreated", query = "SELECT p FROM Persistence p WHERE p.created = :created"),
    @NamedQuery(name = "Persistence.findByChanged", query = "SELECT p FROM Persistence p WHERE p.changed = :changed"),
    @NamedQuery(name = "Persistence.findByActivate", query = "SELECT p FROM Persistence p WHERE p.activate = :activate"),
    @NamedQuery(name = "Persistence.findByComment", query = "SELECT p FROM Persistence p WHERE p.comment = :comment")})
public class Persistence implements Serializable {

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
    private Boolean activate;
    @Size(max = 512)
    private String comment;
    @JoinColumn(name = "company", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Companies company;
    @JoinColumn(name = "method", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private PersMethod method;
    @JoinColumn(name = "tag", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Tags tag;

    public Persistence() {
    }

    public Persistence(Integer id) {
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

    public Boolean getActivate() {
        return activate;
    }

    public void setActivate(Boolean activate) {
        this.activate = activate;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Companies getCompany() {
        return company;
    }

    public void setCompany(Companies company) {
        this.company = company;
    }

    public PersMethod getMethod() {
        return method;
    }

    public void setMethod(PersMethod method) {
        this.method = method;
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
        if (!(object instanceof Persistence)) {
            return false;
        }
        Persistence other = (Persistence) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
//        return "org.obi.services.entities.Persistence[ id=" + id + " ]";
        return "" + this.tag.getName() + " - " + this.method.getName() + " [ id=" + id + " ]";
    }
    
}
