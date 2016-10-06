/**
 * Created by Djidjelly Siclait on 10/5/2016.
 */
package com.pucmm.Repository;

import com.pucmm.Entiy.SubFamily;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SubFamilyRepository extends JpaRepository<SubFamily, String>{

    SubFamily findBySubFamilyKey(String subFamilyKey);

    SubFamily findBySubFamilyName(String subFamilyName);

    @Query("select s from SubFamily s where s.family.familyKey = :familyKey")
    List<SubFamily> findByFamilyKey(@Param("familyKey") String familyKey);
}
