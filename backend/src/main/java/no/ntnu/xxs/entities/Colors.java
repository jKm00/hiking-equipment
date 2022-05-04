package no.ntnu.xxs.entities;

import javax.persistence.*;

/**
 * this class represents all colors that are available in the web shop
 */
@Entity
@Table(name = "colors")
public class Colors
{
    //fields
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(unique = true, name = "color_id")
    private long id;
    @Column(name = "color")
    private String color;

    /**
     * empty constructor
     */
    public Colors(){}
}
