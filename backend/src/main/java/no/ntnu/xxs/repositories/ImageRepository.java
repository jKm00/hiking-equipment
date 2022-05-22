package no.ntnu.xxs.repositories;


import no.ntnu.xxs.entities.product.Image;
import org.springframework.data.repository.CrudRepository;

import java.awt.*;

public interface ImageRepository extends CrudRepository<Image, Integer> {
}
