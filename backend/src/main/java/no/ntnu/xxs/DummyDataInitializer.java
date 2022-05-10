package no.ntnu.xxs;


import no.ntnu.xxs.entities.user.Role;
import no.ntnu.xxs.repositories.RoleRepository;
import no.ntnu.xxs.entities.user.User;
import no.ntnu.xxs.repositories.UserRepository;
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


        // Create an admin user and one default user
        Role admin = new Role("ROLE_ADMIN");
        Role user = new Role("ROLE_USER");

        roleRepository.save(admin);
        roleRepository.save(user);

        // Password = adam123
        User adminUser = new User("Adam", "Jensen", "adam@gmail.com", "$2a$10$Z1Hv5cq1uzscCA94L/GqgOOvNfQiEH8izQimZBTOCopLuF18Ggqg.", "Norway", "1302", "Langehus", "Grensegata 89");
        // Password = carl123
        User carl = new User("Carl", "Hansen", "carl@gmail.com", "$2a$10$bUi6E8PPgwlUhBszkEugw.Ma/exSzgXUhMZTf4Bf/SvcaWwonHKSO", "Norway", "1884", "Trondheim", "Kongens gate 12");

        adminUser.addRole(admin);
        adminUser.addRole(user);
        carl.addRole(user);

        userRepository.save(adminUser);
        userRepository.save(carl);

        logger.info("Finished initializing data...");
    }

    private boolean isDataImported() {
        return userRepository.count() > 0;
    }
}
