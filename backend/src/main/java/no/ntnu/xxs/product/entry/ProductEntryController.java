package no.ntnu.xxs.product.entry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/product-entry")
public class ProductEntryController {
    @Autowired
    private ProductEntryRepository productEntryRepository;

    @GetMapping
    public List<ProductEntry> getAll() {
        return (List<ProductEntry>) this.productEntryRepository.findAll();
    }
}
