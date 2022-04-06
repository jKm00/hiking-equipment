package no.ntnu.xxs.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Business logic related to users
 */
@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    /**
     * Get all users from the application state
     * @return a list of users
     */
    public List<User> getAllUsers() {
        return (List<User>) this.userRepository.findAll();
    }

    /**
     * Tries to log in a user with the username and password given
     *
     * @param username the username of the user
     * @param password the password of the user
     * @return {@code true} if user details are correct, {@code false} otherwise
     */
    public boolean tryLogin(String username, String password) {
        // TODO: Implement logic
        return true;
    }
}
