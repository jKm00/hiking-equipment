package no.ntnu.xxs.entities.product;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class ProductEntryKey implements Serializable {

    @Column(name = "color_id")
    long colorID;

    @Column(name = "size_id")
    long sizeID;

    public long getColorID() {
        return colorID;
    }

    public void setColorID(long colorID) {
        this.colorID = colorID;
    }

    public long getSizeID() {
        return sizeID;
    }

    public void setSizeID(long sizeID) {
        this.sizeID = sizeID;
    }
}
