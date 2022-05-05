package no.ntnu.xxs.entities.orders;

import org.hibernate.criterion.Order;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class OrderProductsKey implements Serializable
{

    @Column(name = "order_id")
    private long orderID;

    @Column(name = "product_id")
    private long productID;


    /**
     * Empty constructor
     */
    public OrderProductsKey(){}
}
