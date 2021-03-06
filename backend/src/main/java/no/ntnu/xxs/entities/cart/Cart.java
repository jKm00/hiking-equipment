package no.ntnu.xxs.entities.cart;

import com.fasterxml.jackson.annotation.JsonIgnore;
import no.ntnu.xxs.entities.user.User;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * This class represents a cart in the web application
 */
@Entity
@Table(name = "carts")
public class Cart
{
    // Primary Key
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(unique = true, name = "id")
    private long id;

    // Relation to cartItem
    @OneToMany(mappedBy = "cart")
    @Column(name = "cart_item_id")
    private Set<CartItem> cartItems = new LinkedHashSet<>();

    // Relation to User
    @JsonIgnore
    @OneToOne(mappedBy = "cart")
    private User user;

    /**
     * Empty constructor
     */
    public Cart(){}

    public Cart(User user) {
        this.user = user;
    }

    /**
     * Adds a cart item to the cart
     * @param cartItem the cart item to be added
     */
    public void addCartItem(CartItem cartItem) {
        this.cartItems.add(cartItem);
    }
    public void removeCartItem(CartItem cartItem) { this.cartItems.remove(cartItem); }

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

    public Set<CartItem> getCartItems() {
        return cartItems;
    }

    public void setCartItems(Set<CartItem> cartItem) {
        this.cartItems = cartItem;
    }

    public void emptyCart() {
        cartItems = new LinkedHashSet<>();
    }
}
