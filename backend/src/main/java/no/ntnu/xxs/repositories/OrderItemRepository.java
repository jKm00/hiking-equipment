package no.ntnu.xxs.repositories;

import no.ntnu.xxs.entities.OrderItem;
import org.springframework.data.repository.CrudRepository;

public interface OrderItemRepository extends CrudRepository<OrderItem, Long> {
}
