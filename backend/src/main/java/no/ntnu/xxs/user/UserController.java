package no.ntnu.xxs.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * REST API controller for user collection
 */
@RestController
@RequestMapping("/api/users")
@CrossOrigin
public class UserController {
    @Autowired
    private UserService userService;

    /**
     * Get all users from database
     * @return a list of all users in the database
     */
    @GetMapping
    //@PreAuthorize("hasRole('ADMIN')")
    public List<User> getAllUsers() {
        return this.userService.getAllUsers();
    }
}
