package no.ntnu.xxs.authentication;


import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import no.ntnu.xxs.role.Role;
import no.ntnu.xxs.role.RoleRepository;
import no.ntnu.xxs.user.User;
import no.ntnu.xxs.user.UserAlreadyExistException;
import no.ntnu.xxs.user.UserRepository;

import java.util.Optional;

@Service
public class UserSignUpService {
    
    @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    UserRepository userRepository;
    @Autowired
    RoleRepository roleRepository;
    public void signUp(User user) throws UserAlreadyExistException {
        
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
        // TODO: check if user role already exists, if not only then create a new role
        Role userRole = new Role("ROLE_USER");
        roleRepository.save(userRole);
        /* TODO: is is necessary to create a new user object, or can we just use the one
            passed in from the parameter */
        User userToRegister = new User();
        BeanUtils.copyProperties(user, userToRegister);
        encodePassword(userToRegister);
        userToRegister.addRole(userRole);
        userRepository.save(userToRegister);    
    }
    
    
    
    /*  
    
    public boolean checkIfUserEmailExist(String email) {
        if(
        userRepository.findByEmail(email) != null
        ){
            return true;
        }
        return false;
    }
    
    public boolean checkIfUserUsernameExist(String username) {
        if(
        userRepository.findByUsername(username) != null
        ){
            return true;
        }
        return false;
    }
    
    */
    private void encodePassword (User user){
        user.setPassword(passwordEncoder.encode(user.getPassword()));
    }
    
    
}
