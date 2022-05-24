package no.ntnu.xxs.repositories;

import no.ntnu.xxs.entities.cart.Cart;
import org.springframework.data.repository.CrudRepository;

public interface CartRepository extends CrudRepository<Cart, Long> {
}
