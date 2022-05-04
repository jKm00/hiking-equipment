package no.ntnu.xxs.entities;

import org.springframework.data.annotation.Id;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * This class represents a relation between users and roles
 */
@Entity
@Table(name = "user_roles")
public class UserRoles
{
    @Id
    private long id;

    /**
     * Empty constructor
     */
    public UserRoles(){}
}
