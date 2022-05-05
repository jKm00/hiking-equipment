package no.ntnu.xxs.product.entry;

import no.ntnu.xxs.entities.Color;
import no.ntnu.xxs.entities.Size;
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
@Table(name = "product_entries")
public class ProductEntry {

    @EmbeddedId
    ProductEntryKey id;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    @ManyToOne
    @JoinColumn(name = "size_id")
    private Size size;

    @ManyToOne
    @JoinColumn(name = "color_id")
    private Color color;

    private int quantity;

    public ProductEntry() {}

    public ProductEntry(Product product, Size size, Color color, int quantity) {
        this.product = product;
        this.size = size;
        this.color = color;
        this.quantity = quantity;
    }

    public ProductEntryKey getId() {
        return id;
    }

    public void setId(ProductEntryKey id) {
        this.id = id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Size getSize() {
        return size;
    }

    public void setSize(Size size) {
        this.size = size;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
