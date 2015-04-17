/*
 * Copyright (C) 2015 mmontel
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA  02111-1307, USA.
 */
package org.samples.enterprise.jointable.business.example.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;

/**
 *
 * @author mmontel
 */
@Entity
@SequenceGenerator(name = "examIdSequence", sequenceName = "EXAM_SEQ", allocationSize = 1, initialValue = 1)
public class Exam implements Serializable {
    @Id
    @GeneratedValue(generator = "examIdSequence")
    private Long id;

    private String description;
    
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date visitDate;
    
    @ManyToMany
    @JoinTable(
            name = "EXAM_REPORT",
            joinColumns = {@JoinColumn(name = "EXAM_ID", referencedColumnName = "ID")},
            inverseJoinColumns = {@JoinColumn(name = "REPORT_ID", referencedColumnName = "ID")}
    )
    private List<Report> reports;
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getVisitDate() {
        return visitDate;
    }

    public void setVisitDate(Date visitDate) {
        this.visitDate = visitDate;
    }

    public List<Report> getReports() {
        if(reports == null) {
            reports = new ArrayList<>();
        }        
        return reports;
    }
    
    public void addReport(Report report) {
        if(reports == null) {
            reports = new ArrayList<>();
        }
        reports.add(report);
    }

    @Override
    public String toString() {
        return "Exam{" + "id=" + id + ", description=" + description + ", visitDate=" + visitDate + ", reports=" + reports + '}';
    }
    
    
    
}
