/**
 * Created by Djidjelly Siclait on 10/5/2016.
 */
package com.pucmm.Entiy;

import javax.persistence.*;
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
    private Client borrower;
    @ManyToOne
    private Equipment equipment;
    private boolean active;
    @Transient
    private int daysOut;

    // Constructors
    public Rent(){

    }

    /*
    public Rent( Date startDate, Date promisedDate, float priceRate, Client borrower, Equipment equipment){
        this.setRentId("PUCMM-T-" + UUID.randomUUID().toString().split("-")[0].toUpperCase());


        this.setStartDate(startDate);

        this.setPromisedDate(promisedDate);
        this.setPriceRate(priceRate);
        this.setBorrower(borrower);
        this.setEquipment(equipment);
        this.setActive(true);
    }
    */

    public Rent(Date promisedDate, float priceRate, Client borrower, Equipment equipment){
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

    public Client getBorrower() {
        return borrower;
    }

    public void setBorrower(Client borrower) {
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

    public int getDaysOut() {
        return (int)((new Date(new java.util.Date().getTime()).getTime() - startDate.getTime()) / (24 * 60 * 60 * 1000));
    }

    public void setDaysOut(int daysOut) {
        this.daysOut = daysOut;
    }
}
