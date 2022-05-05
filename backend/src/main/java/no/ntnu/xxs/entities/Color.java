package no.ntnu.xxs.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import no.ntnu.xxs.product.Product;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

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
    @Column(unique = true, name = "id")
    private long id;

    @JsonIgnore
    @ManyToMany(mappedBy = "colors")
    private Set<Product> productEntrySet = new LinkedHashSet<>();

    @Column(name = "color")
    private String color;

    @OneToMany(mappedBy = "color")
    private Set<CartItem> cartItem;


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
