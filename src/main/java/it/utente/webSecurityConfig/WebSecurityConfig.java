package it.utente.webSecurityConfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import it.utente.crud.UserDetailsServiceImpl;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig  {

    @Bean
     UserDetailsService userDetailsService() {
        return new UserDetailsServiceImpl();
    }
     
    @Bean
     BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
     @Bean
     DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userDetailsService());
        authProvider.setPasswordEncoder(passwordEncoder());
         
        return authProvider;
    }
 
    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(
                auth -> auth.anyRequest().authenticated())
            .formLogin(login -> login.permitAll())
            .logout(logout -> logout.permitAll())
        ;
         
        return http.build();
    }   
 
}
