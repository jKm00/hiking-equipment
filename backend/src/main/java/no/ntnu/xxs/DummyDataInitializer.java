package no.ntnu.xxs;

import no.ntnu.xxs.product.Product;
import no.ntnu.xxs.product.ProductRepository;
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
        productRepository.save(boots);

        logger.info("Finished initializing data...");
    }

    private boolean isDataImported() {
        return productRepository.count() > 0;
    }
}
