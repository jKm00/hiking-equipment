package no.ntnu.xxs.repositories;

import no.ntnu.xxs.entities.cart.CartItem;
import no.ntnu.xxs.entities.product.Product;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CartItemRepository extends CrudRepository<CartItem, Long> {

    @Query(value = "SELECT * FROM cart_item WHERE product_name = ? AND cart_id = ?", nativeQuery = true)
    CartItem findCartItemByName(String productName, long id);

    @Query(value = "UPDATE cart_item SET quantity = quantity + 1 WHERE cartitem_id = ? ", nativeQuery = true)
    void increment(long id);

    @Query(value = "UPDATE cart_item SET quantity = ? WHERE cartitem_id = ? ", nativeQuery = true)
    void incrementByAmount(int incrementAmount, long id);

    @Query(value = "UPDATE cart_item SET quantity = quanity - 1 WHERE cartitem_id = ? ", nativeQuery = true)
    void decrement(long id);

    @Query(value = "UPDATE cart_item SET quantity = ? WHERE cartitem_id = ? ", nativeQuery = true)
    void decrementByAmount(int decrementAmount, long id);

    @Query(value = "SELECT * FROM cart_item WHERE id = ?", nativeQuery = true)
    CartItem findByCartItemById(long id);
}
