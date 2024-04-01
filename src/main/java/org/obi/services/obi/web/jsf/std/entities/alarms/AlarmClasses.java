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
@Table(name = "alarm_classes", catalog = "OBI", schema = "dbo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AlarmClasses.findAll", query = "SELECT a FROM AlarmClasses a"),
    @NamedQuery(name = "AlarmClasses.findById", query = "SELECT a FROM AlarmClasses a WHERE a.id = :id"),
    @NamedQuery(name = "AlarmClasses.findByDeleted", query = "SELECT a FROM AlarmClasses a WHERE a.deleted = :deleted"),
    @NamedQuery(name = "AlarmClasses.findByCreated", query = "SELECT a FROM AlarmClasses a WHERE a.created = :created"),
    @NamedQuery(name = "AlarmClasses.findByChanged", query = "SELECT a FROM AlarmClasses a WHERE a.changed = :changed"),
    @NamedQuery(name = "AlarmClasses.findByClass1", query = "SELECT a FROM AlarmClasses a WHERE a.class1 = :class1"),
    @NamedQuery(name = "AlarmClasses.findByName", query = "SELECT a FROM AlarmClasses a WHERE a.name = :name"),
    @NamedQuery(name = "AlarmClasses.findByComment", query = "SELECT a FROM AlarmClasses a WHERE a.comment = :comment")})
public class AlarmClasses implements Serializable {

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
    @Column(name = "class")
    private String class1;
    @Size(max = 255)
    private String name;
    @Size(max = 512)
    private String comment;
    @OneToMany(mappedBy = "class1", fetch = FetchType.LAZY)
    private Collection<Alarms> alarmsCollection;
    @JoinColumn(name = "render", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    private AlarmRender render;
    @JoinColumn(name = "company", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Companies company;

    public AlarmClasses() {
    }

    public AlarmClasses(Integer id) {
        this.id = id;
    }

    public AlarmClasses(Integer id, String class1) {
        this.id = id;
        this.class1 = class1;
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

    public String getClass1() {
        return class1;
    }

    public void setClass1(String class1) {
        this.class1 = class1;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @XmlTransient
    public Collection<Alarms> getAlarmsCollection() {
        return alarmsCollection;
    }

    public void setAlarmsCollection(Collection<Alarms> alarmsCollection) {
        this.alarmsCollection = alarmsCollection;
    }

    public AlarmRender getRender() {
        return render;
    }

    public void setRender(AlarmRender render) {
        this.render = render;
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
        if (!(object instanceof AlarmClasses)) {
            return false;
        }
        AlarmClasses other = (AlarmClasses) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
//        return "org.obi.services.entities.AlarmClasses[ id=" + id + " ]";
        return "" + this.class1 + " - " + this.name + " [ id=" + id + " ]";
    }   
}
