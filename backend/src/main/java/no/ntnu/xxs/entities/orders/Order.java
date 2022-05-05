package no.ntnu.xxs.entities.orders;


import no.ntnu.xxs.user.User;

import javax.persistence.*;

/**
 * This class represents an order in the web shop
 */
@Entity
@Table(name = "orders")
public class Order
{
    //fields
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(unique = true, name = "order_id")
    private long id;

    //Foreign key
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name = "total_price")
    private long totalPrice;

    @Column(name = "status")
    private String status;

    /**
     * Empty constructor
     */
    public Order()
    {

    }

    public long getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(long totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
