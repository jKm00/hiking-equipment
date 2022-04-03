package no.ntnu.xxs.product.addons;

import no.ntnu.xxs.product.Product;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

// TODO: Make relation with product
@Entity
public class Discount {
    @Id
    @GeneratedValue
    private long id;

    private String discountName;
    private String description;
    private int discountPercentage;
    private boolean active;

    @OneToOne(mappedBy = "discount")
    private Product product;

    public Discount() {}

    public Discount(String discountName, String description, int discountPercentage, boolean active) {
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

    public int getDiscountPercentage() {
        return discountPercentage;
    }

    public void setDiscountPercentage(int discountPercentage) {
        this.discountPercentage = discountPercentage;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
