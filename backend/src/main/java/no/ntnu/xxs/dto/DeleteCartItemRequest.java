package no.ntnu.xxs.dto;

public class DeleteCartItemRequest {
    private long productId;

    public DeleteCartItemRequest(long productId) {
        this.productId = productId;
    }

    public long getProductId() {
        return productId;
    }

    public void setProductId(long productId) {
        this.productId = productId;
    }
}
