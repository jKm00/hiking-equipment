package no.ntnu.xxs.entities.product;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;

/**
 * Entity for storing image data
 */
@Entity
public class Image {
    @Id
    @GeneratedValue
    private Long id;
    @Lob
    private byte[] data;
    private String extension;
    private String contentType;

    public Image() {
    }

    public Image(byte[] data, String extension, String contentType) {
        this.data = data;
        this.extension = extension;
        this.contentType = contentType;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public byte[] getData() {
        return data;
    }

    public void setData(byte[] data) {
        this.data = data;
    }

    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }

    public String getFileName() {
        return id + "." + extension;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public byte[] getBytes() {
        return this.data;
    }
}