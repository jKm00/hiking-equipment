package no.ntnu.xxs.role;

import no.ntnu.xxs.user.User;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.Set;


/**
 * Represents a role. A role can be ADMIN or CUSTOMER.
 * A user can have one or multiple roles.
 */
@Entity
public class Role {
    @Id
    @GeneratedValue
    private long id;

    @ManyToMany(mappedBy = "roles")
    private Set<User> users;

    private String roleName;

    public Role() {}

    public Role(Set<User> users, String roleName) {
        this.users = users;
        this.roleName = roleName;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    /**
     * Add a user to a role
     * @param user the user to add
     */
    public void addUser(User user) {
        this.users.add(user);
    }

    /**
     * Remove a user from a role
     * @param user the user to remove
     */
    public void removeUser(User user) {
        this.users.remove(user);
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
}
