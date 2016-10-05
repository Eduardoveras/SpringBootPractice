/**
 * Created by Djidjelly Siclait on 10/5/2016.
 */
package com.pucmm.Repository;

import com.pucmm.Entiy.Rent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.sql.Date;
import java.util.List;

public interface RentRepository extends JpaRepository<Rent, String> {

    public Rent findByRentId(String rentId);

    @Query("select r from rent r where r.startDate = :startDate")
    public List<Rent> findByStartDate(@Param("startDate") Date startDate);

    @Query("select r from rent r where r.startDate between :startDate and :ending")
    public List<Rent> findByStartDateBetween(@Param("beginning") Date startDate, @Param("ending") Date endDate);

    @Query("select r from rent where r.promisedDate = :promisedDate")
    public List<Rent> findByPromisedDate(@Param("promisedDate") Date promisedDate);

    @Query("select r from rent r where r.promisedDate between :startDate and :ending")
    public List<Rent> findPromisedDateBetween(@Param("beginning") Date startDate, @Param("ending") Date endDate);

    @Query("select r from rent r where r.borrower.identifiactionNumber = :identificationNumber")
    public List<Rent> findByBorrower(@Param("identificationNumber") String identificationNumber);

    @Query("select r from rent r where r.equipment.equipmentId = :equipmentId")
    public List<Rent> findByEquipent(@Param("equipmentId") String equipmentId);

    @Query("select r from rent r where r.active = :active")
    public List<Rent> findStillActive(@Param("active") boolean active);
}
