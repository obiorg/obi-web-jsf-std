/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.obi.services.obi.web.jsf.std.entities.machines;

import org.obi.services.obi.web.jsf.std.entities.business.Companies;
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
import org.obi.services.obi.web.jsf.std.entities.tags.Tags;

/**
 *
 * @author r.hendrick
 */
@Entity
@Table(catalog = "OBI", schema = "dbo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Machines.findAll", query = "SELECT m FROM Machines m"),
    @NamedQuery(name = "Machines.findById", query = "SELECT m FROM Machines m WHERE m.id = :id"),
    @NamedQuery(name = "Machines.findByDeleted", query = "SELECT m FROM Machines m WHERE m.deleted = :deleted"),
    @NamedQuery(name = "Machines.findByCreated", query = "SELECT m FROM Machines m WHERE m.created = :created"),
    @NamedQuery(name = "Machines.findByChanged", query = "SELECT m FROM Machines m WHERE m.changed = :changed"),
    @NamedQuery(name = "Machines.findByAddress", query = "SELECT m FROM Machines m WHERE m.address = :address"),
    @NamedQuery(name = "Machines.findByMask", query = "SELECT m FROM Machines m WHERE m.mask = :mask"),
    @NamedQuery(name = "Machines.findByDns", query = "SELECT m FROM Machines m WHERE m.dns = :dns"),
    @NamedQuery(name = "Machines.findByIpv6", query = "SELECT m FROM Machines m WHERE m.ipv6 = :ipv6"),
    @NamedQuery(name = "Machines.findByPort", query = "SELECT m FROM Machines m WHERE m.port = :port"),
    @NamedQuery(name = "Machines.findByName", query = "SELECT m FROM Machines m WHERE m.name = :name"),
    @NamedQuery(name = "Machines.findByRack", query = "SELECT m FROM Machines m WHERE m.rack = :rack"),
    @NamedQuery(name = "Machines.findBySlot", query = "SELECT m FROM Machines m WHERE m.slot = :slot"),
    @NamedQuery(name = "Machines.findByMqqt", query = "SELECT m FROM Machines m WHERE m.mqtt = :mqtt"),
    @NamedQuery(name = "Machines.findByMqqtUser", query = "SELECT m FROM Machines m WHERE m.mqttUser = :mqttUser"),
    @NamedQuery(name = "Machines.findByMqqtPassword", query = "SELECT m FROM Machines m WHERE m.mqttPassword = :mqttPassword"),
    @NamedQuery(name = "Machines.findByWebhook", query = "SELECT m FROM Machines m WHERE m.webhook = :webhook"),
    @NamedQuery(name = "Machines.findByWebhookSecret", query = "SELECT m FROM Machines m WHERE m.webhookSecret = :webhookSecret"),
    @NamedQuery(name = "Machines.findByBus", query = "SELECT m FROM Machines m WHERE m.bus = :bus"),
    @NamedQuery(name = "Machines.findByDescription", query = "SELECT m FROM Machines m WHERE m.description = :description")})
public class Machines implements Serializable {

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
    @Size(min = 1, max = 512)
    private String address;
    @Size(max = 15)
    private String mask;
    @Size(max = 45)
    private String dns;
    @Size(max = 45)
    private String ipv6;
    private Integer port;
    @Size(max = 45)
    private String name;
    private Integer rack;
    private Integer slot;
    private Boolean mqtt;
    @Size(max = 45)
    @Column(name = "mqtt_user")
    private String mqttUser;
    @Size(max = 512)
    @Column(name = "mqtt_password")
    private String mqttPassword;
    private Boolean webhook;
    @Size(max = 512)
    @Column(name = "webhook_secret")
    private String webhookSecret;
    private Integer bus;
    @Size(max = 512)
    private String description;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "machine", fetch = FetchType.EAGER)
    private Collection<Tags> tagsCollection;
    @JoinColumn(name = "company", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Companies company;
    @JoinColumn(name = "driver", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private MachDrivers driver;

    public Machines() {
    }

    public Machines(Integer id) {
        this.id = id;
    }

    public Machines(Integer id, String address) {
        this.id = id;
        this.address = address;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getMask() {
        return mask;
    }

    public void setMask(String mask) {
        this.mask = mask;
    }

    public String getDns() {
        return dns;
    }

    public void setDns(String dns) {
        this.dns = dns;
    }

    public String getIpv6() {
        return ipv6;
    }

    public void setIpv6(String ipv6) {
        this.ipv6 = ipv6;
    }

    public Integer getPort() {
        return port;
    }

    public void setPort(Integer port) {
        this.port = port;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getRack() {
        return rack;
    }

    public void setRack(Integer rack) {
        this.rack = rack;
    }

    public Integer getSlot() {
        return slot;
    }

    public void setSlot(Integer slot) {
        this.slot = slot;
    }

    public Boolean getMqtt() {
        return mqtt;
    }

    public void setMqtt(Boolean mqtt) {
        this.mqtt = mqtt;
    }

    public String getMqttUser() {
        return mqttUser;
    }

    public void setMqttUser(String mqttUser) {
        this.mqttUser = mqttUser;
    }

    public String getMqttPassword() {
        return mqttPassword;
    }

    public void setMqttPassword(String mqttPassword) {
        this.mqttPassword = mqttPassword;
    }

    public Boolean getWebhook() {
        return webhook;
    }

    public void setWebhook(Boolean webhook) {
        this.webhook = webhook;
    }

    public String getWebhookSecret() {
        return webhookSecret;
    }

    public void setWebhookSecret(String webhookSecret) {
        this.webhookSecret = webhookSecret;
    }

    public Integer getBus() {
        return bus;
    }

    public void setBus(Integer bus) {
        this.bus = bus;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @XmlTransient
    public Collection<Tags> getTagsCollection() {
        return tagsCollection;
    }

    public void setTagsCollection(Collection<Tags> tagsCollection) {
        this.tagsCollection = tagsCollection;
    }

    public Companies getCompany() {
        return company;
    }

    public void setCompany(Companies company) {
        this.company = company;
    }

    public MachDrivers getDriver() {
        return driver;
    }

    public void setDriver(MachDrivers driver) {
        this.driver = driver;
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
        if (!(object instanceof Machines)) {
            return false;
        }
        Machines other = (Machines) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "" + this.name + " - " + this.address
                + " [" + this.company.getCompany() + "] [id=" + id + "]";
    }

}
