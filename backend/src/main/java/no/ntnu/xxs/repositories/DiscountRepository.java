package no.ntnu.xxs.repositories;

import no.ntnu.xxs.entities.product.Discount;
import org.springframework.data.repository.CrudRepository;

public interface DiscountRepository extends CrudRepository<Discount, Long> {
}
