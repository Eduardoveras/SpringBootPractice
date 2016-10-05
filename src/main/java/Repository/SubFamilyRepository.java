/**
 * Created by Djidjelly Siclait on 10/5/2016.
 */
package Repository;

import Entiy.SubFamily;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SubFamilyRepository extends JpaRepository<SubFamily, String>{

    public SubFamily findBySubFamilyKey(String subFamilyKey);

    public  SubFamily findBySubFamilyName(String subFamilyName);

    @Query("select s from subfamily s where s.family.familyKey = :familyKey")
    public List<SubFamily> findByFamilyKey(@Param("familyKey") String familyKey);
}
