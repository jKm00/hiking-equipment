package no.ntnu.xxs.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import no.ntnu.xxs.entities.user.User;
import org.apache.tomcat.jni.Local;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;
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

    // Relation to order item
   @Column(name = "order_items_id")
    @OneToMany(mappedBy = "order", fetch = FetchType.LAZY)
    private Set<OrderItem> orderItems = new LinkedHashSet<>();

    // Columns
    @Column(name = "total_price")
    private float totalPrice;
    @Column(name = "status")
    private Status status;

    private LocalDate orderDate;

    private enum Status {
        /**
         * Pending status.
         */
        PENDING,
        /**
         * Sent status.
         */
        SENT,
        /**
         * Delivered status.
         */
        DELIVERED
    }

    /**
     * Empty constructor
     */
    public Order()
    {

    }

    /**
     * A method that adds the order item to the order
     *
     * @param orderItem the order item
     */
    public void addOrderItem(OrderItem orderItem) {
        orderItems.add(orderItem);
    }



    public float getTotalPrice() {
        return totalPrice;
    }


    public void setTotalPrice(float totalPrice) {
        this.totalPrice = totalPrice;
    }


    public Status getStatus() {
        return status;
    }


    public long getId() {
        return id;
    }


    public void setId(long id) {
        this.id = id;
    }


    public User getUser() {
        return user;
    }


    public void setUser(User user) {
        this.user = user;
    }


    public Set<OrderItem> getOrderItems() {
        return orderItems;
    }


    public void setOrderItems(Set<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }


    public void setStatus(Status status) {
        this.status = status;
    }

    /**
     * A method that sets the order status to pending
     */
    public void initializeStatus() {
        setStatus(Status.PENDING);
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
    }
}
