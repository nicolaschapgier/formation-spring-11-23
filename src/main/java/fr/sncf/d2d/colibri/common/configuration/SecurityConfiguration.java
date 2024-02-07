package fr.sncf.d2d.colibri.common.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import fr.sncf.d2d.colibri.users.persistence.UsersRepository;

@Configuration
@EnableMethodSecurity
public class SecurityConfiguration {

    private final UsersRepository usersRepository;

    public SecurityConfiguration(UsersRepository usersRepository){
        this.usersRepository = usersRepository;
    }
    
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
            // WARNING ! ne jamais faire en production.
            .csrf(csrf -> csrf.disable())
            
            .httpBasic(Customizer.withDefaults())
            .userDetailsService(this.usersRepository)
            .authorizeHttpRequests(requests -> requests
                .requestMatchers(HttpMethod.GET, "/colis").authenticated()
                .requestMatchers(HttpMethod.POST, "/colis").hasAnyRole("ADMIN", "DELIVERY_PERSON")
                .anyRequest().authenticated()
            )
            .build();
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
