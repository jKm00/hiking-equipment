package no.ntnu.xxs.entities;

import javax.persistence.*;

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
    @Column(unique = true, name = "size_id")
    private long id;
    @Column(name = "size")
    private String size;


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
