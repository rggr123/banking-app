package kodevo.banking_app.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import kodevo.banking_app.entity.User;
import kodevo.banking_app.repository.UserRepository;

public class CustomUserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository; // <-- This is the instance variable

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // 1. Fetching your CUSTOM database user entity
         User user = userRepository.findByUsername(username)
            .orElseThrow(() -> new UsernameNotFoundException("User not found"));

        List<SimpleGrantedAuthority> authorities = user.getRoles().stream()
                .map(role -> new SimpleGrantedAuthority(role.getName()))
                .collect(Collectors.toList());

        // 2. ⚠️ CRITICAL: Ensure this returns the ORG.SPRINGFRAMEWORK Security implementation
        return new org.springframework.security.core.userdetails.User(
                user.username(),
                user.getPassword(),
                authorities
        );
    }
}
