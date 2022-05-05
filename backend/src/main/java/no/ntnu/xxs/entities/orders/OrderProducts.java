package no.ntnu.xxs.entities.orders;

import no.ntnu.xxs.product.Product;

import javax.persistence.*;
import java.io.Serializable;

/**
 * This class represents the products in an order in the web shop
 */
@Entity
@Table(name = "order_products")
public class OrderProducts implements Serializable
{
    @EmbeddedId
    OrderProductsKey id;

    @ManyToOne
    @MapsId("orderID")
    @JoinColumn(name = "order_id")
    private Order order;


    @ManyToOne
    @MapsId("productID")
    @JoinColumn(name = "product_id")
    private Product product;

    /**
     * Empty constructor
     */
    public OrderProducts(){}
}
