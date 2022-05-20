package no.ntnu.xxs.entities.product;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.security.crypto.codec.Base64;

import javax.imageio.ImageIO;
import javax.persistence.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;

@Entity
@Table
public class Image {

    // Primary Key
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "product_id", nullable = false, referencedColumnName = "id")
    @JsonIgnore
    private Product product;

    @Column(name = "binaryValue")
    private long binaryImage;

    public Image()
    {

    }


    public Image(long binaryStream){
        this.binaryImage = binaryStream;
    }

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

    public long getBinaryImage() {
        return binaryImage;
    }

    public void setBinaryImage(long imageBinary) {
        this.binaryImage = imageBinary;
    }
}
