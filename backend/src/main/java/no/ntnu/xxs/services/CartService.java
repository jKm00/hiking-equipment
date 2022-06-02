package no.ntnu.xxs.services;

import no.ntnu.xxs.dto.AddCartItemRequest;
import no.ntnu.xxs.entities.cart.Cart;
import no.ntnu.xxs.entities.cart.CartItem;
import no.ntnu.xxs.exception.CartItemAlreadyExistsException;
import no.ntnu.xxs.exception.CartItemNotFoundException;
import no.ntnu.xxs.exception.CartNotFoundException;
import no.ntnu.xxs.exception.QuantityBelowZeroException;
import no.ntnu.xxs.repositories.CartItemRepository;
import no.ntnu.xxs.repositories.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class CartService {

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private CartItemRepository cartItemRepository;



    public Cart getCart(Long id){
        return this.cartRepository.findByUserId(id);
    }


    public void addCartItemToCart(Long userID, Long itemID) throws CartNotFoundException, CartItemNotFoundException {
        String errorMsg;
        if (getCart(userID) == null) {
            errorMsg = "UserId is null";
            throw new IllegalArgumentException(errorMsg);
        }
        if (getCartItem(itemID) == null) {
            errorMsg = "ItemId is null";
            throw new IllegalArgumentException(errorMsg);
        }
        if (getCart(userID).equals("")) {
            errorMsg = "UserId can't be empty";
            throw new IllegalArgumentException(errorMsg);
        }
        if (getCartItem(itemID).equals("")) {
            errorMsg = "ItemId can't be empty";
            throw new IllegalArgumentException(errorMsg);
        }
        else {
            if (!getCart(userID).equals(userID)) {
                errorMsg = "The Inputted user id does not match any user id in the database";
                throw new CartNotFoundException(errorMsg);
            }
            if (!getCartItem(itemID).equals(itemID)) {
                errorMsg = "The Inputted cart item id does not match any cart item id in the database";
                throw new CartItemNotFoundException(errorMsg);
            }

            else if (getCart(userID).equals(userID) && getCartItem(itemID).equals(itemID)) {
                Cart cart = getCart(userID);
                if (findCartItemByName(itemID, userID) == getCartItem(itemID))
                {
                    incrementCartItemAmountByAmount(itemID, userID, 1);
                    cartRepository.save(cart);
                }
                cart.addCartItem(this.cartItemRepository.findByCartItemById(itemID));
                cartRepository.save(cart);
            }
        }
    }

    public void addCartItem(AddCartItemRequest itemDetails) throws CartItemAlreadyExistsException {
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
        cartItemRepository.save(cartItem);
    }

    public void removeItemFromCart(Long userID, Long itemID) throws CartNotFoundException, CartItemNotFoundException, QuantityBelowZeroException {
        String errorMsg;
        if (getCart(userID) == null) {
            errorMsg = "UserId is null";
            throw new IllegalArgumentException(errorMsg);
        }
        if (getCartItem(itemID) == null) {
            errorMsg = "ItemId is null";
            throw new IllegalArgumentException(errorMsg);
        }
        if (getCart(userID).equals("")) {
            errorMsg = "UserId can't be empty";
            throw new IllegalArgumentException(errorMsg);
        }
        if (getCartItem(itemID).equals("")) {
            errorMsg = "ItemId can't be empty";
            throw new IllegalArgumentException(errorMsg);
        }
        else {
            //er rekkefølgen her riktig på .equals ?
            if (!getCart(userID).equals(userID)) {
                errorMsg = "The Inputted user id does not match any user id in the database";
                throw new CartNotFoundException(errorMsg);
            }
            if (!getCartItem(itemID).equals(itemID)) {
                errorMsg = "The Inputted cart item id does not match any cart item id in the database";
                throw new CartItemNotFoundException(errorMsg);
            }

            else if (getCart(userID).equals(userID) && getCartItem(itemID).equals(itemID)) {
                Cart cart = getCart(userID);
                if (findCartItemByName(itemID, userID) == getCartItem(itemID))
                {
                    decrementCartItemAmountByAmount(itemID, userID, 1);
                    cartRepository.save(cart);
                }
                cart.removeCartItem(this.cartItemRepository.findByCartItemById(itemID));
                cartRepository.save(cart);
            }
        }
    }

    public CartItem getCartItem(Long id){
        return this.cartItemRepository.findByCartItemById(id);
    }
    public CartItem findCartItemByName(Long id, String cartItemName){return this.cartItemRepository.findCartItemByName(cartItemName, id);}

    public CartItem findCartItemByName(Long itemID, Long userID) {
        return this.cartItemRepository.findUserCartItemByCartItemById(itemID, userID);
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


    public void incrementCartItemAmount(Long itemID, Long userID) throws CartNotFoundException, CartItemNotFoundException {
        String errorMsg;
        if (getCart(userID) == null) {
                errorMsg = "UserId is null";
                throw new IllegalArgumentException(errorMsg);
        }
        if (getCartItem(itemID) == null) {
            errorMsg = "ItemId is null";
            throw new IllegalArgumentException(errorMsg);
        }
        if (getCart(userID).equals("")) {
            errorMsg = "UserId can't be empty";
            throw new IllegalArgumentException(errorMsg);
        }
        if (getCartItem(itemID).equals("")) {
            errorMsg = "ItemId can't be empty";
            throw new IllegalArgumentException(errorMsg);
        }
        else {
            if (!getCart(userID).equals(userID)) {
                errorMsg = "The Inputted user id does not match any user id in the database";
                throw new CartNotFoundException(errorMsg);
            }
            if (!getCartItem(itemID).equals(itemID)) {
                errorMsg = "The Inputted cart item id does not match any cart item id in the database";
                throw new CartItemNotFoundException(errorMsg);
            }

            else if (getCart(userID).equals(userID) && getCartItem(itemID).equals(itemID)) {
                CartItem cartItem = this.cartItemRepository.findUserCartItemByCartItemById(itemID, userID);
                cartItem.incrementQuantity();
                cartItemRepository.save(cartItem);
            }
        }
    }

    public void decrementCartItemAmount(Long itemID, Long userID) throws QuantityBelowZeroException, CartItemNotFoundException, CartNotFoundException {
        String errorMsg;
        if (getCart(userID) == null) {
            errorMsg = "UserId is null";
            throw new IllegalArgumentException(errorMsg);
        }
        if (getCartItem(itemID) == null) {
            errorMsg = "ItemId is null";
            throw new IllegalArgumentException(errorMsg);
        }
        if (getCart(userID).equals("")) {
            errorMsg = "UserId can't be empty";
            throw new IllegalArgumentException(errorMsg);
        }
        if (getCartItem(itemID).equals("")) {
            errorMsg = "ItemId can't be empty";
            throw new IllegalArgumentException(errorMsg);
        } else {
            if (!getCart(userID).equals(userID)) {
                errorMsg = "The Inputted user id does not match any user id in the database";
                throw new CartNotFoundException(errorMsg);
            }
            if (!getCartItem(itemID).equals(itemID)) {
                errorMsg = "The Inputted cart item id does not match any cart item id in the database";
                throw new CartItemNotFoundException(errorMsg);
            } else if (getCart(userID).equals(userID) && getCartItem(itemID).equals(itemID)) {
                CartItem cartItem = this.cartItemRepository.findUserCartItemByCartItemById(itemID, userID);
                cartItem.decrementQuantity();
                cartItemRepository.save(cartItem);
            }
        }
    }
     */

    public void incrementCartItemAmountByAmount(Long itemID, Long userID, int incrementAmount) throws CartNotFoundException, CartItemNotFoundException, IllegalArgumentException {
        String errorMsg;
        if (getCart(userID) == null) {
            errorMsg = "UserId is null";
            throw new IllegalArgumentException(errorMsg);
        }
        if (getCartItem(itemID) == null) {
            errorMsg = "ItemId is null";
            throw new IllegalArgumentException(errorMsg);
        }
        if (getCart(userID).equals("")) {
            errorMsg = "UserId can't be empty";
            throw new IllegalArgumentException(errorMsg);
        }
        if (getCartItem(itemID).equals("")) {
            errorMsg = "ItemId can't be empty";
            throw new IllegalArgumentException(errorMsg);
        }
        else {
            if (!getCart(userID).equals(userID)) {
                errorMsg = "The Inputted user id does not match any user id in the database";
                throw new CartNotFoundException(errorMsg);
            }
            if (!getCartItem(itemID).equals(itemID)) {
                errorMsg = "The Inputted cart item id does not match any cart item id in the database";
                throw new CartItemNotFoundException(errorMsg);
            }

            else if (getCart(userID).equals(userID) && getCartItem(itemID).equals(itemID)) {
                CartItem cartItem = findCartItemByName(itemID, userID);
                if (incrementAmount < 1 ) {
                    incrementAmount = 1 ;
                    cartItem.incrementQuantity(incrementAmount);
                }
                else {
                    cartItem.incrementQuantity(incrementAmount);
                }
                cartItemRepository.save(cartItem);
            }
        }
    }



    public void decrementCartItemAmountByAmount(Long itemID, Long userID, int decrementAmount) throws QuantityBelowZeroException, CartItemNotFoundException, CartNotFoundException {
        String errorMsg;
        if (getCart(userID) == null) {
            errorMsg = "UserId is null";
            throw new IllegalArgumentException(errorMsg);
        }
        if (getCartItem(itemID) == null) {
            errorMsg = "ItemId is null";
            throw new IllegalArgumentException(errorMsg);
        }
        if (getCart(userID).equals("")) {
            errorMsg = "UserId can't be empty";
            throw new IllegalArgumentException(errorMsg);
        }
        if (getCartItem(itemID).equals("")) {
            errorMsg = "ItemId can't be empty";
            throw new IllegalArgumentException(errorMsg);
        }
        else {
            if (!getCart(userID).equals(userID)) {
                errorMsg = "The Inputted user id does not match any user id in the database";
                throw new CartNotFoundException(errorMsg);
            }
            if (!getCartItem(itemID).equals(itemID)) {
                errorMsg = "The Inputted cart item id does not match any cart item id in the database";
                throw new CartItemNotFoundException(errorMsg);
            }

            else if (getCart(userID).equals(userID) && getCartItem(itemID).equals(itemID)) {
                CartItem cartItem = findCartItemByName(itemID, userID);
                if (cartItem.getQuantity() < 1) {
                    errorMsg = "Item amount can't be less than 1";
                    throw new QuantityBelowZeroException(errorMsg);
                }
                if (decrementAmount < 1 ) {
                    decrementAmount = 1 ;
                    cartItem.decrementQuantity(decrementAmount);
                }
                else {
                    cartItem.decrementQuantity(decrementAmount);
                }
                cartItemRepository.save(cartItem);
            }
        }
    }
}

