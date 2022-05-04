package no.ntnu.xxs.entities;


import javax.persistence.*;

/**
 * This class represents an order in the web shop
 */
@Entity
@Table(name = "orders")
public class Orders
{
    //fields
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(unique = true, name = "order_id")
    private long id;
    @Column(name = "total_price")
    private long totalPrice;
    @Column(name = "status")
    private String status;

    /**
     * Empty constructor
     */
    public Orders()
    {

    }

}
