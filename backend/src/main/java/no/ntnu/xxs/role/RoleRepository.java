package no.ntnu.xxs.role;

import org.springframework.data.repository.CrudRepository;

/**
 * Repository interface for accessing Role data in the database.
 */
public interface RoleRepository extends CrudRepository<Role, Long> {
}
