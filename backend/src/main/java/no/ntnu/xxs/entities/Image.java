package no.ntnu.xxs.entities;

import no.ntnu.xxs.product.Product;

import javax.persistence.*;

@Entity
@Table(name = "images")
public class Image {

    //fields
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(unique = true, name = "image_id")
    private long id;
    @Column(name = "image")
    private String image; //thought is to have a binary string, may be swapped with another datatype

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;



    /**
     * empty constructor
     */
    public Image(){}


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
