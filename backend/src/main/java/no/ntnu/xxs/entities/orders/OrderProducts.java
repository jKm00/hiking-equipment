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
    // Primary Key
    @EmbeddedId
    OrderProductsKey id;

    // Relation to Order
    @ManyToOne
    @MapsId("orderID")
    @JoinColumn(name = "order_id", referencedColumnName = "id")
    private Order order;

    // Relation to Product
    @ManyToOne
    @MapsId("productID")
    @JoinColumn(name = "product_id", referencedColumnName = "id")
    private Product product;

    /**
     * Empty constructor
     */
    public OrderProducts(){}

    public OrderProductsKey getId() {
        return id;
    }

    public void setId(OrderProductsKey id) {
        this.id = id;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
