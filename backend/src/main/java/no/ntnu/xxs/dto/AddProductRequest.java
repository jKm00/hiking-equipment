package no.ntnu.xxs.dto;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

public class AddProductRequest {
    private String productName;
    private String description;
    private float price;
    private String category;
    private String sex;
    private String colors;
    private String sizes;

    public AddProductRequest(String productName, String description, float price, String category, String sex, String colors, String sizes) {
        this.productName = productName;
        this.description = description;
        this.price = price;
        this.category = category;
        this.sex = sex;
        this.colors = colors;
        this.sizes = sizes;
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

    public String getColors() {
        return colors;
    }

    public List<String> getColorsAsList() {
        return Arrays.asList(this.colors.split(", "));
    }

    public void setColors(String colors) {
        this.colors = colors;
    }

    public String getSizes() {
        return sizes;
    }

    public List<String> getSizesAsList() {
        return Arrays.asList(this.sizes.split(", "));
    }

    public void setSizes(String sizes) {
        this.sizes = sizes;
    }
}
