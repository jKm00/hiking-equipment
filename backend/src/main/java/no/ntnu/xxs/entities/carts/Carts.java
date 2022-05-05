package no.ntnu.xxs.entities;

import javax.persistence.*;

/**
 * This class represents a cart in the web application
 */
@Entity
@Table(name = "carts")
public class Carts
{
    //fields
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(unique = true, name = "cart_id")
    private long id;
    private long userID;

    /**
     * Empty constructor
     */
    public Carts(){}


}
