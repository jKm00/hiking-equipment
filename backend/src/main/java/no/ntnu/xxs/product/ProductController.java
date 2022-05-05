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
// TODO: Make product endpoint public. This is made private only for demo purposes
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
    // TODO: remove this in deployment
    @CrossOrigin
    public List<Product> getAllProducts() {
        return this.productService.getAllProducts();
    }

    /**
     * Returns an item with the id given in the URL
     * @param id the id of the item to get
     * @return an item with same id as given
     */
    @GetMapping("/{id}")
    @CrossOrigin
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


            
        /**
        * HTTP POST request to /api/products
        * @param product The product to be added
        * @return Http.OK with the added product, or Http.UNAUTHORIZED
        * @throws ProductAlreadyExistException if the product already exists
        */
        
        @PostMapping("/api/products")
        @PreAuthorize("hasRole('ADMIN')")
        @CrossOrigin
        public ResponseEntity<?> addProduct(@RequestBody Product product) {
            return ResponseEntity.ok(product);
            
        }

        /**
         *  HTTP PUT request to /api/products/{id}
         * @param id The id of the product to be updated
         * 
         */
        @DeleteMapping("/api/products/{id}")
        @PreAuthorize("hasRole('ADMIN')")
        @CrossOrigin
        public ResponseEntity<?> deleteProduct(@PathVariable long id) {
            return ResponseEntity.ok(id);
        }


}
