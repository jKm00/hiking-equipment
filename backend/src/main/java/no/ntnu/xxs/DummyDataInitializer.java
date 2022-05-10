package no.ntnu.xxs;


import no.ntnu.xxs.entities.product.Color;
import no.ntnu.xxs.entities.product.Discount;
import no.ntnu.xxs.entities.product.Product;
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

import java.util.LinkedHashSet;
import java.util.Optional;
import java.util.Set;

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
    private DiscountRepository discountRepository;

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
            carl.addRole(user);

            roleRepository.save(user);
            roleRepository.save(admin);

            userRepository.save(adam);
            userRepository.save(carl);

            logger.info("Finished initializing data...");
        } else {
            logger.info("Data already imported...");
        }
    }
}
