package no.ntnu.xxs.entities.orders;


import com.fasterxml.jackson.annotation.JsonIgnore;
import no.ntnu.xxs.product.Product;
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
    // Primary Key
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(unique = true, name = "id")
    private long id;

    //Foreign key
    //Relation to User
    @JsonIgnore
    @ManyToOne()
    @JoinColumn(name = "user_id")
    private User user;

    // Relation to Product
    @JsonIgnore
    @ManyToMany(mappedBy = "order", fetch = FetchType.LAZY)
    private Set<Product> product = new LinkedHashSet<>();

    // Columns
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
