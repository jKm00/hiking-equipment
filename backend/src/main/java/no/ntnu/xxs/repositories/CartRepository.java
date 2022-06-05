package no.ntnu.xxs.repositories;

import no.ntnu.xxs.entities.cart.Cart;
import no.ntnu.xxs.entities.cart.CartItem;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

/**
 * Repository interface for accessing Cart data in the database.
 */
public interface CartRepository extends CrudRepository<Cart, Long> {
}
