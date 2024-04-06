/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.obi.services.obi.web.jsf.std.entities.maintenance;

import org.obi.services.obi.web.jsf.std.entities.business.Companies;
import org.obi.services.obi.web.jsf.std.entities.analyses.AnalysePoints;
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

/**
 *
 * @author r.hendrick
 */
@Entity
@Table(catalog = "OBI", schema = "dbo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Equipements.findAll", query = "SELECT e FROM Equipements e"),
    @NamedQuery(name = "Equipements.findById", query = "SELECT e FROM Equipements e WHERE e.id = :id"),
    @NamedQuery(name = "Equipements.findByDeleted", query = "SELECT e FROM Equipements e WHERE e.deleted = :deleted"),
    @NamedQuery(name = "Equipements.findByCreated", query = "SELECT e FROM Equipements e WHERE e.created = :created"),
    @NamedQuery(name = "Equipements.findByChanged", query = "SELECT e FROM Equipements e WHERE e.changed = :changed"),
    @NamedQuery(name = "Equipements.findByEquipement", query = "SELECT e FROM Equipements e WHERE e.equipement = :equipement"),
    @NamedQuery(name = "Equipements.findByName", query = "SELECT e FROM Equipements e WHERE e.name = :name")})
public class Equipements implements Serializable {

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
    private String equipement;
    @Size(max = 255)
    private String name;
    @JoinColumn(name = "company", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Companies company;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "equipement", fetch = FetchType.EAGER)
    private Collection<EquipementsDataExternal> equipementsDataExternalCollection;
    @OneToMany(mappedBy = "equipement", fetch = FetchType.EAGER)
    private Collection<AnalysePoints> analysePointsCollection;

    public Equipements() {
    }

    public Equipements(Integer id) {
        this.id = id;
    }

    public Equipements(Integer id, String equipement) {
        this.id = id;
        this.equipement = equipement;
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

    public String getEquipement() {
        return equipement;
    }

    public void setEquipement(String equipement) {
        this.equipement = equipement;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Companies getCompany() {
        return company;
    }

    public void setCompany(Companies company) {
        this.company = company;
    }

    @XmlTransient
    public Collection<EquipementsDataExternal> getEquipementsDataExternalCollection() {
        return equipementsDataExternalCollection;
    }

    public void setEquipementsDataExternalCollection(Collection<EquipementsDataExternal> equipementsDataExternalCollection) {
        this.equipementsDataExternalCollection = equipementsDataExternalCollection;
    }

    @XmlTransient
    public Collection<AnalysePoints> getAnalysePointsCollection() {
        return analysePointsCollection;
    }

    public void setAnalysePointsCollection(Collection<AnalysePoints> analysePointsCollection) {
        this.analysePointsCollection = analysePointsCollection;
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
        if (!(object instanceof Equipements)) {
            return false;
        }
        Equipements other = (Equipements) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
//        return "org.obi.services.entities.Equipements[ id=" + id + " ]";
        return "" + this.equipement + " - " + this.name 
                + " (> " + this.company + ") [ id=" + id + " ]";
    }
    
}
