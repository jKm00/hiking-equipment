package no.ntnu.xxs.product.entry;

import no.ntnu.xxs.product.Product;

import javax.persistence.*;

/**
 * Represents the product_entry table in the database. This table
 * is used to combine products with colors and sizes. Each product
 * can have many colors and sizes.
 * Stored in this table is the product with its size, color and quantity
 */
// TODO: Rename to something more understandable
@Entity
@Table(name = "product_entry")
public class ProductEntry {

    @Id
    @GeneratedValue
    private long id;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    private String size;
    private String color;
    private int quantity;

    public ProductEntry() {}

    public ProductEntry(Product product, String size, String color, int quantity) {
        this.product = product;
        this.size = size;
        this.color = color;
        this.quantity = quantity;
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

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
