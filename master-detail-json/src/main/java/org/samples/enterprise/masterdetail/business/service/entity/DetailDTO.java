/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.samples.enterprise.masterdetail.business.service.entity;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

/**
 *
 * @author mmontel
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class DetailDTO {
    private final String name;

    public DetailDTO(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
    
}
