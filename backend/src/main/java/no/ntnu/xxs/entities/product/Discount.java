package no.ntnu.xxs.entities.product;

import no.ntnu.xxs.entities.product.Product;

import javax.persistence.*;

/**
 * This class represents the discounts for the web shop
 */
@Entity
@Table(name = "discounts")
public class Discount
{
    // Primary Key
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(unique = true, name = "id")
    private long id;

    // Relation to Product
    @OneToOne(mappedBy = "discount")
    private Product product;

    // Columns
    @Column(name = "discount_name")
    private String discountName;
    @Column(name = "description")
    private String description;
    @Column(name = "discount_percentage")
    private long discountPercentage;
    @Column(name = "active")
    private boolean active;


    /**
     * Empty constructor
     */
    public Discount(){}

    public Discount(String discountName, String description, long discountPercentage, boolean active) {
        this.discountName = discountName;
        this.description = description;
        this.discountPercentage = discountPercentage;
        this.active = active;
    }

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

    public String getDiscountName() {
        return discountName;
    }

    public void setDiscountName(String discountName) {
        this.discountName = discountName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public long getDiscountPercentage() {
        return discountPercentage;
    }

    public void setDiscountPercentage(long discountPercentage) {
        this.discountPercentage = discountPercentage;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
