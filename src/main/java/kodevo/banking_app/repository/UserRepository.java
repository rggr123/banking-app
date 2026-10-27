package kodevo.banking_app.repository; // ⚠️ Change to match your package path

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

import kodevo.banking_app.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    
    // Finds a user in the database by their unique username
    Optional<User> findByUsername(String username);
}
