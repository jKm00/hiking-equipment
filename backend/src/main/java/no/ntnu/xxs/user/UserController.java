package no.ntnu.xxs.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * REST API controller for user collection
 */
@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    private UserService userService;

    /**
     * Get all users from database
     * @return a list of all users in the database
     */
    @GetMapping
    public List<User> getAllUsers() {
        return this.userService.getAllUsers();
    }
}
