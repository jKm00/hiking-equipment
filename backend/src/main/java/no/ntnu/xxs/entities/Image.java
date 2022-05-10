package no.ntnu.xxs.entities;

import no.ntnu.xxs.product.Product;

import javax.persistence.*;

@Entity
@Table(name = "images")
public class Image {

    // Primary Key
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(unique = true, name = "id")
    private long id;

    // Relation to Product
    @ManyToOne
    @JoinColumn(name = "product_id", referencedColumnName = "id")
    private Product product;

    // Columns
    @Column(name = "image")
    private String image; //thought is to have a binary string, may be swapped with another datatype




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

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
