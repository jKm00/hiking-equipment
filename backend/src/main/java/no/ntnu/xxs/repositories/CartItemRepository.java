package no.ntnu.xxs.repositories;

import no.ntnu.xxs.entities.cart.CartItem;
import org.springframework.data.repository.CrudRepository;

public interface CartItemRepository extends CrudRepository<CartItem, Long> {
}
