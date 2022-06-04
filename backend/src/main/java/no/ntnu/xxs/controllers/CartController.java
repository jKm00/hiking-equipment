package no.ntnu.xxs.controllers;


import no.ntnu.xxs.dto.AddCartItemRequest;
import no.ntnu.xxs.dto.DeleteCartItemRequest;
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
        Long userId = this.getUserIdFromJwt(authorization);
        Cart cart = this.cartService.getCart(userId);
        if (cart == null) {
            response = new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            response = new ResponseEntity<>(cart, HttpStatus.OK);
        }
        return response;
    }

    /**
     * Adds a product to the cart of the user with the same id as the on in the jwt token
     * @param authorization the jwt token of the user to add the product to the cart for
     * @param requestBody details about the product that should be saved to the cart
     * @return Http.OK product was successfully added to cart.
     */
    @PostMapping
    @PreAuthorize("hasRole('ROLE_USER')")
    public ResponseEntity<?> addCartItem(@RequestHeader("Authorization") String authorization, @RequestBody AddCartItemRequest requestBody) {
        Long userId = this.getUserIdFromJwt(authorization);
        this.cartService.addCartItemToCart(userId, requestBody);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    /**
     * Removed a product from the cart of the user that is specified in the jwt token sent as a header
     * of the request
     * @param authorization the header containing the jwt token for the user where a product should be
     *                      deleted from the users cart
     * @param requestBody a json object containing the cart item id of the cart item to be deleted
     * @return Http.OK if product was successfully delete, Http.NOT_FOUND otherwise
     */
    @DeleteMapping
    public ResponseEntity<?> removeCartItemFromCart(@RequestHeader("Authorization") String authorization, @RequestBody DeleteCartItemRequest requestBody) {
        Long userId = this.getUserIdFromJwt(authorization);
        ResponseEntity<?> response;
        try {
            this.cartService.removeItemFromCart(userId, requestBody.getCartItemId());
            response = new ResponseEntity<>(HttpStatus.OK);
        } catch (CartItemNotFoundException e) {
            return new ResponseEntity<>("No cart item with id " + requestBody.getCartItemId() + " was found in the users(" + userId + ") cart", HttpStatus.NOT_FOUND);
        }
        return response;
    }

    /**
     * Gets the user id from the jwt given
     * @param jwtHeader the jwt as its send with "Bearer jwt..."
     * @return the user id from the jwt
     */
    private long getUserIdFromJwt(String jwtHeader) {
        String jwt = jwtHeader.substring(7, jwtHeader.length());
        return (long) jwtUtil.extractId(jwt);
    }
}
