package no.ntnu.xxs;

import no.ntnu.xxs.role.Role;
import no.ntnu.xxs.user.User;
import no.ntnu.xxs.user.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class UserTests {

    @Test
    public void testCreatingUser() {
        User user = new User("Arne", "Nilsen", "Arne@nilsen.no", "Arne123", "Norway", "6004", "Ålesund", "Strandgata 10");
        user.addRole(new Role("ADMIN"));

        assertEquals("Arne", user.getFirstName());
    }
}
