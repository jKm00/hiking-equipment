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

    // Primary Key
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long id;

    // Columns
    @Column(name = "product_name")
    private String productName;
    @Column(name = "product_description")
    private String description;
    @Column(name = "price")
    private float price;
    @Column(name = "category")
    private String category;
    @Column(name = "sex")
    private String sex;
    @Column(name = "featured")
    private boolean featured;
    @Column(name = "discount")
    private float discount;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "product_colors", joinColumns = @JoinColumn(name = "product_id"), inverseJoinColumns = @JoinColumn(name = "color_id"))
    private Set<Color> colors = new LinkedHashSet<>();

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "product_sizes", joinColumns = @JoinColumn(name = "product_id"), inverseJoinColumns = @JoinColumn(name = "size_id"))
    private Set<Size> sizes = new LinkedHashSet<>();

    // Relation to ProductDetails
    @OneToMany(mappedBy = "product", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<ProductDetail> productDetails = new LinkedHashSet<>();

    // Relation to Order
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "order_products", joinColumns = @JoinColumn(name = "product_id"), inverseJoinColumns = @JoinColumn(name = "order_id"))
    @JsonIgnore
    private Set<Order> order = new LinkedHashSet<>();

    public Product() {
    }

    public Product(String productName, String description, float price, String category, String sex, boolean featured,
            float discount) {
        this.productName = productName;
        this.description = description;
        this.price = price;
        this.category = category;
        this.sex = sex;
        this.featured = featured;
        this.discount = discount;
    }

    /**
     * Adds a detail about the product to the product
     * 
     * @param productDetail the detail to be added
     */
    public void addProductDetails(ProductDetail productDetail) {
        this.productDetails.add(productDetail);
    }

    /**
     * Adds a size to the product
     * 
     * @param size the size to add
     */
    public void addSize(Size size) {
        this.sizes.add(size);
    }

    /**
     * Adds a color to the product
     * 
     * @param color the color to add
     */
    public void addColor(Color color) {
        this.colors.add(color);
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

    public float getDiscount() {
        return discount;
    }

    public void setDiscount(float discount) {
        this.discount = discount;
    }

    public Set<Color> getColors() {
        return colors;
    }

    public void setColors(Set<Color> colors) {
        this.colors = colors;
    }

    public Set<Size> getSizes() {
        return sizes;
    }

    public void setSizes(Set<Size> sizes) {
        this.sizes = sizes;
    }

    public Set<ProductDetail> getProductDetails() {
        return productDetails;
    }

    public void setProductDetails(Set<ProductDetail> productDetails) {
        this.productDetails = productDetails;
    }

    public Set<Order> getOrder() {
        return order;
    }

    public void setOrder(Set<Order> order) {
        this.order = order;
    }

}
