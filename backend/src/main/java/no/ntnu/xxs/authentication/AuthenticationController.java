package no.ntnu.xxs.authentication;

import no.ntnu.xxs.security.AuthenticationRequest;
import no.ntnu.xxs.security.AuthenticationResponse;
import no.ntnu.xxs.security.JwtUtil;
import no.ntnu.xxs.user.User;
import no.ntnu.xxs.user.UserAlreadyExistException;
import no.ntnu.xxs.user.UserRepository;
import no.ntnu.xxs.user.UserSignUpRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
* A controller responsible for authentication
*/
@RestController
public class AuthenticationController {
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private UserDetailsService userDetailsService;
    @Autowired
    private JwtUtil jwtUtil;   
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserSignUpService userSignUpService;

    /**
    * HTTP POST request to /api/authenticate
    *
    * @param authenticationRequest The request JSON Object containing username and password
    * @return Http.OK with JWT token, or Http. UNAUTHORIZED
    */
    @PostMapping("/api/authenticate")
    public ResponseEntity<?> authenticate(@RequestBody AuthenticationRequest authenticationRequest) {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
            authenticationRequest.getUsername(),
            authenticationRequest.getPassword()));
        } catch (BadCredentialsException e) {
            return new ResponseEntity<>("Invalid username or password", HttpStatus.UNAUTHORIZED);
        }
        final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getUsername());
        final String jwt = jwtUtil.generateToken(userDetails);
        return ResponseEntity.ok(new AuthenticationResponse(jwt));
    }
    

    @PostMapping("/api/signup")
    public ResponseEntity<?> registerUser( @RequestBody UserSignUpRequest signUpRequest) throws UserAlreadyExistException {
        // Create new user's account
        User user = new User(
        signUpRequest.getFirstName(),
        signUpRequest.getLastName(),
        signUpRequest.getUsername(),
        signUpRequest.getEmail(),
        signUpRequest.getPassword(),
        signUpRequest.getCountry(),
        signUpRequest.getZipCode(),
        signUpRequest.getCity(),
        signUpRequest.getAddress());
        userSignUpService.signUp(user);
        return ResponseEntity.ok(body("User registered successfully"));
    }


    private Object body(String string) {
        return string;
    }


}
