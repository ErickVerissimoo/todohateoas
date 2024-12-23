package com.todohateoas.todohateoas.config;

import static org.springframework.security.config.Customizer.withDefaults;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import com.todohateoas.todohateoas.service.CustomUserDetailsService;

import lombok.RequiredArgsConstructor;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {
  
    private final CustomUserDetailsService service;
    @Bean
    public SecurityFilterChain filter(HttpSecurity http) throws Exception{
        http.authorizeHttpRequests().requestMatchers("/public/**", "/public/cadastro").permitAll().anyRequest().authenticated().and().httpBasic(withDefaults()).csrf().disable();

        return http.build();
    
    }
    @Bean
    public AuthenticationManager authenticationManager(HttpSecurity http) throws Exception {
        AuthenticationManagerBuilder authenticationManagerBuilder = 
            http.getSharedObject(AuthenticationManagerBuilder.class);
        authenticationManagerBuilder.userDetailsService(service).passwordEncoder( getEncoder());
        return authenticationManagerBuilder.build();
    }

  @Bean
  public PasswordEncoder getEncoder(){
    return new BCryptPasswordEncoder();
  }
}
