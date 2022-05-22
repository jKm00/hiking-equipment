package no.ntnu.xxs.controllers;

import no.ntnu.xxs.entities.product.Image;
import no.ntnu.xxs.services.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

/**
 * Controller for image handling endpoints
 */
@RestController
@CrossOrigin
public class ImageController {
    @Autowired
    ImageService imageService;

    @PostMapping("/images")
    public ResponseEntity<String> upload(@RequestParam("fileContent") MultipartFile multipartFile) {
        System.out.println("Ddd");
        ResponseEntity<String> response = null;
        long imageId = imageService.save(multipartFile);
        if (imageId > 0) {
            response = new ResponseEntity<>("" + imageId, HttpStatus.OK);
        } else {
            response = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return response;
    }

    /**
     * Return image content from the database
     * @param id ID of the image to locate
     * @return Image content (and correct content type) or NOT FOUND
     */
    @GetMapping("/images/{id}")
    public ResponseEntity<byte[]> get(@PathVariable Integer id) {
        ResponseEntity<byte[]> response;
        Image image = imageService.getById(id);
        if (image != null) {
            response = ResponseEntity.ok()
                    .header(HttpHeaders.CONTENT_TYPE, image.getContentType())
                    .body(image.getData());
        } else {
            response = new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
        return response;
    }

    /**
     * Delete image content from the database
     * @param id ID of the image to delete
     * @return HTTP OK on success, NOT FOUND when image not found
     */
    @DeleteMapping("/images/{id}")
    public ResponseEntity<String> delete(@PathVariable Integer id) {
        ResponseEntity<String> response;
        if (imageService.delete(id)) {
            response = ResponseEntity.ok("");
        } else {
            response = new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
        return response;
    }
}