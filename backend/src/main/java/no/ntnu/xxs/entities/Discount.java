package no.ntnu.xxs.entities;

import no.ntnu.xxs.product.Product;

import javax.persistence.*;

/**
 * This class represents the discounts for the web shop
 */
@Entity
@Table(name = "discounts")
public class Discount
{
    //fields
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(unique = true, name = "id")
    private long id;

    @OneToOne(mappedBy = "discount")
    private Product product;

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

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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
