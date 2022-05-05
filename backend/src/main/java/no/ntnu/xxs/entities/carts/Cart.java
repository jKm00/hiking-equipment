package no.ntnu.xxs.entities.carts;

import com.fasterxml.jackson.annotation.JsonIgnore;
import no.ntnu.xxs.entities.CartItem;
import no.ntnu.xxs.product.Product;
import no.ntnu.xxs.user.User;

import javax.persistence.*;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Set;

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
    @Column(unique = true, name = "id")
    private long id;

    //relations

    @OneToMany(mappedBy = "cart")
    private Set<CartItem> cartItem;

    @OneToOne(mappedBy = "cart")
    private User user;

    /*
    @JsonIgnore
    @ManyToMany(mappedBy = "carts")
    private Set<Product> products = new LinkedHashSet<>();*/

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
