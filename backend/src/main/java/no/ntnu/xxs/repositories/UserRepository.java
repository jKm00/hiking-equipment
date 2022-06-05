package no.ntnu.xxs.repositories;

import no.ntnu.xxs.entities.cart.Cart;
import no.ntnu.xxs.entities.user.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

/**
 * Repository interface for accessing User data in the database.
 */
public interface UserRepository extends CrudRepository<User, Long> {
    Optional<User> findUserByEmail(String email);

    @Query(value = "SELECT cart_id FROM users WHERE id = ?", nativeQuery = true)
    Long findCartIdByUserId(Long id);
}
