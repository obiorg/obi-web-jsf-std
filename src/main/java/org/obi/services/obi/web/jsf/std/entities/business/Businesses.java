package org.obi.services.obi.web.jsf.std.entities.business;

import org.obi.services.obi.web.jsf.std.entities.analyses.AnalyseTypes;
import org.obi.services.obi.web.jsf.std.entities.analyses.AnalyseCategories;
import org.obi.services.obi.web.jsf.std.entities.analyses.AnalyseMethods;
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
import org.obi.services.obi.web.jsf.std.entities.locations.Locations;
import org.obi.services.obi.web.jsf.std.entities.measures.MeasLimits;
import org.obi.services.obi.web.jsf.std.entities.measures.MeasLimitsGroups;
import org.obi.services.obi.web.jsf.std.entities.users.UserRolePermissions;
import org.obi.services.obi.web.jsf.std.entities.users.UserRoles;

/**
 *
 * @author r.hendrick
 */
@Entity
@Table(catalog = "OBI", schema = "dbo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Businesses.findAll", query = "SELECT b FROM Businesses b"),
    @NamedQuery(name = "Businesses.findById", query = "SELECT b FROM Businesses b WHERE b.id = :id"),
    @NamedQuery(name = "Businesses.findByDeleted", query = "SELECT b FROM Businesses b WHERE b.deleted = :deleted"),
    @NamedQuery(name = "Businesses.findByCreated", query = "SELECT b FROM Businesses b WHERE b.created = :created"),
    @NamedQuery(name = "Businesses.findByChanged", query = "SELECT b FROM Businesses b WHERE b.changed = :changed"),
    @NamedQuery(name = "Businesses.findByBusiness", query = "SELECT b FROM Businesses b WHERE b.business = :business"),
    @NamedQuery(name = "Businesses.findByDesignation", query = "SELECT b FROM Businesses b WHERE b.designation = :designation"),
    @NamedQuery(name = "Businesses.findByBuilded", query = "SELECT b FROM Businesses b WHERE b.builded = :builded"),
    @NamedQuery(name = "Businesses.findByMain", query = "SELECT b FROM Businesses b WHERE b.main = :main"),
    @NamedQuery(name = "Businesses.findByActivated", query = "SELECT b FROM Businesses b WHERE b.activated = :activated"),
    @NamedQuery(name = "Businesses.findByLogoPath", query = "SELECT b FROM Businesses b WHERE b.logoPath = :logoPath")})
public class Businesses implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    private Integer id;
    private Boolean deleted = false;
    @Temporal(TemporalType.TIMESTAMP)
    private Date created;
    @Temporal(TemporalType.TIMESTAMP)
    private Date changed;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    private String business;
    @Size(max = 255)
    private String designation;
    private Integer builded;
    private Boolean main;
    private Boolean activated;
    @Size(max = 512)
    private String logoPath;
    @OneToMany(mappedBy = "business", fetch = FetchType.EAGER)
    private Collection<UserRolePermissions> userRolePermissionsCollection;
    @OneToMany(mappedBy = "business", fetch = FetchType.EAGER)
    private Collection<AnalyseMethods> analyseMethodsCollection;
    @OneToMany(mappedBy = "business", fetch = FetchType.EAGER)
    private Collection<AnalyseTypes> analyseTypesCollection;
    @OneToMany(mappedBy = "business", fetch = FetchType.EAGER)
    private Collection<MeasLimits> measLimitsCollection;
    @OneToMany(mappedBy = "business", fetch = FetchType.EAGER)
    private Collection<UserRoles> userRolesCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "business", fetch = FetchType.EAGER)
    private Collection<Companies> companiesCollection;
    @OneToMany(mappedBy = "business", fetch = FetchType.EAGER)
    private Collection<MeasLimitsGroups> measLimitsGroupsCollection;
    @JoinColumn(name = "entity", referencedColumnName = "entity")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Entities entity;
    @JoinColumn(name = "location", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.EAGER)
    private Locations location;
    @OneToMany(mappedBy = "business", fetch = FetchType.EAGER)
    private Collection<AnalyseCategories> analyseCategoriesCollection;

    public Businesses() {
    }

    public Businesses(Integer id) {
        this.id = id;
    }

    public Businesses(Integer id, String business) {
        this.id = id;
        this.business = business;
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

    public String getBusiness() {
        return business;
    }

    public void setBusiness(String business) {
        this.business = business;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public Integer getBuilded() {
        return builded;
    }

    public void setBuilded(Integer builded) {
        this.builded = builded;
    }

    public Boolean getMain() {
        return main;
    }

    public void setMain(Boolean main) {
        this.main = main;
    }

    public Boolean getActivated() {
        return activated;
    }

    public void setActivated(Boolean activated) {
        this.activated = activated;
    }

    public String getLogoPath() {
        return logoPath;
    }

    public void setLogoPath(String logoPath) {
        this.logoPath = logoPath;
    }

    @XmlTransient
    public Collection<UserRolePermissions> getUserRolePermissionsCollection() {
        return userRolePermissionsCollection;
    }

    public void setUserRolePermissionsCollection(Collection<UserRolePermissions> userRolePermissionsCollection) {
        this.userRolePermissionsCollection = userRolePermissionsCollection;
    }

    @XmlTransient
    public Collection<AnalyseMethods> getAnalyseMethodsCollection() {
        return analyseMethodsCollection;
    }

    public void setAnalyseMethodsCollection(Collection<AnalyseMethods> analyseMethodsCollection) {
        this.analyseMethodsCollection = analyseMethodsCollection;
    }

    @XmlTransient
    public Collection<AnalyseTypes> getAnalyseTypesCollection() {
        return analyseTypesCollection;
    }

    public void setAnalyseTypesCollection(Collection<AnalyseTypes> analyseTypesCollection) {
        this.analyseTypesCollection = analyseTypesCollection;
    }

    @XmlTransient
    public Collection<MeasLimits> getMeasLimitsCollection() {
        return measLimitsCollection;
    }

    public void setMeasLimitsCollection(Collection<MeasLimits> measLimitsCollection) {
        this.measLimitsCollection = measLimitsCollection;
    }

    @XmlTransient
    public Collection<UserRoles> getUserRolesCollection() {
        return userRolesCollection;
    }

    public void setUserRolesCollection(Collection<UserRoles> userRolesCollection) {
        this.userRolesCollection = userRolesCollection;
    }

    @XmlTransient
    public Collection<Companies> getCompaniesCollection() {
        return companiesCollection;
    }

    public void setCompaniesCollection(Collection<Companies> companiesCollection) {
        this.companiesCollection = companiesCollection;
    }

    @XmlTransient
    public Collection<MeasLimitsGroups> getMeasLimitsGroupsCollection() {
        return measLimitsGroupsCollection;
    }

    public void setMeasLimitsGroupsCollection(Collection<MeasLimitsGroups> measLimitsGroupsCollection) {
        this.measLimitsGroupsCollection = measLimitsGroupsCollection;
    }

    public Entities getEntity() {
        return entity;
    }

    public void setEntity(Entities entity) {
        this.entity = entity;
    }

    public Locations getLocation() {
        return location;
    }

    public void setLocation(Locations location) {
        this.location = location;
    }

    @XmlTransient
    public Collection<AnalyseCategories> getAnalyseCategoriesCollection() {
        return analyseCategoriesCollection;
    }

    public void setAnalyseCategoriesCollection(Collection<AnalyseCategories> analyseCategoriesCollection) {
        this.analyseCategoriesCollection = analyseCategoriesCollection;
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
        if (!(object instanceof Businesses)) {
            return false;
        }
        Businesses other = (Businesses) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
//        return "org.obi.services.entities.Businesses[ id=" + id + " ]";
        return "" + this.business + " - " + this.designation + " (" + this.entity.toString() +  ") [ id=" + id + " ]";
    }
  
    
}
