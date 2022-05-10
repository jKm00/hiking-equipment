package no.ntnu.xxs.entities.product;

import com.fasterxml.jackson.annotation.JsonIgnore;
import no.ntnu.xxs.entities.cart.CartItem;
import no.ntnu.xxs.entities.product.Product;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * this class represents all colors that are available in the web shop
 */
@Entity
@Table(name = "colors")
public class Color
{
    // Primary Key
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(unique = true, name = "id")
    private long id;

    // Relation to ProductEntrySet
    @JsonIgnore
    @ManyToMany(mappedBy = "colors")
    private Set<Product> productEntrySet = new LinkedHashSet<>();

    // Relation to CartItem
    @OneToMany(mappedBy = "color")
    private Set<CartItem> cartItem;

    // Columns
    @Column(name = "color")
    private String color;



    /**
     * empty constructor
     */
    public Color() {

    }

    public Color(String color) {
        this.color = color;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Set<Product> getProductEntrySet() {
        return productEntrySet;
    }

    public void setProductEntrySet(Set<Product> productEntrySet) {
        this.productEntrySet = productEntrySet;
    }

    public Set<CartItem> getCartItem() {
        return cartItem;
    }

    public void setCartItem(Set<CartItem> cartItem) {
        this.cartItem = cartItem;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
