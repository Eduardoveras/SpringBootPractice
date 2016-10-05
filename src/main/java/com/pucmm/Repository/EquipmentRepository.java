/**
 * Created by Djidjelly Siclait on 10/5/2016.
 */
package com.pucmm.Repository;

import com.pucmm.Entiy.Equipment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EquipmentRepository extends JpaRepository<Equipment, String>{

    public Equipment findByEquipmentId(String equipmentId);

    public Equipment findByEquipmentName(String equipmentName);

    @Query("select e from equipment e where e.subFamily.subFamilyKey = :subFamilyKey")
    public List<Equipment> findBySubFamilyKey(@Param("subFamilyKey") String subfamilyKey);

    @Query("select e from equipment e where e.subFamily.family.familyKey = :familyKey")
    public List<Equipment> findByFamilyKey(@Param("familyKey") String familyKey);
}
