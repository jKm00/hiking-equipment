package no.ntnu.xxs.entities.orders;


import com.fasterxml.jackson.annotation.JsonIgnore;
import no.ntnu.xxs.user.User;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

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
    @Column(unique = true, name = "id")
    private long id;

    //Foreign key
    @JsonIgnore
    @ManyToOne()
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy = "order")
    private Set<OrderProducts> orderProducts = new LinkedHashSet<>();

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
