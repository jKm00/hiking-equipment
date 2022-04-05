package no.ntnu.xxs.product.entry;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProductEntryRepository extends CrudRepository<ProductEntry, Long> {
    // TODO: Only select color, size and quantity
    @Query(value = "SELECT * FROM product_entry WHERE product_id = ?", nativeQuery = true)
    List<ProductEntry> findByProductId(Integer id);
}
