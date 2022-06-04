package no.ntnu.xxs.entities.cart;

import com.fasterxml.jackson.annotation.JsonIgnore;
import no.ntnu.xxs.exception.QuantityBelowZeroException;

import javax.persistence.*;

/**
 * Describes a product that is in a cart of a user. Only contains
 * information about the product that is necessary for the cart.
 */
@Entity
@Table(name = "cart_item")
public class CartItem {

    //Primary key
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "cartitem_id")
    private long id;

    @Column(name = "product_id")
    private long productId;

    @Column(name = "product_name")
    private String productName;

    @Column(name = "product_price")
    private float productPrice;

    @Column(name = "product_category")
    private String productCategory;

    @Column(name = "product_sex")
    private String productSex;

    @Column(name = "discount")
    private float discount;

    @Column(name = "product_color")
    private String color;

    @Column(name = "product_size")
    private String size;

    @Column(name = "quantity")
    private int quantity;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "cart_id", referencedColumnName = "id")
    @JsonIgnore
    private Cart cart;

    /**
     * Empty constructor
     */
    public CartItem(){}

    public CartItem(long productId, String productName, float productPrice, String productCategory, String productSex, float discount, String color, String size, int quantity) {
        this.productId = productId;
        this.productName = productName;
        this.productPrice = productPrice;
        this.productCategory = productCategory;
        this.productSex = productSex;
        this.discount = discount;
        this.color = color;
        this.size = size;
        this.quantity = quantity;
    }

    /**
     * Increments the quantity be one
     */
    public void incrementQuantity() {
        this.quantity++;
    }

    /**
     * Increments the quantity by a fixed amount
     * @param incrementAmount the amount to increment with
     */
    public void incrementQuantity(int incrementAmount) {
        this.quantity += incrementAmount;
    }

    /**
     * Decrements the quantity by one
     * @throws QuantityBelowZeroException if the quantity reached 0 or below
     * after a call to this method, this exception is thrown
     */
    public void decrementQuantity() throws QuantityBelowZeroException {
        this.quantity--;
        if (this.quantity <= 0) {
            throw new QuantityBelowZeroException("Quantity of cart item was decremented below zero");
        }
    }

    /**
     * Decrements the quantity a fixed amount
     * @param decrementAmount the amount to decrement with
     * @throws QuantityBelowZeroException if the quantity reached 0 or below
     * after a call to this method, this exception is thrown
     */
    public void decrementQuantity(int decrementAmount) throws QuantityBelowZeroException {
        this.quantity -= decrementAmount;
        if (this.quantity <= 0) {
            throw new QuantityBelowZeroException("Quantity of cart item was decremented below zero");
        }
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getProductId() {
        return productId;
    }

    public void setProductId(long productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public float getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(float productPrice) {
        this.productPrice = productPrice;
    }

    public String getProductCategory() {
        return productCategory;
    }

    public void setProductCategory(String productCategory) {
        this.productCategory = productCategory;
    }

    public String getProductSex() {
        return productSex;
    }

    public void setProductSex(String productSex) {
        this.productSex = productSex;
    }

    public float getDiscount() {
        return discount;
    }

    public void setDiscount(float discount) {
        this.discount = discount;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }
}
