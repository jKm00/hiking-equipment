package no.ntnu.xxs.role;

import no.ntnu.xxs.user.User;

import javax.persistence.*;
import java.util.LinkedHashSet;
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

    @Column(name = "role_name")
    private String name;

    @ManyToMany(mappedBy = "roles", fetch = FetchType.LAZY)
    private Set<User> users = new LinkedHashSet<>();

    /**
     * Empty constructor
     */
    public Role(){}


    /**
     * not empty constructor
     * @param name name of role
     */
    public Role(String name)
    {
        this.name = name;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }
}
