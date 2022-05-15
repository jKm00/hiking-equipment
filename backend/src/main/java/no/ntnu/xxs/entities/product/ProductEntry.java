package no.ntnu.xxs.entities.product;

import com.fasterxml.jackson.annotation.JsonIgnore;
import no.ntnu.xxs.keys.ProductEntryKey;

import javax.persistence.*;

@Entity
@Table(name = "product_entries")
public class ProductEntry {
    @EmbeddedId
    private ProductEntryKey id;

    @ManyToOne
    @MapsId("productId")
    @JoinColumn(name = "product_id")
    @JsonIgnore
    private Product product;

    @ManyToOne(cascade = CascadeType.ALL)
    @MapsId("sizeId")
    @JoinColumn(name = "size_id")
    @JsonIgnore
    private Size size;

    @ManyToOne(cascade = CascadeType.ALL)
    @MapsId("colorId")
    @JoinColumn(name = "color_id")
    @JsonIgnore
    private Color color;

    private int quantity;

    public ProductEntry() {}

    public ProductEntry(ProductEntryKey id, Product product, Size size, Color color, int quantity) {
        this.id = id;
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
