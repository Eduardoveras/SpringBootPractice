/**
 * Created by Djidjelly Siclait on 10/5/2016.
 */
package com.pucmm.Repository;

import com.pucmm.Entiy.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String>{

    User findByUsername(String username);
}
