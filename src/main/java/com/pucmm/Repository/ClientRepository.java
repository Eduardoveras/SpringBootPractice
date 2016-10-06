/**
 * Created by Djidjelly Siclait on 10/5/2016.
 */
package com.pucmm.Repository;

import com.pucmm.Entiy.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, String>{

    Client findByIdentificationNumber(String identificationNumber);
}
