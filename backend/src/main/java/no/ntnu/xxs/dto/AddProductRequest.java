package no.ntnu.xxs.dto;

import java.util.List;

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

    private List<String> imageStrings;

    public AddProductRequest(String productName, String description, float price, String category, String sex,
                             boolean featured, float discount, List<String> colors, List<String> sizes,
                             List<String> details, List<String> imageStrings) {
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
        this.imageStrings=imageStrings;
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

    public List<String> getImageStrings() {
        return imageStrings;
    }

    public void setImageStrings(List<String> imageBlob) {
        this.imageStrings = imageBlob;
    }
}
