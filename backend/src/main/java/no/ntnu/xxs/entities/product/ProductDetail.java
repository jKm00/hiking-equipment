package no.ntnu.xxs.entities.product;

import com.fasterxml.jackson.annotation.JsonIgnore;
import no.ntnu.xxs.entities.product.Product;

import javax.persistence.*;

@Entity
@Table(name = "product_details")
public class ProductDetail {

    // Primary Key
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(unique = true, name = "id")
    private long id;

    // Relation to Product
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "product_id", nullable = false, referencedColumnName = "id")
    @JsonIgnore
    private Product product;

    // Columns
    @Column(name="details")
    private String detail;

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
