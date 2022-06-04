package no.ntnu.xxs.repositories;

import no.ntnu.xxs.entities.product.Product;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Repository interface for accessing Product data from the database
 */
public interface ProductRepository extends CrudRepository<Product, Long> {
    @Query(value = "SELECT * FROM products WHERE (sex = ? OR sex = 'unisex') AND category = ?", nativeQuery = true)
    List<Product> findAllBySexAndCategory(String sex, String category);

    @Query(value = "SELECT * FROM products WHERE sex = ? OR sex = 'unisex'", nativeQuery = true)
    List<Product> findAllBySex(String sex);

    @Query(value = "SELECT * FROM products WHERE category = ?", nativeQuery = true)
    List<Product> findAllByCategory(String category);

    @Query(value = "SELECT * FROM products WHERE product_name iLIKE %?%", nativeQuery = true)
    List<Product> findAllByName(String name);
}
