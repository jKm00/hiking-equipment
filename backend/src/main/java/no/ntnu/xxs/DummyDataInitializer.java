package no.ntnu.xxs;


import no.ntnu.xxs.entities.cart.Cart;
import no.ntnu.xxs.entities.product.Color;
import no.ntnu.xxs.entities.product.Product;
import no.ntnu.xxs.entities.product.ProductDetail;
import no.ntnu.xxs.entities.product.Size;
import no.ntnu.xxs.entities.user.Role;
import no.ntnu.xxs.repositories.*;
import no.ntnu.xxs.entities.user.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import java.util.Optional;

/**
 * A class which initializes some data in the database, when the web application start
 */
@Component
public class DummyDataInitializer implements ApplicationListener<ApplicationReadyEvent> {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private ColorRepository colorRepository;
    @Autowired
    private SizeRepository sizeRepository;
    @Autowired
    private ProductDetailRepository productDetailRepository;

    private final Logger logger = LoggerFactory.getLogger("DummyInit");

    @Override
    public void onApplicationEvent(ApplicationReadyEvent event) {
        Optional<User> existingUser = userRepository.findUserByEmail("adam@gmail.com");

        if (existingUser.isEmpty()) {
            logger.info("Importing dummy data...");

            // Password = adam123
            User adam = new User("Adam", "Jensen", "adam@gmail.com", "$2a$10$Z1Hv5cq1uzscCA94L/GqgOOvNfQiEH8izQimZBTOCopLuF18Ggqg.", "Norway", "1302", "Langhus", "Grensegata 89");
            // Password = carl123
            User carl = new User("Carl", "Hansen", "carl@gmail.com", "$2a$10$bUi6E8PPgwlUhBszkEugw.Ma/exSzgXUhMZTf4Bf/SvcaWwonHKSO", "Norway", "1884", "Trondheim", "Kongens gate 12");

            Role user = new Role("ROLE_USER");
            Role admin = new Role("ROLE_ADMIN");
            adam.addRole(user);
            adam.addRole(admin);
            adam.setCart(new Cart(adam));
            carl.addRole(user);
            carl.setCart(new Cart(carl));

            roleRepository.save(user);
            roleRepository.save(admin);

            userRepository.save(adam);
            userRepository.save(carl);

            // Add product
            Color black = new Color("Black");
            Color blue = new Color("Blue");

            Size medium = new Size("M");
            Size large = new Size("L");

            Product sweater = new Product("Sweater", "Winter Sweater", 399f, "sweater", "women", false, 0f);
            sweater.addColor(black);
            sweater.addColor(blue);
            sweater.addSize(medium);
            sweater.addSize(large);

            Product boots = new Product("Boots", "Hiking boots", 799f, "boots", "unisex", false, 0f);
            boots.addColor(black);
            boots.addColor(blue);
            boots.addSize(medium);
            boots.addSize(large);

            colorRepository.save(black);
            colorRepository.save(blue);

            sizeRepository.save(medium);
            sizeRepository.save(large);

            productRepository.save(sweater);
            productRepository.save(boots);

            ProductDetail detailOne = new ProductDetail("This is a nice sweater", sweater);
            ProductDetail detailTwo = new ProductDetail("Very warm and cozy", sweater);

            productDetailRepository.save(detailOne);
            productDetailRepository.save(detailTwo);

            logger.info("Finished initializing data...");
        } else {
            logger.info("Data already imported...");
        }
    }
}
