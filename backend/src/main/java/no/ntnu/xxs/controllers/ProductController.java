package no.ntnu.xxs.controllers;

import no.ntnu.xxs.dto.AddProductRequest;
import no.ntnu.xxs.exception.ProductAlreadyExistException;
import no.ntnu.xxs.entities.product.Product;
import no.ntnu.xxs.services.ProductService;
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
@CrossOrigin
public class ProductController {
    @Autowired
    private ProductService productService;

    /**
     * Returns a list of all products
     * @return a list of all products
     */
    @GetMapping
    public List<Product> getAllProducts() {
        return this.productService.getAllProducts();
    }

    /**
     * Returns an item with the id given in the URL
     * @param id the id of the item to get
     * @return an item with same id as given
     */
    @GetMapping("/{id}")
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
    * HTTP POST request to /api/products. Tries to add product to database.
    * @param requestBody The body of the request containing the product to be added
    * @return Http.OK when product is added, or Http.CONFLICT if product
     * is already registered
    */
    @PostMapping("/add")
    /* TODO: make it only accessible for admin. Currently its accessible for any
        logged in users */
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<?> addProduct(@RequestBody AddProductRequest requestBody) {
        try {
            this.productService.addProduct(
                    new Product(
                            requestBody.getProductName(),
                            requestBody.getDescription(),
                            requestBody.getPrice(),
                            requestBody.getCategory(),
                            requestBody.getSex(),
                            requestBody.isFeatured(),
                            requestBody.getDiscount()),
                    requestBody.getColors(),
                    requestBody.getSizes(),
                    requestBody.getDetails(),
                    requestBody.getImages());
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (ProductAlreadyExistException e) {
            return new ResponseEntity<>("Product already exists", HttpStatus.CONFLICT);
        }
    }

    /**
     *  HTTP PUT request to /api/products/{id}
     * @param id The id of the product to be updated
     *
     */
    @DeleteMapping("/{id}")
    /* TODO: make it only accessible for admin. Currently its accessible for any
        logged in users */
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<?> deleteProduct(@PathVariable() Long id) {
        if (this.productService.deleteProduct(id)) {
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
}
