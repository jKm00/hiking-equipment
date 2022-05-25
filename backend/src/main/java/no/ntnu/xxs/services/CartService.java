package no.ntnu.xxs.services;

import no.ntnu.xxs.entities.cart.CartItem;
import no.ntnu.xxs.repositories.CartItemRepository;
import no.ntnu.xxs.repositories.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

public class CartService {

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private CartItemRepository cartItemRepository;


    //kan du se over joakim
    public List<CartItem> getAllCartItems(){
        return StreamSupport.stream(this.cartItemRepository.findAll().spliterator(), false).collect(Collectors.toList());
    }

    public void addCartItemToCart(Long id){

    }

    public void addCartItem(long productId, String productName, float productPrice, String productCategory, String productSex, float discount, String color, String size, int quantity){

    }

    public void removeItemFromCart(Long id){

    }

    public void findCartItemByName(){

    }

    public void incrementCartItemAmount(Long id){

    }

    public void decrementCartItemAmount(Long id){

    }
}

