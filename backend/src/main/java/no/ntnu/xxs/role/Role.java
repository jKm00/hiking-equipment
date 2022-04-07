package no.ntnu.xxs.role;

import com.fasterxml.jackson.annotation.JsonIgnore;
import no.ntnu.xxs.user.User;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


/**
 * Represents a role. A role can be ADMIN or CUSTOMER.
 * A user can have one or multiple roles.
 */
@Entity
public class Role {
    @Id
    @GeneratedValue
    private Integer id;
    private String roleName;

    @ManyToMany(mappedBy = "roles")
    @JsonIgnore
    private Set<User> users = new HashSet<>();

    public Role() {}

    public Role(String roleName) {
        this.roleName = roleName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    /**
     * Add a user to a specific role
     * @param user the user to add
     */
    public void addUser(User user) {
        this.users.add(user);
    }
}
