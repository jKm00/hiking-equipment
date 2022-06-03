package no.ntnu.xxs.entities.product;


import com.fasterxml.jackson.annotation.JsonIgnore;
import no.ntnu.xxs.entities.cart.Cart;

import javax.persistence.*;

@Entity
@Table(name = "images")
public class Image{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long id;


    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "image_id", referencedColumnName = "id")
    @JsonIgnore
    private Product product;

    @Column(name = "imageBlob")
    private String imageString;




    public Image(String imageString){
        this.imageString = imageString;
    }

    /**
     * Empty constructor
     */
    public Image(){}

    public String getImageString() {
        return imageString;
    }

    public void setImageString(String imageString) {
        this.imageString = imageString;
    }
}
