package no.ntnu.xxs.product.addons;

import no.ntnu.xxs.product.Product;

import javax.persistence.*;

@Entity
@Table(name = "product_details")
public class ProductDetail {
    @Id
    @GeneratedValue
    private long id;

    @ManyToOne(fetch =  FetchType.LAZY, optional = false)
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

    private String detailDescription;

    public ProductDetail() {}

    public ProductDetail(String detailDescription) {
        this.detailDescription = detailDescription;
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

    public String getDetailDescription() {
        return detailDescription;
    }

    public void setDetailDescription(String detailDescription) {
        this.detailDescription = detailDescription;
    }
}
