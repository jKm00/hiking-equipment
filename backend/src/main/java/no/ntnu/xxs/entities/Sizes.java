package no.ntnu.xxs.entities;

import javax.persistence.*;

/**
 * This class represents all sizes that exist in the shop
 */
@Entity
@Table(name = "sizes")
public class Sizes
{
    //fields
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(unique = true, name = "size_id")
    private long id;
    @Column(name = "size")
    private String Size;


    /**
     * empty constructor
     */
    public Sizes(){}

}
