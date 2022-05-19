package no.ntnu.xxs.repositories;

import no.ntnu.xxs.entities.product.Product;
import org.springframework.data.repository.CrudRepository;

/**
 * Repository interface for accessing Product data from the database
 */
public interface ProductRepository extends CrudRepository<Product, Long> {
}
