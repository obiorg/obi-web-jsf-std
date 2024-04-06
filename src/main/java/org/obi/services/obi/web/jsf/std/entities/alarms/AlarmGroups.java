/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.obi.services.obi.web.jsf.std.entities.alarms;

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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import org.obi.services.obi.web.jsf.std.entities.business.Companies;

/**
 *
 * @author r.hendrick
 */
@Entity
@Table(name = "alarm_groups", catalog = "OBI", schema = "dbo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AlarmGroups.findAll", query = "SELECT a FROM AlarmGroups a"),
    @NamedQuery(name = "AlarmGroups.findById", query = "SELECT a FROM AlarmGroups a WHERE a.id = :id"),
    @NamedQuery(name = "AlarmGroups.findByDeleted", query = "SELECT a FROM AlarmGroups a WHERE a.deleted = :deleted"),
    @NamedQuery(name = "AlarmGroups.findByCreated", query = "SELECT a FROM AlarmGroups a WHERE a.created = :created"),
    @NamedQuery(name = "AlarmGroups.findByChanged", query = "SELECT a FROM AlarmGroups a WHERE a.changed = :changed"),
    @NamedQuery(name = "AlarmGroups.findByGroup", query = "SELECT a FROM AlarmGroups a WHERE a.group = :group"),
    @NamedQuery(name = "AlarmGroups.findByComment", query = "SELECT a FROM AlarmGroups a WHERE a.comment = :comment")})
public class AlarmGroups implements Serializable {

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
    @Size(max = 512)
    private String comment;
    @JoinColumn(name = "company", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Companies company;
    @OneToMany(mappedBy = "group1", fetch = FetchType.EAGER)
    private Collection<Alarms> alarmsCollection;

    public AlarmGroups() {
    }

    public AlarmGroups(Integer id) {
        this.id = id;
    }

    public AlarmGroups(Integer id, String group) {
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

    @XmlTransient
    public Collection<Alarms> getAlarmsCollection() {
        return alarmsCollection;
    }

    public void setAlarmsCollection(Collection<Alarms> alarmsCollection) {
        this.alarmsCollection = alarmsCollection;
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
        if (!(object instanceof AlarmGroups)) {
            return false;
        }
        AlarmGroups other = (AlarmGroups) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
//        return "org.obi.services.entities.AlarmGroups[ id=" + id + " ]";
        return "" + this.group + " - (" + this.alarmsCollection.toString() + ") [ id=" + id + " ]";
    }
    
    
}
