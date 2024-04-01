/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.obi.services.obi.web.jsf.std.entities.business;

import org.obi.services.obi.web.jsf.std.entities.analyses.AnalyseTypes;
import org.obi.services.obi.web.jsf.std.entities.analyses.AnalyseCategories;
import org.obi.services.obi.web.jsf.std.entities.analyses.AnalyseMethods;
import org.obi.services.obi.web.jsf.std.entities.analyses.AnalysePoints;
import org.obi.services.obi.web.jsf.std.entities.analyses.AnalyseAllowed;
import org.obi.services.obi.web.jsf.std.entities.alarms.AlarmRender;
import org.obi.services.obi.web.jsf.std.entities.alarms.AlarmGroups;
import org.obi.services.obi.web.jsf.std.entities.alarms.AlarmClasses;
import org.obi.services.obi.web.jsf.std.entities.alarms.Alarms;
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
import org.obi.services.obi.web.jsf.std.entities.maintenance.Equipements;
import org.obi.services.obi.web.jsf.std.entities.maintenance.EquipementsDataExternal;
import org.obi.services.obi.web.jsf.std.entities.maintenance.EquipementsExternalProviders;
import org.obi.services.obi.web.jsf.std.entities.locations.Locations;
import org.obi.services.obi.web.jsf.std.entities.machines.Machines;
import org.obi.services.obi.web.jsf.std.entities.measures.MeasLimits;
import org.obi.services.obi.web.jsf.std.entities.measures.MeasLimitsGroups;
import org.obi.services.obi.web.jsf.std.entities.persistence.PersStandard;
import org.obi.services.obi.web.jsf.std.entities.persistence.PersStandardLimits;
import org.obi.services.obi.web.jsf.std.entities.persistence.Persistence;
import org.obi.services.obi.web.jsf.std.entities.tags.Tags;
import org.obi.services.obi.web.jsf.std.entities.tags.TagsTables;
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
    @NamedQuery(name = "Companies.findAll", query = "SELECT c FROM Companies c"),
    @NamedQuery(name = "Companies.findById", query = "SELECT c FROM Companies c WHERE c.id = :id"),
    @NamedQuery(name = "Companies.findByDeleted", query = "SELECT c FROM Companies c WHERE c.deleted = :deleted"),
    @NamedQuery(name = "Companies.findByCreated", query = "SELECT c FROM Companies c WHERE c.created = :created"),
    @NamedQuery(name = "Companies.findByChanged", query = "SELECT c FROM Companies c WHERE c.changed = :changed"),
    @NamedQuery(name = "Companies.findByCompany", query = "SELECT c FROM Companies c WHERE c.company = :company"),
    @NamedQuery(name = "Companies.findByDesignation", query = "SELECT c FROM Companies c WHERE c.designation = :designation"),
    @NamedQuery(name = "Companies.findByBuilded", query = "SELECT c FROM Companies c WHERE c.builded = :builded"),
    @NamedQuery(name = "Companies.findByMain", query = "SELECT c FROM Companies c WHERE c.main = :main"),
    @NamedQuery(name = "Companies.findByActivated", query = "SELECT c FROM Companies c WHERE c.activated = :activated"),
    @NamedQuery(name = "Companies.findByLogoPath", query = "SELECT c FROM Companies c WHERE c.logoPath = :logoPath")})
public class Companies implements Serializable {

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
    private String company;
    @Size(max = 255)
    private String designation;
    private Integer builded;
    private Boolean main;
    private Boolean activated;
    @Size(max = 512)
    private String logoPath;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "company", fetch = FetchType.LAZY)
    private Collection<EquipementsExternalProviders> equipementsExternalProvidersCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "company", fetch = FetchType.LAZY)
    private Collection<TagsTables> tagsTablesCollection;
    @OneToMany(mappedBy = "comapny", fetch = FetchType.LAZY)
    private Collection<UserRolePermissions> userRolePermissionsCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "company", fetch = FetchType.LAZY)
    private Collection<AnalyseAllowed> analyseAllowedCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "company", fetch = FetchType.LAZY)
    private Collection<PersStandard> persStandardCollection;
    @OneToMany(mappedBy = "company", fetch = FetchType.LAZY)
    private Collection<AnalyseMethods> analyseMethodsCollection;
    @OneToMany(mappedBy = "company", fetch = FetchType.LAZY)
    private Collection<AnalyseTypes> analyseTypesCollection;
    @OneToMany(mappedBy = "company", fetch = FetchType.LAZY)
    private Collection<MeasLimits> measLimitsCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "company", fetch = FetchType.LAZY)
    private Collection<Equipements> equipementsCollection;
    @OneToMany(mappedBy = "comapny", fetch = FetchType.LAZY)
    private Collection<UserRoles> userRolesCollection;
    @JoinColumn(name = "business", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Businesses business;
    @JoinColumn(name = "location", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Locations location;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "company", fetch = FetchType.LAZY)
    private Collection<PersStandardLimits> persStandardLimitsCollection;
    @OneToMany(mappedBy = "company", fetch = FetchType.LAZY)
    private Collection<MeasLimitsGroups> measLimitsGroupsCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "company", fetch = FetchType.LAZY)
    private Collection<AlarmGroups> alarmGroupsCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "company", fetch = FetchType.LAZY)
    private Collection<EquipementsDataExternal> equipementsDataExternalCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "company", fetch = FetchType.LAZY)
    private Collection<Alarms> alarmsCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "company", fetch = FetchType.LAZY)
    private Collection<AnalysePoints> analysePointsCollection;
    @OneToMany(mappedBy = "company", fetch = FetchType.LAZY)
    private Collection<AnalyseCategories> analyseCategoriesCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "company", fetch = FetchType.LAZY)
    private Collection<Tags> tagsCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "company", fetch = FetchType.LAZY)
    private Collection<AlarmRender> alarmRenderCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "company", fetch = FetchType.LAZY)
    private Collection<Persistence> persistenceCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "company", fetch = FetchType.LAZY)
    private Collection<Machines> machinesCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "company", fetch = FetchType.LAZY)
    private Collection<AlarmClasses> alarmClassesCollection;

    public Companies() {
    }

    public Companies(Integer id) {
        this.id = id;
    }

    public Companies(Integer id, String company) {
        this.id = id;
        this.company = company;
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

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
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
    public Collection<EquipementsExternalProviders> getEquipementsExternalProvidersCollection() {
        return equipementsExternalProvidersCollection;
    }

    public void setEquipementsExternalProvidersCollection(Collection<EquipementsExternalProviders> equipementsExternalProvidersCollection) {
        this.equipementsExternalProvidersCollection = equipementsExternalProvidersCollection;
    }

    @XmlTransient
    public Collection<TagsTables> getTagsTablesCollection() {
        return tagsTablesCollection;
    }

    public void setTagsTablesCollection(Collection<TagsTables> tagsTablesCollection) {
        this.tagsTablesCollection = tagsTablesCollection;
    }

    @XmlTransient
    public Collection<UserRolePermissions> getUserRolePermissionsCollection() {
        return userRolePermissionsCollection;
    }

    public void setUserRolePermissionsCollection(Collection<UserRolePermissions> userRolePermissionsCollection) {
        this.userRolePermissionsCollection = userRolePermissionsCollection;
    }

    @XmlTransient
    public Collection<AnalyseAllowed> getAnalyseAllowedCollection() {
        return analyseAllowedCollection;
    }

    public void setAnalyseAllowedCollection(Collection<AnalyseAllowed> analyseAllowedCollection) {
        this.analyseAllowedCollection = analyseAllowedCollection;
    }

    @XmlTransient
    public Collection<PersStandard> getPersStandardCollection() {
        return persStandardCollection;
    }

    public void setPersStandardCollection(Collection<PersStandard> persStandardCollection) {
        this.persStandardCollection = persStandardCollection;
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
    public Collection<Equipements> getEquipementsCollection() {
        return equipementsCollection;
    }

    public void setEquipementsCollection(Collection<Equipements> equipementsCollection) {
        this.equipementsCollection = equipementsCollection;
    }

    @XmlTransient
    public Collection<UserRoles> getUserRolesCollection() {
        return userRolesCollection;
    }

    public void setUserRolesCollection(Collection<UserRoles> userRolesCollection) {
        this.userRolesCollection = userRolesCollection;
    }

    public Businesses getBusiness() {
        return business;
    }

    public void setBusiness(Businesses business) {
        this.business = business;
    }

    public Locations getLocation() {
        return location;
    }

    public void setLocation(Locations location) {
        this.location = location;
    }

    @XmlTransient
    public Collection<PersStandardLimits> getPersStandardLimitsCollection() {
        return persStandardLimitsCollection;
    }

    public void setPersStandardLimitsCollection(Collection<PersStandardLimits> persStandardLimitsCollection) {
        this.persStandardLimitsCollection = persStandardLimitsCollection;
    }

    @XmlTransient
    public Collection<MeasLimitsGroups> getMeasLimitsGroupsCollection() {
        return measLimitsGroupsCollection;
    }

    public void setMeasLimitsGroupsCollection(Collection<MeasLimitsGroups> measLimitsGroupsCollection) {
        this.measLimitsGroupsCollection = measLimitsGroupsCollection;
    }

    @XmlTransient
    public Collection<AlarmGroups> getAlarmGroupsCollection() {
        return alarmGroupsCollection;
    }

    public void setAlarmGroupsCollection(Collection<AlarmGroups> alarmGroupsCollection) {
        this.alarmGroupsCollection = alarmGroupsCollection;
    }

    @XmlTransient
    public Collection<EquipementsDataExternal> getEquipementsDataExternalCollection() {
        return equipementsDataExternalCollection;
    }

    public void setEquipementsDataExternalCollection(Collection<EquipementsDataExternal> equipementsDataExternalCollection) {
        this.equipementsDataExternalCollection = equipementsDataExternalCollection;
    }

    @XmlTransient
    public Collection<Alarms> getAlarmsCollection() {
        return alarmsCollection;
    }

    public void setAlarmsCollection(Collection<Alarms> alarmsCollection) {
        this.alarmsCollection = alarmsCollection;
    }

    @XmlTransient
    public Collection<AnalysePoints> getAnalysePointsCollection() {
        return analysePointsCollection;
    }

    public void setAnalysePointsCollection(Collection<AnalysePoints> analysePointsCollection) {
        this.analysePointsCollection = analysePointsCollection;
    }

    @XmlTransient
    public Collection<AnalyseCategories> getAnalyseCategoriesCollection() {
        return analyseCategoriesCollection;
    }

    public void setAnalyseCategoriesCollection(Collection<AnalyseCategories> analyseCategoriesCollection) {
        this.analyseCategoriesCollection = analyseCategoriesCollection;
    }

    @XmlTransient
    public Collection<Tags> getTagsCollection() {
        return tagsCollection;
    }

    public void setTagsCollection(Collection<Tags> tagsCollection) {
        this.tagsCollection = tagsCollection;
    }

    @XmlTransient
    public Collection<AlarmRender> getAlarmRenderCollection() {
        return alarmRenderCollection;
    }

    public void setAlarmRenderCollection(Collection<AlarmRender> alarmRenderCollection) {
        this.alarmRenderCollection = alarmRenderCollection;
    }

    @XmlTransient
    public Collection<Persistence> getPersistenceCollection() {
        return persistenceCollection;
    }

    public void setPersistenceCollection(Collection<Persistence> persistenceCollection) {
        this.persistenceCollection = persistenceCollection;
    }

    @XmlTransient
    public Collection<Machines> getMachinesCollection() {
        return machinesCollection;
    }

    public void setMachinesCollection(Collection<Machines> machinesCollection) {
        this.machinesCollection = machinesCollection;
    }

    @XmlTransient
    public Collection<AlarmClasses> getAlarmClassesCollection() {
        return alarmClassesCollection;
    }

    public void setAlarmClassesCollection(Collection<AlarmClasses> alarmClassesCollection) {
        this.alarmClassesCollection = alarmClassesCollection;
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
        if (!(object instanceof Companies)) {
            return false;
        }
        Companies other = (Companies) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
//        return "org.obi.services.entities.Companies[ id=" + id + " ]";
        return "" + this.company + " - " + this.designation + " (" + this.business + ") [ id=" + id + " ]";
    }
    
}
