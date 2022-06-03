package no.ntnu.xxs.repositories;

import no.ntnu.xxs.entities.product.Image;
import org.springframework.data.repository.CrudRepository;

public interface ImageRepository extends CrudRepository<Image, String> {
}
