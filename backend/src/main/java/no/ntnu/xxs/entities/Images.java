package no.ntnu.xxs.entities;

import javax.persistence.*;

@Entity
@Table(name = "images")
public class Images {

    //fields
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(unique = true, name = "image_id")
    private long id;
    @Column(name = "image")
    private byte[] image; //thought is to have a binary string, may be swapped with another datatype
    @Column(name = "thumbnail")
    private byte[] thumbnail;

    private long productID; //foreign key



    /**
     * empty constructor
     */
    public Images(){}
}
