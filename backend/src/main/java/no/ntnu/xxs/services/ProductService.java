package no.ntnu.xxs.services;

import no.ntnu.xxs.entities.product.Color;
import no.ntnu.xxs.entities.product.Product;
import no.ntnu.xxs.entities.product.Size;
import no.ntnu.xxs.exception.ProductAlreadyExistException;
import no.ntnu.xxs.repositories.ColorRepository;
import no.ntnu.xxs.repositories.ProductRepository;
import no.ntnu.xxs.repositories.SizeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private ColorRepository colorRepository;
    @Autowired
    private SizeRepository sizeRepository;

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
    public Product getProductById(Long id) {
        Product productFound = null;
        Optional<Product> result = this.productRepository.findById(id);
        if (result.isPresent()) {
            productFound = result.get();
        }
        return productFound;
    }

    /**
     * Adds a product to the database. If the product already exists,
     * an exception is thrown.
     * @param product the product to add.
     * @param colors a list of colors available for the product described as string
     * @param sizes a list of sized available for the product described as string
     * @throws ProductAlreadyExistException if the product already exists
     */
    public void addProduct(Product product, List<String> colors, List<String> sizes) throws ProductAlreadyExistException {
        product.setColors(this.createColorSet(colors));
        product.setSizes(this.createSizeSet(sizes));

        Optional<Product> result = this.productRepository.findById(product.getId());
        if (result.isEmpty()) {
            this.productRepository.save(product);
        } else {
            throw new ProductAlreadyExistException("Product already in database");
        }
    }

    /**
     * Creates a set of sizes that can be applied to a product
     * @param sizes a list of string that described the sizes
     * @return a set of sizes
     */
    private Set<Size> createSizeSet(List<String> sizes) {
        Set<Size> sizeSet = new LinkedHashSet<>();
        for (String size : sizes) {
            Size sizeFound = this.sizeRepository.findOneBySize(size);
            if (sizeFound == null) {
                sizeFound = new Size(size);
                this.sizeRepository.save(sizeFound);
            }
            sizeSet.add(sizeFound);
        }
        return sizeSet;
    }

    /**
     * Tries to delete a product from the repository
     * @param id the id of the product to delete
     * @return {@code true} if product is deleted, {@code false} otherwise
     * // TODO: fix deletion of product added directly from dummy-data-initializer
     */
    public boolean deleteProduct(Long id) {
        boolean deleted = false;
        if (this.getProductById(id) != null) {
            this.productRepository.deleteById(id);
            deleted = true;
        }
        return deleted;
    }

    /**
     * Creates a set of colors that can be applied to a product
     * @param colors a list of string that described the colors
     * @return a set of colors
     */
    private Set<Color> createColorSet(List<String> colors) {
        Set<Color> colorSet = new LinkedHashSet<>();
        for (String color : colors) {
            Color colorFound = this.colorRepository.findOneByColor(color);
            if (colorFound == null) {
                colorFound = new Color(color);
                this.colorRepository.save(colorFound);
            }
            colorSet.add(colorFound);
        }
        return colorSet;
    }
}
