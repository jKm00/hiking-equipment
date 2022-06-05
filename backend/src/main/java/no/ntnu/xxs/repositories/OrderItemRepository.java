package no.ntnu.xxs.repositories;

import no.ntnu.xxs.entities.OrderItem;
import org.springframework.data.repository.CrudRepository;

/**
 * Repository interface for accessing Order item data in the database.
 */
public interface OrderItemRepository extends CrudRepository<OrderItem, Long> {
}
