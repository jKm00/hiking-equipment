package no.ntnu.xxs.product.details;

import com.fasterxml.jackson.annotation.JsonIgnore;
import no.ntnu.xxs.product.Product;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class ProductDetail {
    @Id
    @GeneratedValue
    private long id;
    private String detail;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "product_id", nullable = false)
    @JsonIgnore
    private Product product;

    public ProductDetail() {}

    public ProductDetail(String detail, Product product) {
        this.detail = detail;
        this.product = product;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
