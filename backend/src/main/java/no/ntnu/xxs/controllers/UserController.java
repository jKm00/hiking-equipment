package no.ntnu.xxs.controllers;

import no.ntnu.xxs.entities.user.User;
import no.ntnu.xxs.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    public List<User> getAllUsers() {
        return this.userService.getAllUsers();
    }
}
