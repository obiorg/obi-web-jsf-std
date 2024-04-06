/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.obi.services.obi.web.jsf.std.entities.tags;

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

/**
 *
 * @author r.hendrick
 */
@Entity
@Table(name = "tags_memories", catalog = "OBI", schema = "dbo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TagsMemories.findAll", query = "SELECT t FROM TagsMemories t"),
    @NamedQuery(name = "TagsMemories.findById", query = "SELECT t FROM TagsMemories t WHERE t.id = :id"),
    @NamedQuery(name = "TagsMemories.findByDeleted", query = "SELECT t FROM TagsMemories t WHERE t.deleted = :deleted"),
    @NamedQuery(name = "TagsMemories.findByCreated", query = "SELECT t FROM TagsMemories t WHERE t.created = :created"),
    @NamedQuery(name = "TagsMemories.findByChanged", query = "SELECT t FROM TagsMemories t WHERE t.changed = :changed"),
    @NamedQuery(name = "TagsMemories.findByName", query = "SELECT t FROM TagsMemories t WHERE t.name = :name"),
    @NamedQuery(name = "TagsMemories.findByComment", query = "SELECT t FROM TagsMemories t WHERE t.comment = :comment")})
public class TagsMemories implements Serializable {

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
    private String name;
    @Size(max = 255)
    private String comment;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "memory", fetch = FetchType.EAGER)
    private Collection<Tags> tagsCollection;

    public TagsMemories() {
    }

    public TagsMemories(Integer id) {
        this.id = id;
    }

    public TagsMemories(Integer id, String name) {
        this.id = id;
        this.name = name;
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

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @XmlTransient
    public Collection<Tags> getTagsCollection() {
        return tagsCollection;
    }

    public void setTagsCollection(Collection<Tags> tagsCollection) {
        this.tagsCollection = tagsCollection;
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
        if (!(object instanceof TagsMemories)) {
            return false;
        }
        TagsMemories other = (TagsMemories) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
//        return "org.obi.services.entities.TagsMemories[ id=" + id + " ]";
        return "" + this.name + " - " + this.comment + " [ id=" + id + " ]";
    }
    
}
