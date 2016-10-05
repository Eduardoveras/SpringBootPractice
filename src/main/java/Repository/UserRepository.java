/**
 * Created by Djidjelly Siclait on 10/5/2016.
 */
package Repository;


import Entiy.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String>{

    public User findByUsername(String username);
}
