package no.ntnu.xxs.entities;


import no.ntnu.xxs.entities.carts.Cart;
import no.ntnu.xxs.entities.carts.CartProductsKey;
import no.ntnu.xxs.product.Product;

import javax.persistence.*;

@Entity
@Table(name = "cart_item")
public class CartItem {

    //Primary key
    @Id
    @GeneratedValue
    private long id;

    // Relation to Product
    @OneToOne(mappedBy = "cartItem")
    private Product product;

    // Relation to Cart
    @ManyToOne
    @JoinColumn(name = "cart_item", referencedColumnName = "id")
    private Cart cart;

    // Relation to Color
    @ManyToOne
    @JoinColumn(name = "item_color", referencedColumnName = "id")
    private Color color;

    // Relation to Size
    @ManyToOne
    @JoinColumn(name = "item_size", referencedColumnName = "id")
    private Size size;

    // Columns
    @Column(name = "quantity")
    private int quantity;

    /**
     * Empty constructor
     */
    public CartItem(){}

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Size getSize() {
        return size;
    }

    public void setSize(Size size) {
        this.size = size;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
