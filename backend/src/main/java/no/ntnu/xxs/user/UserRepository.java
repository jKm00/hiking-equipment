package no.ntnu.xxs.user;

import org.springframework.data.repository.CrudRepository;

/**
 * Repository interface for accessing User data in the database.
 */
public interface UserRepository extends CrudRepository<User, Long> {
}
