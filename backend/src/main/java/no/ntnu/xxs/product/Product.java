package no.ntnu.xxs.product;

import no.ntnu.xxs.product.details.ProductDetail;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * Represents a product that is soled in the web-application
 */
@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue
    private long id;
    private String productName;
    private String description;
    private float price;
    private String category;
    private String sex;

    @OneToMany(mappedBy = "product", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<ProductDetail> productDetails;

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

    /**
     * Adds a detail about the product to the details list.
     * A product can have many or none details.
     * @param detail the detail to add.
     */
    public void addProductDetail(ProductDetail detail) {
        this.productDetails.add(detail);
    }
}
