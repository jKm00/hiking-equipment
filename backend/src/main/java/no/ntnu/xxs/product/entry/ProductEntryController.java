package no.ntnu.xxs.product.entry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/product-entries")
public class ProductEntryController {
    @Autowired
    private ProductEntryRepository productEntryRepository;

    /**
     * Get a list of all product entries
     * @return a list of all product entries
     */
    @GetMapping
    public List<ProductEntry> getAll() {
        return (List<ProductEntry>) this.productEntryRepository.findAll();
    }

    /**
     * Get a list of all product entries for one specific product
     * @param id the id of the product you want to retrieve the entries for
     * @return a list of all product entries for the product with the id given
     */
    @GetMapping("/{id}")
    public List<ProductEntry> getEntriesByProductId(@PathVariable Integer id) {
        return this.productEntryRepository.findByProductId(id);
    }
}
