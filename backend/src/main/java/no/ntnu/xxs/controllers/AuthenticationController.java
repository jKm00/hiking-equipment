package no.ntnu.xxs.controllers;

import no.ntnu.xxs.dto.AuthenticationRequest;
import no.ntnu.xxs.dto.AuthenticationResponse;
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
    @CrossOrigin
    public ResponseEntity<?> authenticate(@RequestBody AuthenticationRequest authenticationRequest) {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                    authenticationRequest.getEmail(),
                    authenticationRequest.getPassword()));
        } catch (BadCredentialsException e) {
            return new ResponseEntity<>("Invalid email or password", HttpStatus.UNAUTHORIZED);
        }

        final UserDetails userDetails = userService.loadUserByUsername(authenticationRequest.getEmail());
        final String jwt = jwtUtil.generateToken(userDetails);
        return ResponseEntity.ok(new AuthenticationResponse(jwt));
    }


    /**
     * Processes data received from the sign-up form
     *
     * @param signUpRequest the data send from the sign-up form
     * @return Name of the template for the result page
     */
    @PostMapping("/signup")
    @CrossOrigin
    public ResponseEntity<?> registerUser( @RequestBody UserSignUpRequest signUpRequest)  {
        String errorMsg = userService.tryCreateNewUser(signUpRequest);
        ResponseEntity<String> response;
        if (errorMsg == null) {
            response = new ResponseEntity<>(HttpStatus.OK);
        } else {
            response = new ResponseEntity<>(errorMsg, HttpStatus.BAD_REQUEST);
        }
        return response;
    }

    //TODO: implement method
    @PostMapping("/signup/admin")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<?> registerAdmin(@RequestBody UserSignUpRequest signUpRequest) throws UserAlreadyExistException {
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
