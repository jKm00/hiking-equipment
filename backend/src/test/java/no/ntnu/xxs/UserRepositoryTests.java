package no.ntnu.xxs;

import no.ntnu.xxs.role.Role;
import no.ntnu.xxs.role.RoleRepository;
import no.ntnu.xxs.user.User;
import no.ntnu.xxs.user.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class UserRepositoryTests {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Test
    public void addUserToRepository() {
        Role admin = new Role("ADMIN");
        Role user = new Role("USER");
        roleRepository.save(admin);
        roleRepository.save(user);

        User arne = new User("Arne", "Nilsen", "Arne@nilsen.no", "Arne123", "Norway", "6004", "Ålesund", "Strandgata 10");
        arne.addRole(admin);
        arne.addRole(user);
        userRepository.save(arne);

        assertEquals(3, userRepository.count());
    }
}
