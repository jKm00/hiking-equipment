package no.ntnu.xxs.entities.product;

import com.fasterxml.jackson.annotation.JsonIgnore;
import no.ntnu.xxs.entities.Order;
import no.ntnu.xxs.entities.cart.CartItem;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * Represents a product that is sold in the web-application
 */
@Entity
@Table(name = "products")
public class Product {

    //Primary Key
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long id;

    //Columns
    @Column(name="product_name")
    private String productName;
    @Column(name="product_description")
    private String description;
    @Column(name="price")
    private float price;
    @Column(name="category")
    private String category;
    @Column(name="sex")
    private String sex;
    @Column(name="featured")
    private boolean featured;
    @Column(name = "discount")
    private float discount;

    @OneToMany(mappedBy = "product")
    private Set<ProductEntry> productEntries = new LinkedHashSet<>();


    // Relation to ProductDetails
    @OneToMany(mappedBy = "product", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<ProductDetail> productDetails = new LinkedHashSet<>();

    // Relation to CartItem
    @OneToOne
    @JoinColumn(name = "cart_item", referencedColumnName = "id")
    @JsonIgnore
    private CartItem cartItem;

    // Relation to Order
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "order_products",
            joinColumns = @JoinColumn(name = "product_id"),
            inverseJoinColumns = @JoinColumn(name = "order_id")
    )
    @JsonIgnore
    private Set<Order> order = new LinkedHashSet<>();

    public Product() {}

    public Product(String productName, String description, float price, String category, String sex, boolean featured, float discount) {
        this.productName = productName;
        this.description = description;
        this.price = price;
        this.category = category;
        this.sex = sex;
        this.featured = featured;
        this.discount = discount;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public boolean isFeatured() {
        return featured;
    }

    public void setFeatured(boolean featured) {
        this.featured = featured;
    }

    public Set<ProductDetail> getProductDetails() {
        return productDetails;
    }

    public void setProductDetails(Set<ProductDetail> productDetails) {
        this.productDetails = productDetails;
    }

    public CartItem getCartItem() {
        return cartItem;
    }

    public void setCartItem(CartItem cartItem) {
        this.cartItem = cartItem;
    }

    public float getDiscount() {
        return discount;
    }

    public void setDiscount(float discount) {
        this.discount = discount;
    }

    public Set<Order> getOrder() {
        return order;
    }

    public void setOrder(Set<Order> order) {
        this.order = order;
    }
}
