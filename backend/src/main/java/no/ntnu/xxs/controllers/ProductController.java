package no.ntnu.xxs.controllers;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.Contact;
import no.ntnu.xxs.dto.AddProductRequest;
import no.ntnu.xxs.exception.ProductAlreadyExistException;
import no.ntnu.xxs.entities.product.Image;
import no.ntnu.xxs.entities.product.Product;
import no.ntnu.xxs.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

/**
 * REST API controller for product collection
 */
// TODO: Make product endpoint public. This is made private only for demo
// purposes

@RestController
@RequestMapping("/api/products")
@CrossOrigin
public class ProductController {
    private final String UNDEFINED = "undefined";
    @Autowired
    private ProductService productService;
    
    /**
    * Returns a list of all products with the attributes given.
    * @param sex the sex of the products to be returned
    * @param category the category of the products to be returned
    * @return a list of all products
    */

    @GetMapping
    @ApiOperation(value = "Returns all products with a given sex and category",
                notes = "Provide sex and categories to find all products within these categories",
                response = Contact.class)
    @CrossOrigin
    public List<Product> getProductsBySexAndCategory(@ApiParam(value = "Sex of the products a user is trying to find", required = true)
                                                         @RequestParam String sex,
                                                     @ApiParam(value = "Category of the products a user is trying to retrieve", required = true)
                                                     @RequestParam String category) {
        List<Product> products;
        if (sex.equals(UNDEFINED) && category.equals(UNDEFINED)) {
            products = this.productService.getAllProducts();
        } else if (sex.equals(UNDEFINED)) {
            products = this.productService.getProductsByCategory(category);
        } else if (category.equals(UNDEFINED)) {
            products = this.productService.getProductsBySex(sex);
        } else {
            products = this.productService.getProductsBySexAndCategory(sex, category);
        }
        return products;
    }

    /**
     * Returns a list of featured products
     * @return a list of freatured products
     */
    @GetMapping("/features")
    public List<Product> getFeaturedProducts() {
        return this.productService.getFeaturedProducts();
    }
    
    /**
    * Returns an item with the id given in the URL
    * @param id the id of the item to get
    * @return an item with same id as given
    */
    @GetMapping("/{id}")
    @ApiOperation(value = "Returns a product with a given product id",
            notes = "Provide the id of the product a user is trying to find",
            response = Contact.class)
    public ResponseEntity<Product> getProductById(@ApiParam(value = "id of the product that is to be retrieved")
                                                    @PathVariable long id) {
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
    @ApiOperation(value = "Adds a product to the database",
            notes = "provide a valid product to add it to the database",
            response = Contact.class)
    /* TODO: make it only accessible for admin. Currently its accessible for any
    logged in users */
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<?> addProduct(@ApiParam(value = "Product that is to be added to the database")
                                        @RequestBody AddProductRequest requestBody) {
        try {
            long productId = this.productService.addProduct(
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
                    requestBody.getDetails());
            return new ResponseEntity<>(productId, HttpStatus.OK);
        } catch (IOException e) {
            return new ResponseEntity<>("Something went wronh", HttpStatus.BAD_REQUEST);
        } catch (ProductAlreadyExistException e) {
            return new ResponseEntity<>("Product already exists", HttpStatus.CONFLICT);
        }
    }
    
    /**

    *  HTTP PUT request to /api/products/{id}
    * @param id The id of the product to be updated
    *
    */
    @DeleteMapping("/delete/{id}")
    @ApiOperation(value = "Deletes a product from the database",
            notes = "Provide the id of a product that is to be deleted from the database",
            response = Contact.class)
    /* TODO: make it only accessible for admin. Currently its accessible for any
    logged in users */

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<?> deleteProduct(@ApiParam(value = "Id of the product that is to be deleted from the database")
                                            @PathVariable() Long id) throws InvocationTargetException {
        if (this.productService.deleteProduct(id)) {
            this.productService.deleteAllImagesById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

/**
 * Searches for products with the given name
 * 
 * @param search of the product to search for
 * @return 
 */
    @GetMapping("/search/{name}")
    @ApiOperation(value = "The name of a product that is to be found",
            notes = "Provide a name of the product that is trying to be found",
            response = Contact.class)
    public List<Product> searchProducts(@ApiParam(value = "Name of the products that are to be found")
                                        @PathVariable String search) {
        return this.productService.searchProducts(search);


    }
}
