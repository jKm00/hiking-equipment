package no.ntnu.xxs.services;

import no.ntnu.xxs.entities.product.Color;
import no.ntnu.xxs.entities.product.Image;
import no.ntnu.xxs.entities.product.Product;
import no.ntnu.xxs.entities.product.ProductDetail;
import no.ntnu.xxs.entities.product.Size;
import no.ntnu.xxs.exception.ProductAlreadyExistException;
import no.ntnu.xxs.repositories.ColorRepository;
import no.ntnu.xxs.repositories.ImageRepository;
import no.ntnu.xxs.repositories.ProductDetailRepository;
import no.ntnu.xxs.repositories.ProductRepository;
import no.ntnu.xxs.repositories.SizeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.*;
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

    /**
     * Return a list of all products stored in the application state
     * 
     * @return a list of all products
     */
    public List<Product> getAllProducts() {
        return StreamSupport.stream(this.productRepository.findAll().spliterator(), false).collect(Collectors.toList());
    }

    /**
     * Returns a product from the application state with the same id
     * as given in param. If no product is found {@code null} is returned.
     * 
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
     * 
     * @param product the product to add.
     * @param colors  a list of colors available for the product described as string
     * @param sizes   a list of sized available for the product described as string
     * @throws ProductAlreadyExistException if the product already exists
     * @throws IOException
     */
    public void addProduct(Product product, List<String> colors, List<String> sizes, List<Image> images,
            List<String> details)
            throws ProductAlreadyExistException, IOException {
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

        for (Image image : images) {
            Image imageToAdd = new Image(image.getData(), image.getContentType(), image.getFileName());
            this.imageRepository.save(imageToAdd);
        }

        this.productRepository.save(product);

        for (String detailValue : details) {
            ProductDetail detail = new ProductDetail(detailValue, product);
            this.productDetailRepository.save(detail);
        }

    }

    /**
     * Tries to delete a product from the repository
     * 
     * @param id the id of the product to delete
     * @return {@code true} if product is deleted, {@code false} otherwise
     *         // TODO: fix deletion of product added directly from
     *         dummy-data-initializer
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
     * Returns a list of products with the sex and the category as specified
     * 
     * @param sex      the sex of the product
     * @param category the category of the product
     * @return a list of products
     */
    public List<Product> getProductsBySexAndCategory(String sex, String category) {
        return this.productRepository.findAllBySexAndCategory(sex, category);
    }

    /**
     * Returns all products with the same sex as attribute as given in the param
     * 
     * @param sex the sex attribute of the products to get
     * @return a list of products with the same sex as attribute as given.
     */
    public List<Product> getProductsBySex(String sex) {
        return this.productRepository.findAllBySex(sex);
    }

    /**
     * Returns all products with the same category as attribute as given in the
     * param
     * 
     * @param category the category attribute of the products to get
     * @return a list of products with the same category as attribute as given.
     */
    public List<Product> getProductsByCategory(String category) {
        return this.productRepository.findAllByCategory(category);
    }

    private final Logger logger = LoggerFactory.getLogger(this.getClass().getSimpleName());

    @Autowired
    private ImageRepository imageRepository;

    /**
     * Save the provided image to the storage
     *
     * @param images The image file data, as received from the web client
     * @return ID of the newly created image or -1 on error
     */

    public Long save(MultipartFile images) {
        if (!isImage(images)) {
            return (long) -1;
        }
        Image image = null;
        try {
            image = new Image(images.getBytes(), getFileExtension(images),
                    images.getContentType());
            imageRepository.save(image);
        } catch (IOException e) {
            logger.error("Could not store image: " + e.getMessage());
            return (long) -1;
        }

        return image.getId();
    }

    /**
     * Save the provided images to the storage
     * 
     * @param List<Image> images The image file data, as received from the
     *                    web client
     * @return
     * 
     *         /*
     *         public List<Image> save(List<Image> images) {
     *         for (Image image : images) {
     *         try {
     *         imageRepository.save(image);
     *         } catch (Exception e) {
     *         logger.error("Could not store image: " + e.getMessage());
     * 
     *         }
     *         }
     *         return images;
     *         }
     */

    /**
     * Check if the given file is an image
     * 
     * @param images File to check
     * @return True if it looks like image, false if not
     */
    public static boolean isImage(MultipartFile images) {
        return images != null && isImageContentType(images.getContentType());
    }

    /** Types of content which are considered images */
    private static final String[] IMAGE_CONTENT_TYPES = { "image/jpg", "image/png", "image/jpeg", "image/webp",
            "image/svg+xml" };

    /**
     * Checks if a given content-type of a file is an image-type
     * 
     * @param contentType The content type to check
     * @return True if it is an image-tuype, false if it is not
     */
    private static boolean isImageContentType(String contentType) {
        return Arrays.asList(IMAGE_CONTENT_TYPES).contains(contentType);
    }

    /**
     * Get extension of the file (.jpg, .png, ...)
     *
     * @param imageData Image data as received from the web client
     * @return Image file extension
     */
    private static String getFileExtension(MultipartFile imageData) {
        String filename = imageData.getOriginalFilename();
        if (filename == null)
            return "";
        int dotPosition = filename.lastIndexOf('.');
        if (dotPosition > 0) {
            return filename.substring(dotPosition + 1);
        } else {
            return "";
        }
    }

    /**
     * Get an image from database
     * 
     * @param id ID of the image
     * @return Image or null if none found
     */
    public Image getById(Long id) {
        return imageRepository.findById(id).orElse(null);
    }

    /**
     * Delete an image from database
     * 
     * @param id ID of the image to delete
     * @return True when deleted, false on error
     */
    public boolean delete(Long id) {
        boolean deleted = false;
        if (imageRepository.findById(id).isPresent()) {
            imageRepository.deleteById(id);
            deleted = true;
        }
        return deleted;
    }

}
