package no.ntnu.xxs.repositories;

import no.ntnu.xxs.entities.Order;
import no.ntnu.xxs.entities.product.Product;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface OrderRepository extends CrudRepository<Order, Long> {

    @Query(value = " SELECT * FROM orders WHERE user_id = ?", nativeQuery = true)
    List<Order> findAllOrdersByUserId(Long id);


}
