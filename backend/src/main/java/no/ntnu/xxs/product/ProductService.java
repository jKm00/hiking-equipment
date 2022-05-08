package no.ntnu.xxs.product;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    /**
     * Return a list of all products stored in the application state
     * @return a list of all products
     */
    public List<Product> getAllProducts() {
        return (List<Product>) this.productRepository.findAll();
    }

    /**
     * Returns a product from the application state with the same id
     * as given in param. If no product is found {@code null} is returned.
     * @param id the id of the product to get
     * @return an item with id as param
     */
    public Product getProductById(long id) {
        Product productFound = null;
        Optional<Product> result = this.productRepository.findById(id);
        if (result.isPresent()) {
            productFound = result.get();
        }
        return productFound;
    }

    public void addProduct(Product product) {
        Product productToAdd = new Product();
        BeanUtils.copyProperties(product, productToAdd);
        this.productRepository.save(productToAdd);
    }

    public void deleteProduct(long id) {
        this.productRepository.deleteById(id);
    }
}
