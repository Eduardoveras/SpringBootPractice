/**
 * Created by Djidjelly Siclait on 10/5/2016.
 */
package com.pucmm.Entiy;

import javax.persistence.*;
import java.io.Serializable;
import java.util.UUID;

@Entity
@Table(name = "subfamily")
public class SubFamily implements Serializable{
    //Attributes
    @Id
    private String subFamilyKey;
    private String subFamilyName;
    @ManyToOne
    private Family family;

    // Constructors
    public SubFamily(){

    }

    public SubFamily(String subFamilyName, Family family){
        this.setSubFamilyKey("PUCMM-SFA-" + UUID.randomUUID().toString().split("-")[0].toUpperCase());
        this.setSubFamilyName(subFamilyName);
        this.setFamily(family);
    }

    // Getters and Setters
    public String getSubFamilyKey() {
        return subFamilyKey;
    }

    public void setSubFamilyKey(String subFamilyKey) {
        this.subFamilyKey = subFamilyKey;
    }

    public String getSubFamilyName() {
        return subFamilyName;
    }

    public void setSubFamilyName(String subFamilyName) {
        this.subFamilyName = subFamilyName;
    }

    public Family getFamily() {
        return family;
    }

    public void setFamily(Family family) {
        this.family = family;
    }
}
