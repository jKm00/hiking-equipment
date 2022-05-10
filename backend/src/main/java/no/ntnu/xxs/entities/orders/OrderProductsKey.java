package no.ntnu.xxs.entities.orders;

import org.hibernate.criterion.Order;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class OrderProductsKey implements Serializable
{
    // Foreign key
    @Column(name = "order_id")
    private long orderID;

    // Foreign key
    @Column(name = "product_id")
    private long productID;


    /**
     * Empty constructor
     */
    public OrderProductsKey(){}

    public long getOrderID() {
        return orderID;
    }

    public void setOrderID(long orderID) {
        this.orderID = orderID;
    }

    public long getProductID() {
        return productID;
    }

    public void setProductID(long productID) {
        this.productID = productID;
    }
}
