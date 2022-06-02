package no.ntnu.xxs.controllers;


import no.ntnu.xxs.dto.AddCartItemRequest;
import no.ntnu.xxs.entities.cart.Cart;
import no.ntnu.xxs.entities.cart.CartItem;
import no.ntnu.xxs.entities.product.Product;
import no.ntnu.xxs.exception.CartItemAlreadyExistsException;
import no.ntnu.xxs.exception.EmailAlreadyInUseException;
import no.ntnu.xxs.exception.ProductAlreadyExistException;
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

    //se over. jeg er usikker om den vil ta inn id-en fra user og bruke den på user i query-en
    // eller om den vil ta inn id-en fra cart og bruke den på user i query-en.
    //btw be han også dobbeltsjekke om mappingen er sånn vi vil ha den.
    //hvilke metoder trenger exceptions og hvilke metoder holder det med if setninger som produserer responseEntities
    @GetMapping
    public ResponseEntity<Cart> getCart(@RequestBody long id) {
        ResponseEntity<Cart> response;
        Cart cart = this.cartService.getCart(id);
        if (cart == null) {
            response = new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            response = new ResponseEntity<Cart>(cart, HttpStatus.OK);
        }
        return response;
    }

    @GetMapping
    public ResponseEntity<CartItem> getCartItem(@RequestBody long id) {
        ResponseEntity<CartItem> response;
        CartItem cartItem = this.cartService.getCartItem(id);
        if (cartItem == null) {
            response = new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            response = new ResponseEntity<CartItem>(cartItem, HttpStatus.OK);
        }
        return response;
    }

/**
    @PostMapping("/add")
    public ResponseEntity<?> addCartItem(@RequestBody AddCartItemRequest requestBody) {
        try {
            this.cartService.addCartItem(
                    new CartItem(
                            requestBody.getProductId(),
                            requestBody.getProductName(),
                            requestBody.getProductPrice(),
                            requestBody.getProductCategory(),
                            requestBody.getProductSex(),
                            requestBody.getDiscount(),
                            requestBody.getColor(),
                            requestBody.getSize(),
                            requestBody.getQuantity()
                    ));
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (ProductAlreadyExistException e) {
            return new ResponseEntity<>("Product already exists", HttpStatus.CONFLICT);
        }
    }
 */

    @PostMapping("/add")
    public ResponseEntity<?> addCartItem(@RequestBody AddCartItemRequest requestBody) {
        try {
            this.cartService.addCartItem(requestBody);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (CartItemAlreadyExistsException e) {
            return new ResponseEntity<>("Product already exists", HttpStatus.CONFLICT);
        }
    }

    @PatchMapping
    public ResponseEntity<CartItem> incrementCartItemAmount(@RequestBody long itemId, @RequestBody long userId) {
        //trenger denne en responseEntity?
        if (getCart(userId).equals(userId) && getCartItem(itemId).equals(itemId)) {
            this.cartService.incrementCartItemAmount(itemId, userId);
        }
        if (cartItem == null) {
            response = new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            response = new ResponseEntity<CartItem>(cartItem, HttpStatus.OK);
        }
        return response;
    }

    @PatchMapping
    public ResponseEntity<CartItem> incrementCartByItemAmount(@RequestBody long itemId, @RequestBody long userId,
      @RequestBody int incrementAmount) {
        //trenger denne en responseEntity?
        this.cartService.incrementCartItemAmountByAmount(itemId, userId, incrementAmount);
    }

    @PatchMapping
    public ResponseEntity<CartItem> decrementCartItemAmount(@RequestBody long itemId, @RequestBody long userId) {
        //trenger denne en responseEntity?
        this.cartService.incrementCartItemAmount(itemId, userId);
    }

    @PatchMapping
    public ResponseEntity<CartItem> decrementCartByItemAmount(@RequestBody long itemId, @RequestBody long userId,
                                                              @RequestBody int decrementAmount) {
        //trenger denne en responseEntity?
        this.cartService.incrementCartItemAmountByAmount(itemId, userId, decrementAmount);
    }

}
