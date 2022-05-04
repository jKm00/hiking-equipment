package no.ntnu.xxs.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * This class represents
 */
@Entity
@Table(name = "cart_products")
public class CartProducts
{
    @Column(name = "product_size")
    private String productSize;
    @Column(name = "product_color")
    private String productColor;

}
