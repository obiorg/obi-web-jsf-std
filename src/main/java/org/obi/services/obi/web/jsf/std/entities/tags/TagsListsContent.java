/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.obi.services.obi.web.jsf.std.entities.tags;

import java.io.Serializable;
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
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import org.obi.services.obi.web.jsf.std.entities.business.Companies;

/**
 *
 * @author r.hendrick
 */
@Entity
@Table(name = "tags_lists_content", catalog = "OBI", schema = "dbo", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"company", "list", "content"}),
    @UniqueConstraint(columnNames = {"id"})})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TagsListsContent.findAll", query = "SELECT t FROM TagsListsContent t"),
    @NamedQuery(name = "TagsListsContent.findById", query = "SELECT t FROM TagsListsContent t WHERE t.id = :id"),
    @NamedQuery(name = "TagsListsContent.findByDeleted", query = "SELECT t FROM TagsListsContent t WHERE t.deleted = :deleted"),
    @NamedQuery(name = "TagsListsContent.findByCreated", query = "SELECT t FROM TagsListsContent t WHERE t.created = :created"),
    @NamedQuery(name = "TagsListsContent.findByChanged", query = "SELECT t FROM TagsListsContent t WHERE t.changed = :changed"),
    @NamedQuery(name = "TagsListsContent.findByContent", query = "SELECT t FROM TagsListsContent t WHERE t.content = :content"),
    @NamedQuery(name = "TagsListsContent.findByValue", query = "SELECT t FROM TagsListsContent t WHERE t.value = :value"),
    @NamedQuery(name = "TagsListsContent.findByDefault1", query = "SELECT t FROM TagsListsContent t WHERE t.default1 = :default1"),
    @NamedQuery(name = "TagsListsContent.findByWidth", query = "SELECT t FROM TagsListsContent t WHERE t.width = :width"),
    @NamedQuery(name = "TagsListsContent.findByHeight", query = "SELECT t FROM TagsListsContent t WHERE t.height = :height"),
    @NamedQuery(name = "TagsListsContent.findByComment", query = "SELECT t FROM TagsListsContent t WHERE t.comment = :comment"),

    @NamedQuery(name = "TagsListsContent.findByListAndContent", query = "SELECT t FROM TagsListsContent t WHERE t.list = :list AND t.content = :content")

})
public class TagsListsContent implements Serializable {

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
    @Column(nullable = false)
    private int content;
    @Size(max = 255)
    @Column(length = 255)
    private String value;
    @Column(name = "\"default\"")
    private Boolean default1;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(precision = 53)
    private Double width;
    @Column(precision = 53)
    private Double height;
    @Size(max = 512)
    @Column(length = 512)
    private String comment;
    @JoinColumn(name = "company", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Companies company;
    @JoinColumn(name = "list", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private TagsLists list;

    public TagsListsContent() {
    }

    public TagsListsContent(Integer id) {
        this.id = id;
    }

    public TagsListsContent(Integer id, int content) {
        this.id = id;
        this.content = content;
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

    public int getContent() {
        return content;
    }

    public void setContent(int content) {
        this.content = content;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Boolean getDefault1() {
        return default1; 
    }

    public void setDefault1(Boolean default1) {
        this.default1 = default1;
    }

    public Double getWidth() {
        return width;
    }

    public void setWidth(Double width) {
        this.width = width;
    }

    public Double getHeight() {
        return height;
    }

    public void setHeight(Double height) {
        this.height = height;
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

    public TagsLists getList() {
        return list;
    }

    public void setList(TagsLists list) {
        this.list = list;
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
        if (!(object instanceof TagsListsContent)) {
            return false;
        }
        TagsListsContent other = (TagsListsContent) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.obi.services.obi.web.jsf.std.entities.tmps.TagsListsContent[ id=" + id + " ]";
    }
    
}
