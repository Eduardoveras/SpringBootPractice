/**
 * Created by Djidjelly Siclait on 10/5/2016.
 */
package Repository;

import Entiy.Family;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FamilyRepository extends JpaRepository<Family, String>{

    public Family findByFamilyKey(String familyKey);
}
