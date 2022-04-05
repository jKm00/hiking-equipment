package no.ntnu.xxs;

import no.ntnu.xxs.role.Role;
import no.ntnu.xxs.user.User;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashSet;
import java.util.Set;

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
}
