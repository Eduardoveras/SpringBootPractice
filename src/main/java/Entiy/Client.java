/**
 * Created by Djidjelly Siclait on 10/5/2016.
 */
package Entiy;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "client")
public class Client implements Serializable{
    // Attributes
    @Id
    private String identificationNumber; // Cedula
    private String firstName;
    private String lastName;
    private String telephone;
    private String address;

    // Constructor
    public Client(){

    }

    public Client(String identificationNumber, String firstName, String lastName, String telephone, String address){
        this.setIdentificationNumber(identificationNumber);
        this.setFirstName(firstName);
        this.setLastName(lastName);
        this.setTelephone(telephone);
        this.setAddress(address);
    }

    // Getters and Setters
    public String getIdentificationNumber() {
        return identificationNumber;
    }

    public void setIdentificationNumber(String identificationNumber) {
        this.identificationNumber = identificationNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
