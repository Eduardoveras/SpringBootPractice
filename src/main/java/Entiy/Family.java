/**
 * Created by Djidjelly Siclait on 10/5/2016.
 */
package Entiy;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.UUID;

@Entity
@Table(name = "family")
public class Family implements Serializable{
    // Attributes
    @Id
    private String familyKey;
    @Column(unique = true)
    private String familyName;

    // Constructors
    public Family(){

    }

    public Family(String familyName){
        this.setFamilyKey("PUCMM-FA-" + UUID.randomUUID().toString().split("-")[0].toUpperCase());
        this.setFamilyName(familyName);
    }

    // Getters and Setters
    public String getFamilyKey() {
        return familyKey;
    }

    public void setFamilyKey(String familyKey) {
        this.familyKey = familyKey;
    }

    public String getFamilyName() {
        return familyName;
    }

    public void setFamilyName(String familyName) {
        this.familyName = familyName;
    }
}
