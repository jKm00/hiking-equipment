package no.ntnu.xxs.repositories;

import no.ntnu.xxs.entities.product.ProductDetail;
import org.springframework.data.repository.CrudRepository;

public interface ProductDetailRepository extends CrudRepository<ProductDetail, Long> {
}
