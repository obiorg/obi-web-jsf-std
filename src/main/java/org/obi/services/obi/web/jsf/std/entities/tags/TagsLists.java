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
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
import org.obi.services.obi.web.jsf.std.entities.business.Companies;

/**
 *
 * @author r.hendrick
 */
@Entity
@Table(name = "tags_lists", catalog = "OBI", schema = "dbo", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"company", "list"}),
    @UniqueConstraint(columnNames = {"id"})})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TagsLists.findAll", query = "SELECT t FROM TagsLists t"),
    @NamedQuery(name = "TagsLists.findById", query = "SELECT t FROM TagsLists t WHERE t.id = :id"),
    @NamedQuery(name = "TagsLists.findByDeleted", query = "SELECT t FROM TagsLists t WHERE t.deleted = :deleted"),
    @NamedQuery(name = "TagsLists.findByCreated", query = "SELECT t FROM TagsLists t WHERE t.created = :created"),
    @NamedQuery(name = "TagsLists.findByChanged", query = "SELECT t FROM TagsLists t WHERE t.changed = :changed"),
    @NamedQuery(name = "TagsLists.findByList", query = "SELECT t FROM TagsLists t WHERE t.list = :list"),
    @NamedQuery(name = "TagsLists.findByDesignation", query = "SELECT t FROM TagsLists t WHERE t.designation = :designation"),
    @NamedQuery(name = "TagsLists.findByComment", query = "SELECT t FROM TagsLists t WHERE t.comment = :comment")})
public class TagsLists implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(nullable = false)
    private Integer id;
    private Boolean deleted;
    @Temporal(TemporalType.TIMESTAMP)
    private Date created;
    @Temporal(TemporalType.TIMESTAMP)
    private Date changed;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(nullable = false, length = 45)
    private String list;
    @Size(max = 255)
    @Column(length = 255)
    private String designation;
    @Size(max = 512)
    @Column(length = 512)
    private String comment;
    @JoinColumn(name = "company", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Companies company;
    @JoinColumn(name = "type", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    private TagsListsTypes type;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "list", fetch = FetchType.LAZY)
    private Collection<TagsListsContent> tagsListsContentCollection;
    @OneToMany(mappedBy = "list", fetch = FetchType.LAZY)
    private Collection<Tags> tagsCollection;

    public TagsLists() {
    }

    public TagsLists(Integer id) {
        this.id = id;
    }

    public TagsLists(Integer id, String list) {
        this.id = id;
        this.list = list;
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

    public String getList() {
        return list;
    }

    public void setList(String list) {
        this.list = list;
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

    public Companies getCompany() {
        return company;
    }

    public void setCompany(Companies company) {
        this.company = company;
    }

    public TagsListsTypes getType() {
        return type;
    }

    public void setType(TagsListsTypes type) {
        this.type = type;
    }

    @XmlTransient
    public Collection<TagsListsContent> getTagsListsContentCollection() {
        return tagsListsContentCollection;
    }

    public void setTagsListsContentCollection(Collection<TagsListsContent> tagsListsContentCollection) {
        this.tagsListsContentCollection = tagsListsContentCollection;
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
        if (!(object instanceof TagsLists)) {
            return false;
        }
        TagsLists other = (TagsLists) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "" + this.list + " - " + this.designation + " [" + id + "]";
    }
    
}
