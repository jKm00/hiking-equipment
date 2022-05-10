package no.ntnu.xxs.services;

import no.ntnu.xxs.entities.user.Role;
import no.ntnu.xxs.entities.user.User;
import no.ntnu.xxs.exception.UserAlreadyExistException;
import no.ntnu.xxs.repositories.RoleRepository;
import no.ntnu.xxs.repositories.UserRepository;
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
    @Autowired
    RoleRepository roleRepository;
    @Autowired
    PasswordEncoder passwordEncoder;

    /**
     * Get all users from the application state
     * @return a list of users
     */
    public List<User> getAllUsers() {
        return (List<User>) this.userRepository.findAll();
    }

    public void createUser(User user) throws UserAlreadyExistException {

        //TODO: Create logic to check for duplicate email.
        /*
        //Let's check if user already registered with us
        if(checkIfUserEmailExist(user.getEmail())){
            throw new UserAlreadyExistException("User already exists for this email");
        }
        if(checkIfUserUsernameExist(user.getUsername())){
            throw new UserAlreadyExistException("Username is already taken");
        }
        */
        Role roleFound = roleRepository.findOneByName("ROLE_USER");
        if(roleFound==null)
        {
            roleFound = new Role("ROLE_USER");
            roleRepository.save(roleFound);
        }
        /* TODO: is is necessary to create a new user object, or can we just use the one
            passed in from the parameter */
        User userToRegister = new User();
        BeanUtils.copyProperties(user, userToRegister);
        encodePassword(userToRegister);
        userToRegister.addRole(roleFound);
        userRepository.save(userToRegister);
    }

    /**
     * Encodes the password of the user entered as parameter
     * @param user the user to encode the password for
     */
    private void encodePassword (User user){
        user.setPassword(passwordEncoder.encode(user.getPassword()));
    }
}
