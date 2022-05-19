package no.ntnu.xxs.repositories;

import no.ntnu.xxs.entities.product.Color;
import org.springframework.data.repository.CrudRepository;

/**
 * Repository interface for accessing User data in the database.
 */
public interface ColorRepository extends CrudRepository<Color, Long> {
    Color findOneByColor(String color);
}
