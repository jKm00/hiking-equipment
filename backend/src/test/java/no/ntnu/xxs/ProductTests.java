package no.ntnu.xxs;

import no.ntnu.xxs.product.Product;
import no.ntnu.xxs.product.details.ProductDetail;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class ProductTests {
    /**
     * Testing creating a product works as intended
     */
    @Test
    public void testCreatingProduct() {
        Product product = new Product("Sweater", "Winter sweater", 399.9f, "sweater", "male");

        assertEquals("Sweater", product.getProductName());
        assertEquals("Winter sweater", product.getDescription());
        assertEquals(399.9f, product.getPrice());
        assertEquals("sweater", product.getCategory());
        assertEquals("male", product.getSex());
    }
}
