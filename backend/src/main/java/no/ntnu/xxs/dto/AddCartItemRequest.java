package no.ntnu.xxs.dto;

public class AddCartItemRequest {

    private long productId;

    private String productName;

    private float productPrice;

    private String productCategory;

    private String productSex;

    private float discount;

    private String color;

    private String size;

    private int quantity;

    public AddCartItemRequest(long productId, String productName, float productPrice, String productCategory, String productSex, float discount, String color, String size, int quantity){
        this.productId = productId;
        this.productName = productName;
        this.productPrice = productPrice;
        this.productCategory = productCategory;
        this.productSex = productSex;
        this.discount = discount;
        this.color = color;
        this.size = size;
        this.quantity = quantity;
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

    public float getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(float productPrice) {
        this.productPrice = productPrice;
    }

    public String getProductCategory() {
        return productCategory;
    }

    public void setProductCategory(String productCategory) {
        this.productCategory = productCategory;
    }

    public String getProductSex() {
        return productSex;
    }

    public void setProductSex(String productSex) {
        this.productSex = productSex;
    }

    public float getDiscount() {
        return discount;
    }

    public void setDiscount(float discount) {
        this.discount = discount;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
