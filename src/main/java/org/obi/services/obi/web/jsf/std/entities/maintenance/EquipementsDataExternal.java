/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.obi.services.obi.web.jsf.std.entities.maintenance;

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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author r.hendrick
 */
@Entity
@Table(name = "equipements_data_external", catalog = "OBI", schema = "dbo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EquipementsDataExternal.findAll", query = "SELECT e FROM EquipementsDataExternal e"),
    @NamedQuery(name = "EquipementsDataExternal.findById", query = "SELECT e FROM EquipementsDataExternal e WHERE e.id = :id"),
    @NamedQuery(name = "EquipementsDataExternal.findByDeleted", query = "SELECT e FROM EquipementsDataExternal e WHERE e.deleted = :deleted"),
    @NamedQuery(name = "EquipementsDataExternal.findByCreated", query = "SELECT e FROM EquipementsDataExternal e WHERE e.created = :created"),
    @NamedQuery(name = "EquipementsDataExternal.findByChanged", query = "SELECT e FROM EquipementsDataExternal e WHERE e.changed = :changed")})
public class EquipementsDataExternal implements Serializable {

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
    @JoinColumn(name = "company", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Companies company;
    @JoinColumn(name = "equipement", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Equipements equipement;
    @JoinColumn(name = "provider", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private EquipementsExternalProviders provider;

    public EquipementsDataExternal() {
    }

    public EquipementsDataExternal(Integer id) {
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

    public Companies getCompany() {
        return company;
    }

    public void setCompany(Companies company) {
        this.company = company;
    }

    public Equipements getEquipement() {
        return equipement;
    }

    public void setEquipement(Equipements equipement) {
        this.equipement = equipement;
    }

    public EquipementsExternalProviders getProvider() {
        return provider;
    }

    public void setProvider(EquipementsExternalProviders provider) {
        this.provider = provider;
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
        if (!(object instanceof EquipementsDataExternal)) {
            return false;
        }
        EquipementsDataExternal other = (EquipementsDataExternal) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
//        return "org.obi.services.entities.EquipementsDataExternal[ id=" + id + " ]";
        return "" + this.equipement + " - " + this.provider
                + " (> " + this.company + ") [ id=" + id + " ]";
    }
    
}
