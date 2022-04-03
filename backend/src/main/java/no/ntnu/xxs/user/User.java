package no.ntnu.xxs.user;

import no.ntnu.xxs.role.Role;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Set;

/**
 * Represents a User in the web application.
 */
@Entity
public class User {
    @Id
    @GeneratedValue
    private long userId;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String country;
    private String zipCode;
    private String city;
    private String address;
    // TODO: Many to one relation
    private Set<Role> roles;

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

    //TODO: Add error handling for setters
    public long getId() {
        return userId;
    }

    public void setId(long id) {
        this.userId = id;
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

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    /**
     * Add a role to the user
     * @param role the role to add
     */
    public void addRole(Role role) {
        this.roles.add(role);
    }

    /**
     * Remove a role from a user
     * @param role the role to remove
     */
    public void removeRole(Role role) {
        this.roles.remove(role);
    }
}


