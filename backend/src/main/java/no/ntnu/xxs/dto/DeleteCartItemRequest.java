package no.ntnu.xxs.dto;

public class DeleteCartItemRequest {
    private long cartItemId;

    public DeleteCartItemRequest() {}

    public DeleteCartItemRequest(long cartItemId) {
        this.cartItemId = cartItemId;
    }

    public long getCartItemId() {
        return cartItemId;
    }

    public void setCartItemId(long cartItemId) {
        this.cartItemId = cartItemId;
    }
}
