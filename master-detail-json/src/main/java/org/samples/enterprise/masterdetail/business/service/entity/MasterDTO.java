/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.samples.enterprise.masterdetail.business.service.entity;

import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

/**
 *
 * @author mmontel
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class MasterDTO {
    private final String name;
    private final Detail detail;
    
    public MasterDTO(String name, Detail detail) {
        this.name = name;
        this.detail = detail;
    }

    public String getName() {
        return name;
    }

    public Detail getDetails() {
        return detail;
    }
    
    
}
