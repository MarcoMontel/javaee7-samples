package org.samples.enterprise.generictype.entity;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author mmontel
 */
@XmlRootElement
public class EmployeeKey {
    private String key;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
    
}
