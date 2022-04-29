package no.ntnu.xxs.user;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
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

}
