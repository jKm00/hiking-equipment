package no.ntnu.xxs.entities;

import javax.persistence.*;

/**
 * this class represents all colors that are available in the web shop
 */
@Entity
@Table(name = "colors")
public class Color
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
    public Color() {

    }


    public Color(String color){
        this.color = color;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
