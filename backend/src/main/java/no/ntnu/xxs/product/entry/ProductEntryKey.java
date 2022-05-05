package no.ntnu.xxs.product.entry;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class ProductEntryKey implements Serializable
{
    @Column(name = "product_id")
    private long productID;

    @Column(name = "size_id")
    private long sizeID;

    @Column(name = "color_id")
    private long colorID;

    @Column(name = "quantity")
    private int quantity;

    /**
     * Empty constructor
     */
    public ProductEntryKey(){}


    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
