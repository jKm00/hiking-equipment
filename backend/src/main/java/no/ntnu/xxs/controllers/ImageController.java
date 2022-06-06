package no.ntnu.xxs.controllers;

import no.ntnu.xxs.entities.product.Image;
import no.ntnu.xxs.services.ProductService;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

/**
 * Controller for image handling endpoints
 */
@RestController
@RequestMapping("/api/images")
@CrossOrigin
public class ImageController {
    @Autowired
    ProductService imageService;

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PostMapping("/add/{productId}")
    /**
     * Adds an image to the database
     * 
     * @param multipartFile the image(s) which are to be added
     * @return HTTP response, OK for success, BAD_REQUEST for failure
     */
    public ResponseEntity<String> upload(@PathVariable Long productId,
            @RequestParam("fileContent") List<MultipartFile> multipartFile) {
        ResponseEntity<String> response = null;
        try {
            for (MultipartFile file : multipartFile) {
                imageService.save(file, productId);
            }
            response = new ResponseEntity<>(HttpStatus.OK);

        } catch (Exception e) {
            response = new ResponseEntity<String>("Image not saved", HttpStatus.BAD_REQUEST);
        }
        return response;
    }

    /**
     * Return image content from the database
     * 
     * @param id ID of the product to find images for
     * @return Image content (and correct content type) or NOT FOUND
     */
    @GetMapping("/{id}")
    public List<Image> get(@PathVariable Long id) {
        // ResponseEntity<List<byte[]>> response;
        List<Image> image;

        try {
            image = imageService.getAllImagesByProductId(id);
        } catch (InvocationTargetException e) {
            image = null;
        }

        return image;
    }


    /**
     * Returns a thumbnail for the product with the id given
     * @param id the id of the product to get the thumbnail for
     * @return 200 OK with the image if successful, 404 NOT FOUND if
     * no thumbnail was found for the product with the id given
     */
    @GetMapping("/thumbnail/{id}")
    public ResponseEntity<?> getThumbnail(@PathVariable Long id) {
        try {
            return new ResponseEntity<>(imageService.getAllImagesByProductId(id).get(0), HttpStatus.OK);
        } catch (InvocationTargetException | IndexOutOfBoundsException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    /**
     * Delete image content from the database
     * 
     * @param id ID of the image to delete
     * @return HTTP OK on success, NOT FOUND when image not found
     */
    @DeleteMapping("/delete/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        ResponseEntity<String> response;
        if (imageService.delete(id)) {
            response = ResponseEntity.ok("");
        } else {
            response = new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
        return response;
    }
}