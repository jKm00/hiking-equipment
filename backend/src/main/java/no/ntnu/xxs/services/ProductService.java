package no.ntnu.xxs.services;

import no.ntnu.xxs.entities.product.Color;
import no.ntnu.xxs.entities.product.Product;
import no.ntnu.xxs.entities.product.ProductDetail;
import no.ntnu.xxs.entities.product.Size;
import no.ntnu.xxs.exception.ProductAlreadyExistException;
import no.ntnu.xxs.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import no.ntnu.xxs.entities.product.Image;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Service;

import java.awt.*;
import java.util.*;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private ColorRepository colorRepository;
    @Autowired
    private SizeRepository sizeRepository;
    @Autowired
    private ProductDetailRepository productDetailRepository;
    @Autowired
    private ImageRepository imageRepository;

    /**
     * Return a list of all products stored in the application state
     * @return a list of all products
     */
    public List<Product> getAllProducts() {
        return StreamSupport.stream(this.productRepository.findAll().spliterator(), false).collect(Collectors.toList());
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
    public void addProduct(Product product, List<String> colors, List<String> sizes, List<String> details, List<Image> images) throws ProductAlreadyExistException {
        for (String colorValue : colors) {
            Color color = this.colorRepository.findOneByColor(colorValue);
            if (color == null) {
                color = new Color(colorValue);
                this.colorRepository.save(color);
            }
            product.addColor(color);
        }

        for (String sizeValue : sizes) {
            Size size = this.sizeRepository.findOneBySize(sizeValue);
            if (size == null) {
                size = new Size(sizeValue);
                this.sizeRepository.save(size);
            }
            product.addSize(size);
        }

        for (Image imageValue : images) {
            Image image = new Image(imageValue.getData(), imageValue.getContentType());
            this.imageRepository.save(image);
            product.addImage(image);
        }

        this.productRepository.save(product);

        for (String detailValue : details) {
            ProductDetail detail = new ProductDetail(detailValue, product);
            this.productDetailRepository.save(detail);
        }
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
}
