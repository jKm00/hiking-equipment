package no.ntnu.xxs;

import no.ntnu.xxs.role.Role;
import no.ntnu.xxs.user.User;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class RoleTests {

    /**
     * Resting creating role
     */
    @Test
    public void testCreatingRole() {
        Role role = new Role("ADMIN");
        assertEquals("ADMIN", role.getRoleName());
    }

    /**
     * Testing adding users to a role
     */
    @Test
    public void addUserToRole() {
        Role role = new Role("ADMIN");
        User user = new User("Arne", "Nilsen", "Arne@nilsen.no", "Arne123", "Norway", "6004", "Ålesund", "Strandgata 10");
        role.addUser(user);
        assertEquals(1, role.getUsers().size());
    }

}
