/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.obi.services.obi.web.jsf.std.entities.tags;

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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author r.hendrick
 */
@Entity
@Table(name = "tags_lists_types", catalog = "OBI", schema = "dbo", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"id"})})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TagsListsTypes.findAll", query = "SELECT t FROM TagsListsTypes t"),
    @NamedQuery(name = "TagsListsTypes.findById", query = "SELECT t FROM TagsListsTypes t WHERE t.id = :id"),
    @NamedQuery(name = "TagsListsTypes.findByDeleted", query = "SELECT t FROM TagsListsTypes t WHERE t.deleted = :deleted"),
    @NamedQuery(name = "TagsListsTypes.findByCreated", query = "SELECT t FROM TagsListsTypes t WHERE t.created = :created"),
    @NamedQuery(name = "TagsListsTypes.findByChanged", query = "SELECT t FROM TagsListsTypes t WHERE t.changed = :changed"),
    @NamedQuery(name = "TagsListsTypes.findByDesignation", query = "SELECT t FROM TagsListsTypes t WHERE t.designation = :designation"),
    @NamedQuery(name = "TagsListsTypes.findByComment", query = "SELECT t FROM TagsListsTypes t WHERE t.comment = :comment")})
public class TagsListsTypes implements Serializable {

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
    @Column(length = 255)
    private String designation;
    @Size(max = 512)
    @Column(length = 512)
    private String comment;
    @OneToMany(mappedBy = "type", fetch = FetchType.LAZY)
    private Collection<TagsLists> tagsListsCollection;

    public TagsListsTypes() {
    }

    public TagsListsTypes(Integer id) {
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

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @XmlTransient
    public Collection<TagsLists> getTagsListsCollection() {
        return tagsListsCollection;
    }

    public void setTagsListsCollection(Collection<TagsLists> tagsListsCollection) {
        this.tagsListsCollection = tagsListsCollection;
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
        if (!(object instanceof TagsListsTypes)) {
            return false;
        }
        TagsListsTypes other = (TagsListsTypes) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "" + this.designation + " [" + id + "]";
    }
    
}
