/**
 * Created by Djidjelly Siclait on 10/5/2016.
 */
package Repository;

import Entiy.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, String>{

    public Client findByIdentificationNumber(String identificationNumber);
}
