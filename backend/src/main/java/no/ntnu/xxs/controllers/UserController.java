package no.ntnu.xxs.controllers;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.Contact;
import no.ntnu.xxs.dto.UpdateUserRequest;
import no.ntnu.xxs.entities.user.User;
import no.ntnu.xxs.exception.NoSuchUserException;
import no.ntnu.xxs.security.JwtUtil;
import no.ntnu.xxs.services.AccessUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    private JwtUtil jwtUtil;
    @Autowired
    private AccessUserService userService;

    /**
     * Get all users from database
     * @return a list of all users in the database
     */
    @GetMapping
    @ApiOperation(value = "Returns all users",
            notes = "provides all users within the database",
            response = Contact.class)
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public List<User> getAllUsers() {
        return this.userService.getAllUsers();
    }

    /**
     * Returns a Http.OK response with a user with the id given as param as body. Only user that are logged in with
     * the same id as given in param will get the correct user. If a user with a different id
     * from the one given as param tries to get the user object, a HttpResponse FORBIDDEN is returned.
     * @param jwt the jwt token of the user that tries to access this endpoint
     * @param id the id of the user that should be returned
     * @return Http.OK if the ID in the jwt token matches the ID in the URL. Http.FORBIDDEN otherwise
     */
    @GetMapping("/{id}")
    @PreAuthorize("hasRole('ROLE_USER')")
    @ApiOperation(value = "Finds a user with a given id",
            notes = "Provide an id to find a user",
            response = Contact.class)
    public ResponseEntity<?> getUser(@ApiParam(value = "json web token of the user trying to access the endpoint")
                                        @RequestHeader("Authorization") String jwt,
                                     @ApiParam(value = "Id of the user that should be returned")
                                     @PathVariable long id) {
        if (!matchingTokenAndUrlId(jwt, id)) {
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }
        return new ResponseEntity<>(userService.getUser(id), HttpStatus.OK);
    }

    /**
     * Updates a user based on an id. Only user logged in can update their user, meaning the id in the jwt token
     * has to match the id in the url. If not Http.FORBIDDEN is returned.
     * @param jwt the jwt token of the user that send the request
     * @param id the id of the user to update
     * @param newUserDetails a JSON object containing new values to update the user with
     * @return Http.OK if user is updated, Http.BAD_REQUEST if no user with the id is found, Http.FORBIDDEN if
     * access is denied.
     */
    @PutMapping("/{id}")
    @PreAuthorize("hasRole('ROLE_USER')")
    @ApiOperation(value = "Updates an already existing user based on a given id",
            notes = "Provide the json web token and id of the user to be updated",
            response = Contact.class)
    public ResponseEntity<?> updateUser(@ApiParam(value = "json web token of the user trying to access the endpoint")
                                        @RequestHeader("Authorization") String jwt,
                                        @ApiParam(value = "Id of the user that should be returned")
                                        @PathVariable long id,
                                        @ApiParam(value = "New user details to replace the old ones")
                                        @RequestBody UpdateUserRequest newUserDetails) {
        if (!matchingTokenAndUrlId(jwt, id)) {
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }
        ResponseEntity response;
        try {
            this.userService.updateUser(id, newUserDetails);
            response = new ResponseEntity(HttpStatus.OK);
        } catch (NoSuchUserException e) {
            response = new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
        return response;
    }

    /**
     * Returns {@code true} if the id in the jwt token and the id from the url is matching, {@code false} if
     * they are not matching.
     * @param jwtToken the jwt token from the request header
     * @param urlId the id specified in the request url
     * @return {@code true} if token id and url id is matching
     */
    private boolean matchingTokenAndUrlId(String jwtToken, long urlId) {
        if (jwtToken == null) {
            return false;
        }
        int jwtId = jwtUtil.extractId(jwtToken.substring(7, jwtToken.length()));
        if (jwtId == -1 || jwtId != urlId) {
            return false;
        }
        return true;
    }
}
