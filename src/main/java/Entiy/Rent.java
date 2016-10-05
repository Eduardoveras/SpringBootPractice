/**
 * Created by Djidjelly Siclait on 10/5/2016.
 */
package Entiy;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.io.Serializable;
import java.sql.Date;
import java.util.UUID;

@Entity
@Table(name = "rent")
public class Rent implements Serializable{
    // Attributes
    @Id
    private String rentId;
    private Date startDate;
    private Date promisedDate;
    private float priceRate; // Price per day
    @ManyToOne
    private User borrower;
    @ManyToOne
    private Equipment equipment;
    private boolean active;

    // Constructors
    public Rent(){

    }

    public Rent(Date promisedDate, float priceRate, User borrower, Equipment equipment){
        this.setRentId("PUCMM-T-" + UUID.randomUUID().toString().split("-")[0].toUpperCase());

        java.util.Date utilDate = new java.util.Date();
        this.setStartDate(new Date(utilDate.getTime()));

        this.setPromisedDate(promisedDate);
        this.setPriceRate(priceRate);
        this.setBorrower(borrower);
        this.setEquipment(equipment);
        this.setActive(true);
    }

    // Getters and Setters
    public String getRentId() {
        return rentId;
    }

    public void setRentId(String rentId) {
        this.rentId = rentId;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getPromisedDate() {
        return promisedDate;
    }

    public void setPromisedDate(Date promisedDate) {
        this.promisedDate = promisedDate;
    }

    public float getPriceRate() {
        return priceRate;
    }

    public void setPriceRate(float priceRate) {
        this.priceRate = priceRate;
    }

    public User getBorrower() {
        return borrower;
    }

    public void setBorrower(User borrower) {
        this.borrower = borrower;
    }

    public Equipment getEquipment() {
        return equipment;
    }

    public void setEquipment(Equipment equipment) {
        this.equipment = equipment;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
