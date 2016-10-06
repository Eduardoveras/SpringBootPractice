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

    Rent findByRentId(String rentId);

    @Query("select r from Rent r where r.startdate = :startDate")
    List<Rent> findByStartDate(@Param("startDate") Date startDate);
/*
    @Query("select r from Rent r where r.startdate between :beginning and :ending")
    List<Rent> findByStartDateBetween(@Param("beginning") Date startDate, @Param("ending") Date endDate);
*/
    @Query("select r from Rent r where r.promiseddate = :promisedDate")
    List<Rent> findByPromisedDate(@Param("promisedDate") Date promisedDate);
/*
    @Query("select r from Rent r where r.promiseddate between :beginning and :ending")
    List<Rent> findPromisedDateBetween(@Param("beginning") Date startDate, @Param("ending") Date endDate);
*/
    @Query("select r from Rent r where r.borrower.identifiactionnumber = :identificationNumber")
    List<Rent> findByBorrower(@Param("identificationNumber") String identificationNumber);

    @Query("select r from Rent r where r.equipment.equipmentId = :equipmentId")
    List<Rent> findByEquipent(@Param("equipmentId") String equipmentId);

    @Query("select r from Rent r where r.active = :active")
    List<Rent> findStillActive(@Param("active") boolean active);
}
