package no.ntnu.xxs.authentication;

import no.ntnu.xxs.security.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
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
}
