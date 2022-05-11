package no.ntnu.xxs.entities.product;

import javax.persistence.*;

@Entity
public class ProductEntries
{

    @Id
    private ProductEntryKey id;

    @ManyToOne
    @MapsId("colorID")
    @JoinColumn(name = "student_id")
    private Color color;

    @ManyToOne
    @MapsId("sizeID")
    @JoinColumn(name = "course_id")
    private Size size;

    public ProductEntryKey getId() {
        return id;
    }

    public void setId(ProductEntryKey id) {
        this.id = id;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Size getSize() {
        return size;
    }

    public void setSize(Size size) {
        this.size = size;
    }
}
