package no.ntnu.xxs.product;

import no.ntnu.xxs.entities.*;
import no.ntnu.xxs.entities.carts.Cart;
import no.ntnu.xxs.product.details.ProductDetail;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * Represents a product that is sold in the web-application
 */
@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue
    @Column(unique = true, name = "id")
    private long id;

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

    @Column(name = "product_size")
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "product_entries",
            joinColumns = @JoinColumn(name = "product_id"),
            inverseJoinColumns = @JoinColumn(name = "size_id")
    )
    private Set<Size> sizes = new LinkedHashSet<>();

    @Column(name = "product_color")
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "product_entries",
            joinColumns = @JoinColumn(name = "product_id"),
            inverseJoinColumns = @JoinColumn(name = "color_id")
    )
    private Set<Color> colors = new LinkedHashSet<>();

    @Column(name = "quantity")
    private int quantity;

    //relations

    @OneToMany(mappedBy = "product", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<ProductDetail> productDetails = new LinkedHashSet<>();

    /*@ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "cart_products",
            joinColumns = @JoinColumn(name = "product_id"),
            inverseJoinColumns = @JoinColumn(name = "cart_id")
    )
    private Set<Cart> carts = new LinkedHashSet<>();*/

    @OneToOne
    @JoinColumn(name = "cart_item", referencedColumnName = "id")
    private CartItem cartItem;



    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "discount_id", referencedColumnName = "id")
    private Discount discount;

    @OneToMany(mappedBy = "product")
    private Set<Image> image = new LinkedHashSet<>();

    public Product() {}

    public Product(String productName, String description, float price, String category, String sex) {
        this.productName = productName;
        this.description = description;
        this.price = price;
        this.category = category;
        this.sex = sex;
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

    public Set<ProductDetail> getProductDetails() {
        return productDetails;
    }

    public void setProductDetails(Set<ProductDetail> productDetails) {
        this.productDetails = productDetails;
    }
}
