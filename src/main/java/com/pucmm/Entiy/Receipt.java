/**
 * Created by Djidjelly Siclait on 10/5/2016.
 */
package com.pucmm.Entiy;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;
import java.util.UUID;

@Entity
@Table(name = "receipt")
public class Receipt implements Serializable{
    // Attributes
    @Id
    private String transactionId;
    private Date transactionDate;
    private float totalPrice;
    @ManyToOne
    private Client borrower;
    @ManyToOne
    private Equipment equipment;

    // Constructors
    public Receipt(){

    }

    public Receipt(Date transactionDate, float totalPrice, Client borrower, Equipment equipment){
        this.setTransactionId("PUCMM-R-" + UUID.randomUUID().toString().split("-")[0].toUpperCase());
        this.setTransactionDate(transactionDate);
        this.setTotalPrice(totalPrice);
        this.setBorrower(borrower);
        this.setEquipment(equipment);
    }

    // Getters and Setters
    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public Date getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(Date transactionDate) {
        this.transactionDate = transactionDate;
    }

    public float getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(float totalPrice) {
        this.totalPrice = totalPrice;
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
}
