package no.ntnu.xxs.entities.user;

import com.fasterxml.jackson.annotation.JsonIgnore;

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

    // Primary Key
    @Id
    @GeneratedValue
    @Column(unique = true, name = "id")
    private long id;

    // Columns
    @Column(name = "role_name")
    private String name;

    // Relation to User
    @JsonIgnore
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
