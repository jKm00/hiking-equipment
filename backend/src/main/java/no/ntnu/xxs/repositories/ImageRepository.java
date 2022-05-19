package no.ntnu.xxs.repositories;


import org.springframework.data.repository.CrudRepository;

import java.awt.*;

public interface ImageRepository extends CrudRepository<Image, Long> {

    Image findOneByImage(String image);
}
