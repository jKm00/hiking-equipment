package no.ntnu.xxs.authentication;

import com.fasterxml.jackson.databind.util.JSONPObject;
import no.ntnu.xxs.security.*;
import no.ntnu.xxs.user.User;
import no.ntnu.xxs.user.UserAlreadyExistException;
import no.ntnu.xxs.user.UserSignUpRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
* A controller responsible for authentication
*/
@RestController
@RequestMapping("/api/auth")
public class AuthenticationController {
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private UserDetailsService userDetailsService;
    @Autowired
    private JwtUtil jwtUtil;   
    @Autowired
    private UserSignUpService userSignUpService;

    /**
     * HTTP POST request to /api/authenticate
     *
     * @param authenticationRequest The request JSON Object containing username and password
     * @return Http.OK with JWT token, or Http. UNAUTHORIZED
     */
    @PostMapping("/signin")
    // TODO: Remove this annotation before deployment. Only used while testing login from react.
    @CrossOrigin
    public ResponseEntity<?> authenticate(@RequestBody AuthenticationRequest authenticationRequest) {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                    authenticationRequest.getEmail(),
                    authenticationRequest.getPassword()));
        } catch (BadCredentialsException e) {
            return new ResponseEntity<>("Invalid email or password", HttpStatus.UNAUTHORIZED);
        }

        final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getEmail());

        final String jwt = jwtUtil.generateToken(userDetails);

        return ResponseEntity.ok(new AuthenticationResponse(jwt));
    }
    

    @PostMapping("/signup")
    // TODO: handle if user already is signed up
    // TODO: remove before production
    @CrossOrigin
    public ResponseEntity<?> registerUser( @RequestBody UserSignUpRequest signUpRequest) throws UserAlreadyExistException {
        // Create new user's account
        User user = new User(
        signUpRequest.getFirstName(),
        signUpRequest.getLastName(),
        signUpRequest.getEmail(),
        signUpRequest.getPassword(),
        signUpRequest.getCountry(),
        signUpRequest.getZipCode(),
        signUpRequest.getCity(),
        signUpRequest.getAddress());
        userSignUpService.signUp(user);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    //TODO: implement method
    @PostMapping("/signup/admin")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<?> registerAdmin(@RequestBody UserSignUpRequest signUpRequest) throws UserAlreadyExistException {
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
