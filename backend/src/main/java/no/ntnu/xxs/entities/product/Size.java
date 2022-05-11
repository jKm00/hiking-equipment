package no.ntnu.xxs.entities.product;

import com.fasterxml.jackson.annotation.JsonIgnore;
import no.ntnu.xxs.entities.cart.CartItem;
import no.ntnu.xxs.entities.product.Product;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * This class represents all sizes that exist in the shop
 */
@Entity
@Table(name = "sizes")
public class Size
{
    // Primary Key
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(unique = true, name = "id")
    private long id;

    // Relation to ProductEntrySet
    @JsonIgnore
    @OneToMany(mappedBy = "size")
    private Set<ProductEntries> productEntries = new LinkedHashSet<>();

    // Relation to CartItems
    @OneToMany(mappedBy = "size")
    private Set<CartItem> cartItem;

    // Columns
    @Column(name = "size")
    private String size;


    /**
     * empty constructor
     */
    public Size() {

    }



    public Size(String size)
    {
        this.size = size;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Set<ProductEntries> getProductEntries() {
        return productEntries;
    }

    public void setProductEntries(Set<ProductEntries> productEntries) {
        this.productEntries = productEntries;
    }

    public Set<CartItem> getCartItem() {
        return cartItem;
    }

    public void setCartItem(Set<CartItem> cartItem) {
        this.cartItem = cartItem;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }
}
