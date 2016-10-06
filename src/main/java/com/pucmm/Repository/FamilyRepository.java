/**
 * Created by Djidjelly Siclait on 10/5/2016.
 */
package com.pucmm.Repository;

import com.pucmm.Entiy.Family;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FamilyRepository extends JpaRepository<Family, String>{

    Family findByFamilyKey(String familyKey);

    Family findByFamilyName(String familyName);
}
