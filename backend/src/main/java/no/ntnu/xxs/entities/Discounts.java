package no.ntnu.xxs.entities;

import javax.persistence.*;

/**
 * This class represents the discounts for the web shop
 */
@Entity
@Table(name = "discounts")
public class Discounts
{
    //fields
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(unique = true, name = "discount_id")
    private long id;

    @Column(name = "discount_name")
    private String discountName;
    @Column(name = "description")
    private String description;
    @Column(name = "discount_percentage")
    private long discountPercentage;
    @Column(name = "active")
    private boolean active;




}
