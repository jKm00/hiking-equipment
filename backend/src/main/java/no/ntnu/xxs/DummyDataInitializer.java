package no.ntnu.xxs;

import no.ntnu.xxs.product.Product;
import no.ntnu.xxs.product.ProductRepository;
import no.ntnu.xxs.product.details.ProductDetail;
import no.ntnu.xxs.product.details.ProductDetailRepository;
import no.ntnu.xxs.product.entry.ProductEntry;
import no.ntnu.xxs.product.entry.ProductEntryRepository;
import no.ntnu.xxs.role.Role;
import no.ntnu.xxs.role.RoleRepository;
import no.ntnu.xxs.user.User;
import no.ntnu.xxs.user.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * A class which initializes some data in the database, when the web application start
 */
@Component
public class DummyDataInitializer implements ApplicationListener<ApplicationReadyEvent> {
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private ProductDetailRepository productDetailRepository;
    @Autowired
    private ProductEntryRepository productEntryRepository;

    private final Logger logger = LoggerFactory.getLogger("DummyInit");

    @Override
    public void onApplicationEvent(ApplicationReadyEvent event) {
        if (isDataImported()) {
            logger.info("Data already exists! Not importing again...");
            return;
        }

        logger.info("Importing dummy data...");

        // Create and save a product
        Product boots = new Product("Boots", "Winter boots", 399.9f, "boot", "unisex");
        Product sweater = new Product("Sweater", "Winter sweater", 1200.0f, "sweater", "male");
        productRepository.save(boots);
        productRepository.save(sweater);

        productDetailRepository.save(new ProductDetail("Good for your feet", boots));
        productDetailRepository.save(new ProductDetail("Very warm", boots));
        productDetailRepository.save(new ProductDetail("Comfy", sweater));
        productDetailRepository.save(new ProductDetail("Slim-fit", sweater));

        ProductEntry largeSweater = new ProductEntry(sweater, "large", "military green", 50);
        ProductEntry mediumSweater = new ProductEntry(sweater, "medium","military green", 25);
        productEntryRepository.save(largeSweater);
        productEntryRepository.save(mediumSweater);

        // Create an admin user and one default user
        Role admin = new Role("ADMIN");
        Role user = new Role("USER");

        roleRepository.save(admin);
        roleRepository.save(user);

        User adam = new User("Adam", "Jensen", "adam@gmail.com", "Adam123", "Norway", "1302", "Langehus", "Grensegata 89");
        User carl = new User("Carl", "Hansen", "carl@gmail.com", "Carl123", "Norway", "1884", "Trondheim", "Kongens gate 12");

        adam.addRole(admin);
        adam.addRole(user);
        carl.addRole(user);

        userRepository.save(adam);
        userRepository.save(carl);

        logger.info("Finished initializing data...");
    }

    private boolean isDataImported() {
        return productRepository.count() > 0;
    }
}
