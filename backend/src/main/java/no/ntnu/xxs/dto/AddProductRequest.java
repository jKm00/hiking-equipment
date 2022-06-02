package no.ntnu.xxs.dto;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.Base64;
import java.util.List;
import java.util.Set;
import no.ntnu.xxs.entities.product.Image;
import org.apache.tomcat.util.http.fileupload.FileUtils;

import javax.imageio.ImageIO;


public class AddProductRequest {
    private String productName;
    private String description;
    private float price;
    private String category;
    private String sex;
    private boolean featured;
    private float discount;
    private List<String> colors;
    private List<String> sizes;
    private List<String> details;
    private List<Image> images;

    public AddProductRequest(String productName, String description, float price, String category, String sex,
                             boolean featured, float discount, List<String> colors, List<String> sizes,
                             List<String> details, List<File> images) {
        this.productName = productName;
        this.description = description;
        this.price = price;
        this.category = category;
        this.sex = sex;
        this.featured = featured;
        this.discount = discount;
        this.colors = colors;
        this.sizes = sizes;
        this.details = details;
        this.images = convertToImage(images);
    }

    private List<Image> convertToImage(List<File> images){
        List<Image> convertedImages = Arrays.asList(new Image[images.size()]);
        for(int i=0;i< images.size();i++){
            File imageFile = images.get(i);
            String[] splitPath = imageFile.getPath().split(".");
            byte[] imageBytes = null;

            try {
                imageBytes = Files.readAllBytes(imageFile.toPath());
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

            Image image = new Image(imageBytes, splitPath[1]);
            convertedImages.add(image);
        }
        return convertedImages;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public List<String> getColors() {
        return colors;
    }

    public void setColors(List<String> colors) {
        this.colors = colors;
    }

    public List<String> getSizes() {
        return sizes;
    }

    public void setSizes(List<String> sizes) {
        this.sizes = sizes;
    }

    public boolean isFeatured() {
        return featured;
    }

    public void setFeatured(boolean featured) {
        this.featured = featured;
    }

    public float getDiscount() {
        return discount;
    }

    public void setDiscount(float discount) {
        this.discount = discount;
    }

    public List<String> getDetails() {
        return details;
    }

    public void setDetails(List<String> details) {
        this.details = details;
    }

    public List<Image> getImages() {
        return images;
    }

    public void setImages(List<Image> images) {
        this.images = images;
    }
}
