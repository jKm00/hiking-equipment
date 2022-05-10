package no.ntnu.xxs.services;

import no.ntnu.xxs.dto.UserSignUpRequest;
import no.ntnu.xxs.entities.user.Role;
import no.ntnu.xxs.entities.user.User;
import no.ntnu.xxs.exception.UserAlreadyExistException;
import no.ntnu.xxs.repositories.RoleRepository;
import no.ntnu.xxs.repositories.UserRepository;
import no.ntnu.xxs.security.AccessUserDetails;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Provides AccessUserDetails needed for authentication
 */
@Service
public class AccessUserService implements UserDetailsService {
    private static final int MIN_PASSWORD_LENGTH = 8;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<User> user = userRepository.findUserByEmail(email);
        if (user.isPresent()) {
            return new AccessUserDetails(user.get());
        } else {
            throw new UsernameNotFoundException("User " + email + " not found");
        }
    }

    /**
     * Get all users from the application state
     * @return a list of users
     */
    public List<User> getAllUsers() {
        return (List<User>) this.userRepository.findAll();
    }

    /**
     * Checks if a user with the given email already exists in the database
     *
     * @param email Email of the user to check
     * @return true if user exists, false otherwise
     */
    private boolean userExists(String email) {
        try {
            loadUserByUsername(email);
            return true;
        } catch (UsernameNotFoundException e) {
            return false;
        }
    }

    /**
     * Tries to create a new user
     *
     * @param userDetails request containing user details
     * @return null when user is created, error message on error
     */
    public String tryCreateNewUser(UserSignUpRequest userDetails) {
        String errorMsg;
        if ("".equals(userDetails.getEmail())) {
            errorMsg = "Email can't be empty";
        } else if (userExists(userDetails.getEmail())) {
            errorMsg = "Email is already taken";
        } else {
            errorMsg = checkPasswordRequirements(userDetails.getPassword());
            if (errorMsg == null) {
                createUser(userDetails);
            }
        }
        return errorMsg;
    }

    /**
     * Adds a new user to the database
     *
     * @param userDetails details of the user
     */
    private void createUser(UserSignUpRequest userDetails) {
        Role userRole = roleRepository.findOneByName("ROLE_USER");
        if (userRole != null) {
            User user = new User(
                    userDetails.getFirstName(),
                    userDetails.getLastName(),
                    userDetails.getEmail(),
                    createHash(userDetails.getPassword()),
                    userDetails.getCountry(),
                    userDetails.getZipCode(),
                    userDetails.getCity(),
                    userDetails.getAddress()
            );
            user.addRole(userRole);
            userRepository.save(user);
        }
    }

    /**
     * Hashes the password given
     * @param password the password to hash
     * @return the hashed password
     */
    private String createHash(String password) {
        return BCrypt.hashpw(password, BCrypt.gensalt());
    }

    /**
     * Checks if a password matches the requirements
     *
     * @param password A password to check
     * @return null if password is ok, an error message otherwise
     */
    private String checkPasswordRequirements(String password) {
        String errorMsg = null;
        if (password == null || password.length() == 0) {
            errorMsg = "Password can't be empty";
        } else if (password.length() < MIN_PASSWORD_LENGTH) {
            errorMsg = "Password must be at least " + MIN_PASSWORD_LENGTH + " characters";
        } else if (!password.matches(".*[0-9].*")) {
            errorMsg = "Password must contain at least one number";
        }
        return errorMsg;
    }
}