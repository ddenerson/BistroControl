package com.bistrocontrol.bistro_control.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import com.bistrocontrol.bistro_control.controller.MySimpleUrlAuthenticationHandler;

@Configuration
@EnableWebSecurity
public class UserSecurityConfig {
    
    @Bean
    SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.
        csrf(csrf -> csrf.disable())
        .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.ALWAYS))
        .authorizeHttpRequests(request ->  request
        .requestMatchers("/cliente/**").hasRole("USER")
        .requestMatchers("/admin/**").hasRole("ADMIN")
        .requestMatchers("/h2-console/**").permitAll()
        .requestMatchers("/images/**").permitAll()
        .requestMatchers("/css/**").permitAll()
        .requestMatchers("/js/**").permitAll()
        .requestMatchers("/cadastro").permitAll()
        .requestMatchers("/").denyAll()
        .anyRequest().authenticated());
        
        http.headers(headers -> headers.frameOptions(frame -> frame.disable())); // for h2database access during development

        http.formLogin(customize -> customize 
        .loginPage("/login")
        .usernameParameter("email")
        .successHandler(myAuthenticationSuccessHandler())
        .failureUrl("/login?error")
        .permitAll());

        http.logout( logout -> logout
        .logoutSuccessUrl("/login")
        .deleteCookies("JSESSIONID")
        .invalidateHttpSession(true)
        .permitAll());

        return http.build();
    }

    @Bean
    public AuthenticationSuccessHandler myAuthenticationSuccessHandler(){
        return new MySimpleUrlAuthenticationHandler();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
