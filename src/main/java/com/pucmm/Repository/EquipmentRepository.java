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

    Equipment findByEquipmentId(String equipmentId);

    Equipment findByEquipmentName(String equipmentName);

    @Query("select e from Equipment e where e.subFamily.subfamilykey = :subFamilyKey")
    List<Equipment> findBySubFamilyKey(@Param("subFamilyKey") String subfamilyKey);

    @Query("select e from Equipment e where e.subFamily.family.familykey = :familyKey")
    List<Equipment> findByFamilyKey(@Param("familyKey") String familyKey);
}
