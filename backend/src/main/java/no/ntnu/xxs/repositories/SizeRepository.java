package no.ntnu.xxs.repositories;

import no.ntnu.xxs.entities.product.Size;
import org.springframework.data.repository.CrudRepository;

/**
 * Repository interface for accessing User data in the database.
 */
public interface SizeRepository extends CrudRepository<Size, Long> {
    Size findOneBySize(String size);
}
