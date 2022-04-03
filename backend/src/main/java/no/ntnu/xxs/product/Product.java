package no.ntnu.xxs.product;

import no.ntnu.xxs.product.addons.Color;
import no.ntnu.xxs.product.addons.Discount;
import no.ntnu.xxs.product.addons.ProductDetail;
import no.ntnu.xxs.product.addons.Size;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Set;

/**
 * Represents a product that is soled in the web-application
 */
@Entity
public class Product {
    @Id
    @GeneratedValue
    private long productId;
    private String productName;
    private String description;
    private float price;
    private int productCount;
    private String category;
    private String sex;

    // TODO: Add many to many relation between product and color
    private Set<Color> colors;
    // TODO: Add many to many relation between product and sizes
    private Set<Size> sizes;

    // TODO: Add many to one relation between product and product-details
    private Set<ProductDetail> productDetails;

    // TODO: Add one to one relation and create discount classes
    private Discount discount;

    public Product() {}

    public Product(String productName, String description, float price, int productCount, String category, String sex) {
        this.productName = productName;
        this.description = description;
        this.price = price;
        this.productCount = productCount;
        this.category = category;
        this.sex = sex;
    }

    public long getProductId() {
        return productId;
    }

    public void setProductId(long productId) {
        this.productId = productId;
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

    public int getProductCount() {
        return productCount;
    }

    public void setProductCount(int productCount) {
        this.productCount = productCount;
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

    public Set<Color> getColors() {
        return colors;
    }

    public void setColors(Set<Color> colors) {
        this.colors = colors;
    }

    /**
     * Add a color to a product
     * @param color the color to add
     */
    public void addColor(Color color) {
        this.colors.add(color);
    }

    /**
     * Remove a color from a product
     * @param color the color to remove
     */
    public void removeColor(Color color) {
        this.colors.remove(color);
    }

    public Set<Size> getSizes() {
        return sizes;
    }

    public void setSizes(Set<Size> sizes) {
        this.sizes = sizes;
    }

    /**
     * Add a size to the product
     * @param size the size to add
     */
    public void addSize(Size size) {
        this.sizes.add(size);
    }

    /**
     * Remove a size from the product
     * @param size the size to remove
     */
    public void removeSize(Size size) {
        this.sizes.remove(size);
    }

    public Set<ProductDetail> getProductDetails() {
        return productDetails;
    }

    public void setProductDetails(Set<ProductDetail> productDetails) {
        this.productDetails = productDetails;
    }

    /**
     * Add a product detail to the product
     * @param detail the detail to add
     */
    public void addProductDetail(ProductDetail detail) {
        this.productDetails.add(detail);
    }


    /**
     * Remove a product detail from the product
     * @param detail the detail to remove
     */
    public void removeProductDetail(ProductDetail detail) {
        this.productDetails.remove(detail);
    }

    public Discount getDiscount() {
        return discount;
    }

    public void setDiscount(Discount discount) {
        this.discount = discount;
    }
}
