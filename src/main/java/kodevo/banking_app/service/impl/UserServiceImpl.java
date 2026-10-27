package kodevo.banking_app.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import kodevo.banking_app.entity.Role;
import kodevo.banking_app.entity.User;
import kodevo.banking_app.repository.RoleRepository;
import kodevo.banking_app.repository.UserRepository;
import kodevo.banking_app.service.UserService;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    
    @Autowired
    private RoleRepository roleRepository; 

    @Autowired
    private PasswordEncoder passwordEncoder;

    /**
     * Registers a new user with an encrypted password and assigns a default ROLE_USER.
     */
    public User registerNewUser(String username, String rawPassword) {
        // Optional: Check if user already exists
        if (userRepository.findByUsername(username).isPresent()) {
            throw new RuntimeException("Error: Username is already taken!");
        }

        User user = new User();
        user.setUsername(username);
        
        // Encrypt password before saving it to the database
        user.setPassword(passwordEncoder.encode(rawPassword));

        // Fetch the standard customer role from the database
        Role userRole = roleRepository.findByName("ROLE_USER")
                .orElseThrow(() -> new RuntimeException("Error: Default system role 'ROLE_USER' not found. Ensure your data.sql script ran properly."));
        
        user.getRoles().add(userRole);

        return userRepository.save(user);
    }
}