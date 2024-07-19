package com.JDBL63.MiniProjectDigitalLibrary2.Configuration;

import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration

@EnableWebSecurity

public class SecurityConfiguration {
    @Bean

    public UserDetailsService getuserDetailsService(PasswordEncoder passwordEncoder)
    {
        UserDetails admin= User.withUsername("divya")
                .password(passwordEncoder.encode("harsh"))
                .roles("ADMIN")
                .build();
        UserDetails user=User.withUsername("ush")
                .password(passwordEncoder.encode("kaa"))
                .roles("USER")
                .build();
        return new InMemoryUserDetailsManager(admin,user);
    }
    @Bean
    public PasswordEncoder getPasswordEncoder()
    {
        return new BCryptPasswordEncoder();
    }
    @Bean
    public SecurityFilterChain getSecurityFilterChain(HttpSecurity http) throws Exception
    {
        return http
                .csrf(csrf-> csrf.disable())
                .authorizeHttpRequests(
                        auth ->
                                auth.requestMatchers("/users/Allowedtoall").permitAll()
                                        .requestMatchers("/users/allowtoadmin").hasRole("ADMIN")
                                        .requestMatchers("/users/allowtouser").hasRole("USER")
                )
                .httpBasic(Customizer.withDefaults())
                .build();
    }

}
