package no.ntnu.xxs.repositories;

import no.ntnu.xxs.entities.cart.Cart;
import no.ntnu.xxs.entities.cart.CartItem;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface CartRepository extends CrudRepository<Cart, Long> {

    @Query(value = "SELECT * FROM cart_item WHERE product_name = ? AND cart_id = ?", nativeQuery = true)
    CartItem findCartItemByName(String productName, long id);

    @Query(value = "SELECT * FROM carts WHERE user_id = ?", nativeQuery = true)
    Cart findByUserId(Long id);
}
