package no.ntnu.xxs.repositories;

import org.springframework.data.repository.CrudRepository;

import no.ntnu.xxs.entities.product.Image;

public interface ImageRepository extends CrudRepository<Image, Long> {
}