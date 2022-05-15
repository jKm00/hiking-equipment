package no.ntnu.xxs.repositories;

import no.ntnu.xxs.entities.product.ProductEntry;
import no.ntnu.xxs.keys.ProductEntryKey;
import org.springframework.data.repository.CrudRepository;

public interface ProductEntryRepository extends CrudRepository<ProductEntry, ProductEntryKey> {
}
