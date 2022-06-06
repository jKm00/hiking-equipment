package no.ntnu.xxs.repositories;

import no.ntnu.xxs.entities.product.ProductDetail;
import org.springframework.data.repository.CrudRepository;

/**
 * Repository interface for accessing Product details data in the database.
 */
public interface ProductDetailRepository extends CrudRepository<ProductDetail, Long> {
}
