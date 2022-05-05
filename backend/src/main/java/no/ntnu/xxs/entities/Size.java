package no.ntnu.xxs.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import no.ntnu.xxs.product.Product;
import org.hibernate.type.CharacterArrayNClobType;


import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * This class represents all sizes that exist in the shop
 */
@Entity
@Table(name = "sizes")
public class Size
{
    //fields
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(unique = true, name = "id")
    private long id;

    @JsonIgnore
    @ManyToMany(mappedBy = "sizes")
    private Set<Product> productEntrySet = new LinkedHashSet<>();

    @Column(name = "size")
    private String size;

    @OneToMany(mappedBy = "size")
    private Set<CartItem> cartItem;


    /**
     * empty constructor
     */
    public Size() {

    }



    public Size(String size)
    {
        this.size = size;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        size = size;
    }
}
