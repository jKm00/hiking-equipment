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
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/carts")
@CrossOrigin
public class CartController {

    @Autowired
    private CartService cartService;
    @Autowired
    private JwtUtil jwtUtil;

    /**
     * Returns a cart for the user in the jwt token sent as a header
     * @param authorization the jwt token of the user to get the cart for
     * @return a Http.OK with cart if successful, or Http.NOT_FOUND if no
     * cart was found
     */
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
    @PreAuthorize("hasRole('ROLE_USER')")
    public ResponseEntity<?> addCartItem(@RequestHeader("Authorization") String authorization, @RequestBody AddCartItemRequest requestBody) {
        String jwt = authorization.substring(7, authorization.length());
        Long userId = (long) jwtUtil.extractId(jwt);
        this.cartService.addCartItemToCart(userId, requestBody);
        return new ResponseEntity<>(HttpStatus.OK);
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
