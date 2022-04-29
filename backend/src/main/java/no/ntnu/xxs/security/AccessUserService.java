package no.ntnu.xxs.security;

import no.ntnu.xxs.user.User;
import no.ntnu.xxs.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Provides AccessUserDetails needed for authentication
 */
@Service
public class AccessUserService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public AccessUserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<User> user = userRepository.findUserByEmail(email);
        if (user.isPresent()) {
            return new AccessUserDetails(user.get());
        } else {
            throw new UsernameNotFoundException("User " + email + " not found");
        }
    }
}
