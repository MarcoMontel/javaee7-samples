/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.samples.enterprise.masterdetail.business.service.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

/**
 *
 * @author mmontel
 */
@XmlAccessorType(XmlAccessType.FIELD)
@Entity
@NamedQueries({
        @NamedQuery(name = "findAllMasters", query = "SELECT a FROM Master a"),
        @NamedQuery(name = "findAllMasterDTOs", 
                query = "SELECT new com.syncromed.poc.masterdetail.business.service.entity.MasterDTO(a.name, d) FROM Master a JOIN a.details d")
})
public class Master implements Serializable {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String description;
    @Temporal(TemporalType.DATE)
    private Date startDate;
    @Temporal(TemporalType.DATE)
    private Date stopDate;
    
    @OneToMany(cascade = CascadeType.PERSIST, mappedBy = "master")
    private final List<Detail> details = new ArrayList<>();
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getStopDate() {
        return stopDate;
    }

    public void setStopDate(Date stopDate) {
        this.stopDate = stopDate;
    }
    
    
    
    public void addDetail(Detail detail) {
        details.add(detail);
        detail.setMaster(this);
    }
    
    public List<Detail> getDetails() {
        return details;
    }
}
