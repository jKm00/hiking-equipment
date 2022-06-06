package no.ntnu.xxs.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import no.ntnu.xxs.entities.product.Image;

public interface ImageRepository extends CrudRepository<Image, Long> {

    @Query(value = "SELECT * FROM image WHERE product_id = ?", nativeQuery = true)
    List<Image> findAllImages(Long id);
}