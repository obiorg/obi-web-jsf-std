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
@Table(name = "tags_types", catalog = "OBI", schema = "dbo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TagsTypes.findAll", query = "SELECT t FROM TagsTypes t"),
    @NamedQuery(name = "TagsTypes.findById", query = "SELECT t FROM TagsTypes t WHERE t.id = :id"),
    @NamedQuery(name = "TagsTypes.findByDeleted", query = "SELECT t FROM TagsTypes t WHERE t.deleted = :deleted"),
    @NamedQuery(name = "TagsTypes.findByCreated", query = "SELECT t FROM TagsTypes t WHERE t.created = :created"),
    @NamedQuery(name = "TagsTypes.findByChanged", query = "SELECT t FROM TagsTypes t WHERE t.changed = :changed"),
    @NamedQuery(name = "TagsTypes.findByType", query = "SELECT t FROM TagsTypes t WHERE t.type = :type"),
    @NamedQuery(name = "TagsTypes.findByDesignation", query = "SELECT t FROM TagsTypes t WHERE t.designation = :designation"),
    @NamedQuery(name = "TagsTypes.findByBit", query = "SELECT t FROM TagsTypes t WHERE t.bit = :bit"),
    @NamedQuery(name = "TagsTypes.findByByte1", query = "SELECT t FROM TagsTypes t WHERE t.byte1 = :byte1"),
    @NamedQuery(name = "TagsTypes.findByWord", query = "SELECT t FROM TagsTypes t WHERE t.word = :word"),
    @NamedQuery(name = "TagsTypes.findByGroup", query = "SELECT t FROM TagsTypes t WHERE t.group = :group")})
public class TagsTypes implements Serializable {

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
    private String type;
    @Size(max = 45)
    private String designation;
    private Integer bit;
    @Column(name = "byte")
    private Integer byte1;
    private Integer word;
    @Size(max = 45)
    @Column(name = "\"group\"")
    private String group;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "type", fetch = FetchType.LAZY)
    private Collection<Tags> tagsCollection;

    public TagsTypes() {
    }

    public TagsTypes(Integer id) {
        this.id = id;
    }

    public TagsTypes(Integer id, String type) {
        this.id = id;
        this.type = type;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public Integer getBit() {
        return bit;
    }

    public void setBit(Integer bit) {
        this.bit = bit;
    }

    public Integer getByte1() {
        return byte1;
    }

    public void setByte1(Integer byte1) {
        this.byte1 = byte1;
    }

    public Integer getWord() {
        return word;
    }

    public void setWord(Integer word) {
        this.word = word;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
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
        if (!(object instanceof TagsTypes)) {
            return false;
        }
        TagsTypes other = (TagsTypes) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
//        return "org.obi.services.entities.TagsTypes[ id=" + id + " ]";
        return "" + this.type + " - " + this.designation  
                + " - " + this.group + " (" + this.bit + "; " + this.byte1 + "; " + this.getWord() + ") "                
                + " [ id=" + id + " ]";

    }
    
}
