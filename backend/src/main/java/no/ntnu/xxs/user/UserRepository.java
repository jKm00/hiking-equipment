package no.ntnu.xxs.user;

import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

/**
 * Repository interface for accessing User data in the database.
 */
public interface UserRepository extends CrudRepository<User, Long> {
  Optional<User> findUserByEmail(String email);
}
