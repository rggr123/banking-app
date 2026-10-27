package kodevo.banking_app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

import kodevo.banking_app.entity.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    
    // Finds a role profile by its distinct name (e.g., "ROLE_USER")
    Optional<Role> findByName(String name);
}
