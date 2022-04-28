package no.ntnu.xxs.authentication;

import java.util.HashMap;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import no.ntnu.xxs.user.User;
import no.ntnu.xxs.user.UserAlreadyExistException;
import no.ntnu.xxs.user.UserRepository;
@Service
public class UserSignUpService {
     
    @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    UserRepository userRepository;
    public void signUp(User user) throws UserAlreadyExistException {

        /*
        //Let's check if user already registered with us
        if(checkIfUserExist(user.getEmail())){
            throw new UserAlreadyExistException("User already exists for this email");
        }
        */
        User userToRegister = new User();
        BeanUtils.copyProperties(user, userToRegister);
        encodePassword(userToRegister);
        userRepository.save(userToRegister);    

    }

    
/*
    public boolean checkIfUserExist(String email) {
        if(
                userRepository.findByEmail(email) != null
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
