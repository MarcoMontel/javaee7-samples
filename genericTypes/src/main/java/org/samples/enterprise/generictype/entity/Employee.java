package org.samples.enterprise.generictype.entity;

import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author mmontel
 */
@XmlRootElement
public class Employee {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
