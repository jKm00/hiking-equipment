package no.ntnu.xxs.entities;


import javax.persistence.*;

@Entity
@Table(name = "product_details")
public class ProductDetails
{
    //fields
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(unique = true, name = "product_details_id")
    private long id;

    private long productID; // forgein key
    @Column(name = "details")
    private String details;

    /**
     * Empty constructor
     */
    public ProductDetails(){}
}
