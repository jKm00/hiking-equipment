package no.ntnu.xxs.entities.product;

import org.hibernate.annotations.Type;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.transaction.Transactional;

/**
 * Entity for storing image data
 */
@Entity
@Table(name = "image")
public class Image {
    // Primary Key
    @Column(unique = true, name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Lob
    private byte[] data;
    private String extension;
    private String contentType;

    @Column(name = "product_id")
    private Long productId;

    public Image() {
    }

    public Image(byte[] data, String extension, String contentType, Long productId) {
        this.data = data;
        this.extension = extension;
        this.contentType = contentType;
        this.productId = productId;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public byte[] getData() {
        return this.data;
    }

    public void setData(byte[] data) {
        this.data = data;
    }

    public String getExtension() {
        return this.extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }

    public String getFileName() {
        return id + "." + extension;
    }

    public String getContentType() {
        return this.contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

}