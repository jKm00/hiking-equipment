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
@Table(name = "roles")
public class Role {
    @Id
    @GeneratedValue
    @Column(unique = true, name = "role_id")
    private long id;
    @Column(name="role_name")
    private String roleName;

    @ManyToMany(mappedBy = "roles")
    @JsonIgnore
    private Set<User> users = new HashSet<>();

    public Role() {}

    public Role(String roleName) {
        this.roleName = roleName;
    }

    public long getId() {
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
