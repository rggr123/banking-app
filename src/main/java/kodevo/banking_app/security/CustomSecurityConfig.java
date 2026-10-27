package kodevo.banking_app.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class CustomSecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/actuator/health").permitAll() // Acceso público
                .anyRequest().authenticated()                    // Todo lo demás protegido
            )
            .formLogin(form -> form.permitAll())
            .httpBasic(basic -> {}); // Útil si usas Postman o Thunder Client en VS Code

        return http.build();
    }
}
