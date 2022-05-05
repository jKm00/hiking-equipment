package no.ntnu.xxs.entities;

import javax.persistence.*;

/**
 * This class represents the products in an order in the web shop
 */
@Entity
@Table(name = "oder_products")
public class OrderProducts
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(unique = true, name = "order_products_id")
    private long id;

    /**
     * Empty constructor
     */
    public OrderProducts(){}
}
