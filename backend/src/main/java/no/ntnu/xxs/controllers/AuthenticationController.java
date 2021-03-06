package no.ntnu.xxs.controllers;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.Contact;
import no.ntnu.xxs.dto.AuthenticationRequest;
import no.ntnu.xxs.dto.AuthenticationResponse;
import no.ntnu.xxs.exception.EmailAlreadyInUseException;
import no.ntnu.xxs.security.*;
import no.ntnu.xxs.entities.user.User;
import no.ntnu.xxs.exception.UserAlreadyExistException;
import no.ntnu.xxs.dto.UserSignUpRequest;
import no.ntnu.xxs.services.AccessUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

/**
* A controller responsible for authentication
*/
@RestController
@RequestMapping("/api")
public class AuthenticationController {
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private AccessUserService userService;
    @Autowired
    private JwtUtil jwtUtil;

    /**
     * HTTP POST request to /api/authenticate
     *
     * @param authenticationRequest The request JSON Object containing username and password
     * @return Http.OK with JWT token, or Http. UNAUTHORIZED
     */
    @PostMapping("/authenticate")
    // TODO: Remove this annotation before deployment. Only used while testing login from react.
    @ApiOperation(value = "Returns a http status from a authentication request",
            notes = "Provide an authentication request to receive a Json web token if authorized",
            response = Contact.class)
    @CrossOrigin
    public ResponseEntity<?> authenticate(@ApiParam(value = "request to be sent and authenticated")
                                            @RequestBody AuthenticationRequest authenticationRequest) {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                    authenticationRequest.getEmail(),
                    authenticationRequest.getPassword()));
        } catch (BadCredentialsException e) {
            return new ResponseEntity<>("Invalid email or password", HttpStatus.UNAUTHORIZED);
        }

        final UserDetails userDetails = userService.loadUserByUsername(authenticationRequest.getEmail());
        final String jwt = jwtUtil.generateToken((AccessUserDetails) userDetails);
        return ResponseEntity.ok(new AuthenticationResponse(jwt));
    }


    /**
     * Processes data received from the sign-up form
     *
     * @param signUpRequest the data send from the sign-up form
     * @return Name of the template for the result page
     */
    @PostMapping("/signup")
    @ApiOperation(value = "Returns a http response from a given signup request",
            notes = "Provide a signup request to signup",
            response = Contact.class)
    @CrossOrigin
    public ResponseEntity<?> registerUser(@ApiParam(name = "Signup request to be sent to create a new user")
                                            @RequestBody UserSignUpRequest signUpRequest)  {
        ResponseEntity<String> response = null;
        try{
            String errorMsg = userService.tryCreateNewUser(signUpRequest);
            if (errorMsg == null) {
                response = new ResponseEntity<>(HttpStatus.OK);

            }
        } catch (EmailAlreadyInUseException emailAlreadyInUseException) {
            response = new ResponseEntity<>(emailAlreadyInUseException.getMessage(), HttpStatus.BAD_REQUEST);
        } catch (IllegalArgumentException illegalArgumentException) {
            response = new ResponseEntity<>(illegalArgumentException.getMessage(), HttpStatus.BAD_REQUEST);
        }
        return response;
    }

    /**
     * Registers an admin user.
     * In order to create an admin user the, the user must be an admin.
     * @param signUpRequest the data send from the sign-up form
     * @return HTTP Status OK if the user was created, or BAD_REQUEST if the user already exists
     * @throws UserAlreadyExistException
     */        
    
    @PostMapping("/users/admin")
    @ApiOperation(value = "Registers an administrative user",
            notes = "Provide a signup request to signup admin user",
            response = Contact.class)
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @CrossOrigin
    public ResponseEntity<?> registerAdmin(@ApiParam(value = "Signup request to be sent to create an admin user")
                                            @RequestBody UserSignUpRequest signUpRequest) throws UserAlreadyExistException {

        ResponseEntity<String> response = null;

        try {
            String errorMsg = userService.tryCreateNewAdmin(signUpRequest);
            if (errorMsg == null) {
                response = new ResponseEntity<>(HttpStatus.OK);

            }
        } catch (EmailAlreadyInUseException emailAlreadyInUseException) {
            response = new ResponseEntity<>(emailAlreadyInUseException.getMessage(), HttpStatus.BAD_REQUEST);
        } catch (IllegalArgumentException illegalArgumentException) {
            response = new ResponseEntity<>(illegalArgumentException.getMessage(), HttpStatus.BAD_REQUEST);

        } 

        return new ResponseEntity<>(HttpStatus.OK);
    }
}