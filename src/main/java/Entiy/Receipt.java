/**
 * Created by Djidjelly Siclait on 10/5/2016.
 */
package Entiy;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.sql.Date;
import java.util.UUID;

@Entity
@Table(name = "receipt")
public class Receipt {
    // Attributes
    @Id
    private String transactionId;
    private Date transactionDate;
    private float totalprice;
    @ManyToOne
    private User borrower;

    // Constructor
    public Receipt(){

    }

    public Receipt(Date transactionDate, float totalprice, User borrower){
        this.setTransactionId("PUCMM-" + UUID.randomUUID().toString().split("-")[0].toUpperCase());
        this.setTransactionDate(transactionDate);
        this.setTotalprice(totalprice);
        this.setBorrower(borrower);
    }

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

    public float getTotalprice() {
        return totalprice;
    }

    public void setTotalprice(float totalprice) {
        this.totalprice = totalprice;
    }

    public User getBorrower() {
        return borrower;
    }

    public void setBorrower(User borrower) {
        this.borrower = borrower;
    }
}
