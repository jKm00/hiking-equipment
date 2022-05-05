package no.ntnu.xxs.entities;


import no.ntnu.xxs.entities.carts.Cart;
import no.ntnu.xxs.entities.carts.CartProductsKey;
import no.ntnu.xxs.product.Product;

import javax.persistence.*;

@Entity
@Table(name = "cart_item")
public class CartItem {

    @Id
    @GeneratedValue
    private long id;

    @OneToOne(mappedBy = "cartItem")
    private Product product;

    @ManyToOne
    @JoinColumn(name = "cart_item", referencedColumnName = "id")
    private Cart cart;

    @ManyToOne
    @JoinColumn(name = "item_color", referencedColumnName = "id")
    private Color color;

    @ManyToOne
    @JoinColumn(name = "item_size", referencedColumnName = "id")
    private Size size;

    @Column(name = "quantity")
    private int quantity;

}
