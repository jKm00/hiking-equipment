package no.ntnu.xxs.repositories;

import no.ntnu.xxs.entities.cart.CartItem;
import no.ntnu.xxs.entities.product.Product;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface CartItemRepository extends CrudRepository<CartItem, Long> {
    @Query(value = "SELECT * FROM cart_item WHERE cart_id = ? AND product_id = ? AND product_color = ? AND product_size = ?", nativeQuery = true)
    Optional<CartItem> findSpecificCartItem(Long cartId, long productId, String color, String size);
}
