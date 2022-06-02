package no.ntnu.xxs.controllers;


import no.ntnu.xxs.dto.AddCartItemRequest;
import no.ntnu.xxs.entities.cart.Cart;
import no.ntnu.xxs.entities.cart.CartItem;
import no.ntnu.xxs.entities.product.Product;
import no.ntnu.xxs.exception.*;
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
            return new ResponseEntity<>("Cart item already exists", HttpStatus.CONFLICT);
        }

    }

    @PostMapping
    public ResponseEntity<?> addCartItemToCart(Long userID, Long itemID) {
        ResponseEntity<?> response;
        try {
            cartService.addCartItemToCart(userID, itemID);
            response = new ResponseEntity<>(HttpStatus.OK);
        } catch (CartItemNotFoundException e) {
            return new ResponseEntity<>("The Inputted user id does not match any user id in the database", HttpStatus.NOT_FOUND);
        } catch (CartNotFoundException e) {
            return new ResponseEntity<>("The Inputted cart item id does not match any cart item id in the database", HttpStatus.NOT_FOUND);
        }
        return response;
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


    @PatchMapping
    public ResponseEntity<?> incrementCartByItemAmount(@RequestBody long itemId, @RequestBody long userId,
    @RequestBody int incrementAmount) {
        ResponseEntity<?> response;
        try {
            cartService.incrementCartItemAmountByAmount(itemId, userId, incrementAmount);
            response = new ResponseEntity<>(HttpStatus.OK);
        } catch (CartItemNotFoundException e) {
            return new ResponseEntity<>("The Inputted user id does not match any user id in the database", HttpStatus.NOT_FOUND);
        } catch (CartNotFoundException e) {
            return new ResponseEntity<>("The Inputted cart item id does not match any cart item id in the database", HttpStatus.NOT_FOUND);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>("User id or item id is either null or empty", HttpStatus.BAD_REQUEST);
        }
        return response;
    }



    @PatchMapping
    public ResponseEntity<?> decrementCartByItemAmount(@RequestBody long itemId, @RequestBody long userId,
    @RequestBody int decrementAmount) throws CartItemNotFoundException, CartNotFoundException, QuantityBelowZeroException {
        ResponseEntity<?> response;
        try {
            cartService.decrementCartItemAmountByAmount(itemId, userId, decrementAmount);
            response = new ResponseEntity<>(HttpStatus.OK);
        } catch (CartItemNotFoundException e) {
            return new ResponseEntity<>("The Inputted user id does not match any user id in the database", HttpStatus.NOT_FOUND);
        } catch (CartNotFoundException e) {
            return new ResponseEntity<>("The Inputted cart item id does not match any cart item id in the database", HttpStatus.NOT_FOUND);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>("User id or item id is either null or empty", HttpStatus.BAD_REQUEST);
        } catch (QuantityBelowZeroException e) {
            cartService.removeItemFromCart(userId, itemId);
            return new ResponseEntity<>("Item amount cannot be decreased to less than 0, so the item has been removed from the cart", HttpStatus.BAD_REQUEST);
        }
        return response;
    }

}
