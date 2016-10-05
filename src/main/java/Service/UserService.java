/**
 * Created by Djidjelly Siclait on 10/5/2016.
 */
package Service;

import Entiy.User;
import Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    // Core Functions
    public void createNewUserAccount(String username, String firstName, String lastName, String password){
        if(isUsernameTaken(username))
            throw new IllegalArgumentException("The user name: " + username + " is already taken");
        else
            userRepository.save(new User(username, firstName, lastName, password, false));
    }

    public void deleteUserAccount(String username){
        userRepository.delete(userRepository.findByUsername(username));
    }

    public void makeUserAdmin(String username){
        User user = userRepository.findByUsername(username);
        if(!user.isAdmin()){
            user.setAdmin(true);
            userRepository.save(user);
        }
    }

    // Auxiliary Functions
    private boolean isUsernameTaken(String username){
        User user = userRepository.findByUsername(username);

        return (user != null);
    }
}
