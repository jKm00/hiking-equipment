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
        Optional<User> existingUser = userRepository.findUserByEmail("admin@gmail.com");

        if (existingUser.isEmpty()) {
            logger.info("Importing dummy data...");

            User adminUser = new User("admin", "adminsen", "admin@gmail.com", "$2a$10$D/UnWX1uXdvYViqMRSa.p.nROCXeSg9pT/gQ1Oc401xi97WliiCBS", "Norway", "6004", "Ålesund", "Øvre strandgate 2");

            Role user = new Role("ROLE_USER");
            Role admin = new Role("ROLE_ADMIN");
            adminUser.addRole(user);
            adminUser.addRole(admin);
            adminUser.setCart(new Cart(adminUser));

            roleRepository.save(user);
            roleRepository.save(admin);

            userRepository.save(adminUser);

            logger.info("Finished initializing data...");
        } else {
            logger.info("Data already imported...");
        }
    }
}
