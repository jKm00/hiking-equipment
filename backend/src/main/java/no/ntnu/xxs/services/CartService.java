package no.ntnu.xxs.services;

import no.ntnu.xxs.dto.AddCartItemRequest;
import no.ntnu.xxs.entities.cart.Cart;
import no.ntnu.xxs.entities.cart.CartItem;
import no.ntnu.xxs.entities.product.Product;
import no.ntnu.xxs.exception.QuantityBelowZeroException;
import no.ntnu.xxs.repositories.CartItemRepository;
import no.ntnu.xxs.repositories.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

public class CartService {

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private CartItemRepository cartItemRepository;



    public Cart getCart(Long id){
        return this.cartRepository.findByUserId(id);
    }


    public void addCartItemToCart(Long userID, Long itemID){
        Cart cart = getCart(userID);
        cart.addCartItem(this.cartItemRepository.findByCartItemById(itemID));
        cartRepository.save(cart);
    }

    public void addCartItem(AddCartItemRequest itemDetails){
        CartItem cartItem = new CartItem(
                itemDetails.getProductId(),
                itemDetails.getProductName(),
                itemDetails.getProductPrice(),
                itemDetails.getProductCategory(),
                itemDetails.getProductSex(),
                itemDetails.getDiscount(),
                itemDetails.getColor(),
                itemDetails.getSize(),
                itemDetails.getQuantity()
        );
    }

    public void removeItemFromCart(Long userID, Long itemID){
        Cart cart = getCart(userID);
        cart.removeCartItem(this.cartItemRepository.findByCartItemById(itemID));
        cartRepository.save(cart);
    }

    public void getCartItem(Long id){
        this.cartItemRepository.findByCartItemById(id);
    }
    public void findCartItemByName(Long id, String cartItemName){

        this.cartItemRepository.findCartItemByName(cartItemName, id);
    }

    /**


    public void incrementCartItemAmount(Long id){
        this.cartItemRepository.increment(id);
    }

    public void decrementCartItemAmount(Long id){
        this.cartItemRepository.decrement(id);
    }

    public void incrementCartItemAmountByAmount(int incrementAmount, Long id){
        this.cartItemRepository.incrementByAmount(incrementAmount, id);
    }

    public void decrementCartItemAmountByAmount(int decrementAmount, Long id){
        this.cartItemRepository.decrementByAmount(decrementAmount, id);
    }
     */

    public void incrementCartItemAmount(Long itemID, Long userID){
        CartItem cartItem = this.cartItemRepository.findUserCartItemByCartItemById(itemID, userID);
        cartItem.incrementQuantity();
        cartItemRepository.save(cartItem);
    }

    public void decrementCartItemAmount(Long itemID, Long userID) throws QuantityBelowZeroException {
        CartItem cartItem = this.cartItemRepository.findUserCartItemByCartItemById(itemID, userID);
        cartItem.decrementQuantity();
        cartItemRepository.save(cartItem);
    }

    public void incrementCartItemAmountByAmount(Long itemID, Long userID, int incrementamount){
        CartItem cartItem = this.cartItemRepository.findUserCartItemByCartItemById(itemID, userID);
        cartItem.incrementQuantity(incrementamount);
        cartItemRepository.save(cartItem);
    }

    public void decrementCartItemAmountByAmount(Long itemID, Long userID, int decrementamount) throws QuantityBelowZeroException {
        CartItem cartItem = this.cartItemRepository.findUserCartItemByCartItemById(itemID, userID);
        cartItem.decrementQuantity(decrementamount);
        cartItemRepository.save(cartItem);
    }
}

