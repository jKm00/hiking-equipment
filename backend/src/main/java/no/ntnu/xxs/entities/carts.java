package no.ntnu.xxs.entities;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * This class represents a cart in the web application
 */
public class carts
{
    //fields
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private long userID;

    /**
     * Empty constructor
     */
    public carts(){}
}
