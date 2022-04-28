package no.ntnu.xxs.product;

import org.springframework.data.repository.CrudRepository;

/**
 * Repository interface for accessing Product data from the database
 */
public interface ProductRepository extends CrudRepository<Product, Long> {
}
