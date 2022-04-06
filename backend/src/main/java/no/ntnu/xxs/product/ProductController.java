package no.ntnu.xxs.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * REST API controller for product collection
 */
@RestController
@RequestMapping("/api/products")
public class ProductController {
    @Autowired
    private ProductService productService;

    /**
     * Returns a list of all products
     * @return a list of all products
     */
    @GetMapping
    @PreAuthorize("hasRole('USER')")
    public List<Product> getAllProducts() {
        return this.productService.getAllProducts();
    }

    /**
     * Returns an item with the id given in the URL
     * @param id the id of the item to get
     * @return an item with same id as given
     */
    @GetMapping("/{id}")
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<Product> getProductById(@PathVariable long id) {
        ResponseEntity<Product> response;
        Product product = this.productService.getProductById(id);
        if (product == null) {
            response = new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            response = new ResponseEntity<Product>(product, HttpStatus.OK);
        }
        return response;
    }
}
