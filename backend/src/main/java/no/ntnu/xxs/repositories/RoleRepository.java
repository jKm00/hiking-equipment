package no.ntnu.xxs.repositories;

import no.ntnu.xxs.entities.user.Role;
import org.springframework.data.repository.CrudRepository;

/**
 * Repository interface for accessing Role data in the database.
 */
public interface RoleRepository extends CrudRepository<Role, Integer> {
    Role findOneByName(String roleName);

}
