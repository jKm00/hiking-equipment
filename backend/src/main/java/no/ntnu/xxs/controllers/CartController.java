package no.ntnu.xxs.controllers;


import no.ntnu.xxs.entities.cart.Cart;
import no.ntnu.xxs.entities.product.Product;
import no.ntnu.xxs.services.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/carts")
@CrossOrigin
public class CartController {

    @Autowired
    private CartService cartService;

    //se over
    @GetMapping("/{id}")
    public ResponseEntity<Cart> getCart(@PathVariable long id) {
        ResponseEntity<Cart> response;
        Cart cart = this.cartService.getCart(id);
        if (cart == null) {
            response = new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            response = new ResponseEntity<Cart>(cart, HttpStatus.OK);
        }
        return response;
    }


}
