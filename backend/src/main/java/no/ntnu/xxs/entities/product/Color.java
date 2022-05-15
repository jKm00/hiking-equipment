package no.ntnu.xxs.entities.product;

import com.fasterxml.jackson.annotation.JsonIgnore;
import no.ntnu.xxs.entities.cart.CartItem;

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
    @Column(name = "id")
    private long id;

    // Relation to ProductEntrySet
    @OneToMany(mappedBy = "color")
    private Set<ProductEntry> productEntries = new LinkedHashSet<>();

    // Relation to CartItem
    @OneToMany(mappedBy = "color")
    @JsonIgnore
    private Set<CartItem> cartItem;

    // Columns
    @Column(name = "color")
    private String color;


    /**
     * empty constructor
     */
    public Color() {}

    public Color(String color) {
        this.color = color;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Set<ProductEntry> getProductEntrySet() {
        return productEntries;
    }

    public void setProductEntrySet(Set<ProductEntry> productEntrySet) {
        this.productEntries = productEntrySet;
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
