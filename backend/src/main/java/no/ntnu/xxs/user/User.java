package no.ntnu.xxs.user;

import com.fasterxml.jackson.annotation.JsonIgnore;
import no.ntnu.xxs.entities.carts.Cart;
import no.ntnu.xxs.entities.orders.Order;
import no.ntnu.xxs.role.Role;

import javax.persistence.*;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * Represents a User in the web application.
 */
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(unique = true, name = "user_id")
    private int id;
    @Column(name= "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "email")
    private String email;
    @JsonIgnore
    private String password;
    @Column(name="country")
    private String country;
    @Column(name="zipcode")
    private String zipCode;
    @Column(name="city")
    private String city;
    @Column(name="address")
    private String address;
    private boolean isActive = true;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "user_role",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private Set<Role> roles = new LinkedHashSet<>();



    public User() {}

    public User(String firstName, String lastName, String email, String password, String country, String zipCode, String city, String address) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.country = country;
        this.zipCode = zipCode;
        this.city = city;
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    /**
     * Adds role to the role set
     * @param role
     */
    public void addRole(Role role){
        this.roles.add(role);
    }

    /**
     * Returns true if a user is admin, false if not
     * @return true if a user is admin, false if not
     */
    public boolean isAdmin(){
        return this.hasRole("ROLE_ADMIN");
    }

    /**
     * Checks if a user has a specific role
     * @param roleName name of the role to be checked
     * @return true if role is found, false if not
     */
    public boolean hasRole(String roleName){
        boolean found = false;
        Iterator<Role> it = roles.iterator();
        while(!found && it.hasNext())
        {
            Role role = it.next();
            if(role.getName().equals(roleName))
            {
                found=true;
            }
        }
        return found;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }
}


