package no.ntnu.xxs.services;

import no.ntnu.xxs.dto.AddCartItemRequest;
import no.ntnu.xxs.entities.cart.Cart;
import no.ntnu.xxs.entities.cart.CartItem;
import no.ntnu.xxs.entities.user.User;
import no.ntnu.xxs.exception.CartItemAlreadyExistsException;
import no.ntnu.xxs.exception.CartItemNotFoundException;
import no.ntnu.xxs.exception.CartNotFoundException;
import no.ntnu.xxs.exception.QuantityBelowZeroException;
import no.ntnu.xxs.repositories.CartItemRepository;
import no.ntnu.xxs.repositories.CartRepository;
import no.ntnu.xxs.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CartService {

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private CartItemRepository cartItemRepository;
    @Autowired
    private UserRepository userRepository;

    /**
     * Returns a cart for the user with id given as param
     * @param id the id of the user to find the cart for
     * @return a cart or null if no cart is found
     */
    public Cart getCart(Long id){
        Cart cart = null;
        Long cartId = this.getCartIdByUserId(id);
        if (cartId != null) {
            Optional<Cart> result = this.cartRepository.findById(cartId);
            if (result.isPresent()) {
                cart = result.get();
            }
        }
        return cart;
    }

    /**
     * Returns the cart id of the cart for the user specified in the params
     * @param userId the id of the user to find the cart id for
     * @return the id of the cart for the user
     */
    private Long getCartIdByUserId(Long userId) {
        return this.userRepository.findCartIdByUserId(userId);
    }

    /**
     * Adds a cart item to the cart of the user specified by the user id
     * @param userId the user id of the user to add a cart item to the cart for
     * @param cartItemDetails details about the product to add be added to the cart
     * @return true if successful, false otherwise
     */
    public void addCartItemToCart(Long userId, AddCartItemRequest cartItemDetails) {
        Long cartId = this.getCartIdByUserId(userId);
        // Check if cart item with same details already is added to cart
        Optional<CartItem> result = this.cartItemRepository.findSpecificCartItem(
                cartId,
                cartItemDetails.getProductId(),
                cartItemDetails.getColor(),
                cartItemDetails.getSize()
                );
        CartItem cartItem;
        // If so, increment the quantity
        if (result.isPresent()) {
            cartItem = result.get();
            cartItem.incrementQuantity();
            // Save cart item
            this.cartItemRepository.save(cartItem);
        } else {
            // If no, create a new cart item
            cartItem = new CartItem(
                    cartItemDetails.getProductId(),
                    cartItemDetails.getProductName(),
                    cartItemDetails.getProductPrice(),
                    cartItemDetails.getProductCategory(),
                    cartItemDetails.getProductSex(),
                    cartItemDetails.getDiscount(),
                    cartItemDetails.getColor(),
                    cartItemDetails.getSize(),
                    cartItemDetails.getQuantity()
            );
            // Get cart
            Cart cart = this.getCart(userId);
            // Add cart to cart item
            cartItem.setCart(cart);
            // Save cart item
            this.cartItemRepository.save(cartItem);
            // Add cart item to cart
            cart.addCartItem(cartItem);
            // Save cart
            this.cartRepository.save(cart);
        }
    }

    /**
     * Removes a product from the cart of the user specified
     * @param userId the id of the user to delete a product from that users cart
     * @param cartItemId the id of the cart item that should be removed from the cart
     * @throws CartNotFoundException
     * @throws CartItemNotFoundException
     * @throws QuantityBelowZeroException
     */
    public void removeItemFromCart(Long userId, Long cartItemId) throws CartItemNotFoundException {
        Optional<CartItem> result = this.cartItemRepository.findById(cartItemId);
        if (result.isPresent()) {
            CartItem cartItem = result.get();
            try {
                cartItem.decrementQuantity();
                this.cartItemRepository.save(cartItem);
            } catch (QuantityBelowZeroException e) {
                this.cartItemRepository.delete(cartItem);
                Cart cart = this.getCart(userId);
                cart.removeCartItem(cartItem);
                this.cartRepository.save(cart);
            }
        } else {
            throw new CartItemNotFoundException("Cart item was not found");
        }
    }
}

