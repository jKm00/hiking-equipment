package no.ntnu.xxs.user;

import no.ntnu.xxs.security.AuthenticationRequest;
import no.ntnu.xxs.security.AuthenticationResponse;
import no.ntnu.xxs.security.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 * A controller responsible for authentication
 */
@RestController
public class UserSignUpController {
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private UserDetailsService userDetailsService;
    @Autowired
    private JwtUtil jwtUtil;
}
    /**
     * HTTP POST request to /api/signup
     *
     * @param signUpRequest The request JSON Object containing username and password
     * @return Http.OK with JWT token, or Http. UNAUTHORIZED
     *
    @PostMapping("/api/signup")
    public ResponseEntity<?> signUp(@RequestBody UserSignUpRequest signUpRequest) {
        try {
            authenticationManager.authenticate( new UsernamePasswordAuthenticationToken(
                signUpRequest.getFirstName(),
                signUpRequest.getLastName(),
                signUpRequest.getUsername(),
                signUpRequest.getEmail(),
                signUpRequest.getPassword(),
                signUpRequest.getCountry(),
                signUpRequest.getZipCode(),
                signUpRequest.getCity(),
                signUpRequest.getAddress()));
        } catch (BadCredentialsException e) {
            return new ResponseEntity<>("User already registered", HttpStatus.UNPROCESSABLE_ENTITY);
        }
        final UserDetails userDetails = userDetailsService.loadUserByUsername(signUpRequest.getUsername());
        final String jwt = jwtUtil.generateToken(userDetails);
        return ResponseEntity.ok(new AuthenticationResponse(jwt));
    }
}
*/