package no.ntnu.xxs.entities.carts;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * This class represents a primary key in the CartProduct table
 */
@Embeddable
public class CartProductsKey implements Serializable
{

    @Column(name = "cart_id")
    private long cartID;

    @Column(name = "product_id")
    private long productID;

    /**
     * Empty Constructor
     */
    public CartProductsKey(){}

    public long getCartID() {
        return cartID;
    }

    public void setCartID(long cartID) {
        this.cartID = cartID;
    }

    public long getProductID() {
        return productID;
    }

    public void setProductID(long productID) {
        this.productID = productID;
    }
}
