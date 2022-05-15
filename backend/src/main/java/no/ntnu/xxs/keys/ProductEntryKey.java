package no.ntnu.xxs.keys;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class ProductEntryKey implements Serializable {
    @Column(name = "product_id")
    private Long productId;
    @Column(name = "size_id")
    private Long sizeId;
    @Column(name = "color_id")
    private Long colorId;

    public ProductEntryKey() {}

    public ProductEntryKey(Long productId, Long sizeId, Long colorId) {
        this.productId = productId;
        this.sizeId = sizeId;
        this.colorId = colorId;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Long getSizeId() {
        return sizeId;
    }

    public void setSizeId(Long sizeId) {
        this.sizeId = sizeId;
    }

    public Long getColorId() {
        return colorId;
    }

    public void setColorId(Long colorId) {
        this.colorId = colorId;
    }
}
