package no.ntnu.xxs.product.size;

import no.ntnu.xxs.product.entry.ProductEntry;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Set;

/**
 * Represents a size of a product
 */
@Entity
public class Size {
    @Id
    @GeneratedValue
    private long id;
    private String sizeValue;

    @OneToMany(mappedBy = "size")
    private Set<ProductEntry> productEntries;

    public Size() {}

    public Size(String sizeValue) {
        this.sizeValue = sizeValue;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getSizeValue() {
        return sizeValue;
    }

    public void setSizeValue(String sizeValue) {
        this.sizeValue = sizeValue;
    }
}
