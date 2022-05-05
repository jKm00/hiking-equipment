package no.ntnu.xxs.entities.carts;

import no.ntnu.xxs.user.User;

import javax.persistence.*;

/**
 * This class represents a cart in the web application
 */
@Entity
@Table(name = "carts")
public class Cart
{
    //fields
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(unique = true, name = "cart_id")
    private long id;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    /**
     * Empty constructor
     */
    public Cart(){}

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
