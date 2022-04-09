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

    @Autowired
    PasswordEncoder passwordEncoder;
    


    
    public void signUp(User user) throws UserAlreadyExistException {

        //Let's check if user already registered with us
        if(checkIfUserExist(user.getEmail())){
            throw new UserAlreadyExistException("User already exists for this email");
        }
        User userToRegister = new User();
        BeanUtils.copyProperties(user, userToRegister);
        encodePassword(userToRegister, user);
        userRepository.save(userToRegister);
    }


    public boolean checkIfUserExist(String email) {
        return userRepository.findByEmail(email) !=null ? true : false;
    }

    private void encodePassword( User userEntity, User user){
        userEntity.setPassword(passwordEncoder.encode(user.getPassword()));
    }
    
}
