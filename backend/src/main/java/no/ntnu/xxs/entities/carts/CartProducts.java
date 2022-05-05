package no.ntnu.xxs.entities.carts;

import no.ntnu.xxs.product.Product;

import javax.persistence.*;

/**
 * This class represents
 */
@Entity
@Table(name = "cart_products")
public class CartProducts
{
    @EmbeddedId
    CartProductsKey id;

    @ManyToOne
    @MapsId("cartID")
    @JoinColumn(name = "cart_id")
    private Cart cart;

    @ManyToOne
    @MapsId("productID")
    @JoinColumn(name = "product_id")
    private Product product;

    @Column(name = "product_size")
    private String productSize;
    @Column(name = "product_color")
    private String productColor;


    /**
     * Empty constructor
     */
    public CartProducts(){}

    public CartProductsKey getId() {
        return id;
    }

    public void setId(CartProductsKey id) {
        this.id = id;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public String getProductSize() {
        return productSize;
    }

    public void setProductSize(String productSize) {
        this.productSize = productSize;
    }

    public String getProductColor() {
        return productColor;
    }

    public void setProductColor(String productColor) {
        this.productColor = productColor;
    }
}
