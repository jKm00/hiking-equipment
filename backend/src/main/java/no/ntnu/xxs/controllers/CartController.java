package no.ntnu.xxs.controllers;


import no.ntnu.xxs.dto.AddCartItemRequest;
import no.ntnu.xxs.entities.cart.Cart;
import no.ntnu.xxs.entities.cart.CartItem;
import no.ntnu.xxs.entities.product.Product;
import no.ntnu.xxs.exception.*;
import no.ntnu.xxs.security.JwtUtil;
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
    @Autowired
    private JwtUtil jwtUtil;

    //se over. jeg er usikker om den vil ta inn id-en fra user og bruke den på user i query-en
    // eller om den vil ta inn id-en fra cart og bruke den på user i query-en.
    //btw be han også dobbeltsjekke om mappingen er sånn vi vil ha den.
    //hvilke metoder trenger exceptions og hvilke metoder holder det med if setninger som produserer responseEntities
    @GetMapping
    public ResponseEntity<Cart> getCart(@RequestHeader("Authorization") String authorization) {
        ResponseEntity response;
        String jwt = authorization.substring(7, authorization.length());
        Cart cart = this.cartService.getCart((long) jwtUtil.extractId(jwt));
        if (cart == null) {
            response = new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            response = new ResponseEntity<>(cart, HttpStatus.OK);
        }
        return response;
    }

    @PostMapping
    public ResponseEntity<?> addCartItem(@RequestBody AddCartItemRequest requestBody) {
        try {
            this.cartService.addCartItem(requestBody);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (CartItemAlreadyExistsException e) {
            return new ResponseEntity<>("Cart item already exists", HttpStatus.CONFLICT);
        }

    }

    @DeleteMapping
    public ResponseEntity<?> removeCartItemFromCart(Long userID, Long itemID) {
        ResponseEntity<?> response;
        try {
            cartService.removeItemFromCart(userID, itemID);
            response = new ResponseEntity<>(HttpStatus.OK);
        } catch (CartItemNotFoundException e) {
            return new ResponseEntity<>("The Inputted user id does not match any user id in the database", HttpStatus.NOT_FOUND);
        } catch (CartNotFoundException e) {
            return new ResponseEntity<>("The Inputted cart item id does not match any cart item id in the database", HttpStatus.NOT_FOUND);
        } catch (QuantityBelowZeroException e) {
            return new ResponseEntity<>("Item amount cannot be decreased to less than 0, so the item has been removed from the cart", HttpStatus.BAD_REQUEST);
        }
        return response;
    }
}
