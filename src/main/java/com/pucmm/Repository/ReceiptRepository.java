/**
 * Created by Djidjelly Siclait on 10/5/2016.
 */
package com.pucmm.Repository;

import com.pucmm.Entiy.Receipt;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.sql.Date;
import java.util.List;

public interface ReceiptRepository extends JpaRepository<Receipt, String>{

    public Receipt findByTransactionId(String transactionId);

    @Query("select r from receipt r where r.transactionDate = :transactionDate")
    public List<Receipt> findByTransactionDate(@Param("transactionDate") Date transactionDate);

    @Query("select r from receipt r where r.borrower.identifiactionNumber = :identificationNumber")
    public List<Receipt> findByBorrower(@Param("identificationNumber") String identificationNumber);

    @Query("select r from receipt r where r.equipment.equipmentId = :equipmentId")
    public List<Receipt> findByEquipent(@Param("equipmentId") String equipmentId);

    @Query("select r from receipt r where r.tansactionDate between :beginning and :ending")
    public List<Receipt> findBetween(@Param("beginning") Date startDate, @Param("ending") Date endDate);
}
