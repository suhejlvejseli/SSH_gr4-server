package com.sshproject.bookstore.config;

import jakarta.servlet.Filter;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfiguration {
    private final JwtAuthenticationFilter jwtAuthFilter;

    // Here after implementing it we add an private final AuthorizationFilter authorizationFilter
    private final AuthorizationFilter authorizationFilter;
    private final AuthenticationProvider authenticationProvider;



    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf(AbstractHttpConfigurer::disable)
                        .authorizeHttpRequests(request -> request.requestMatchers("/api/v1/auth/**", "/swagger-ui/**","/v2/api-docs",
                                        "/v3/api-docs","/v3/api-docs/**","/swagger-resources","/swagger-resources/**","/configuration/ui",
                                        "/configuration/security","/webjars/**","/swagger-ui.html")
                                .permitAll().anyRequest().authenticated())
                                .sessionManagement(manager->manager.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                                        .authenticationProvider(authenticationProvider)
                                                .addFilterBefore(jwtAuthFilter,UsernamePasswordAuthenticationFilter.class)
                .addFilterAfter(authorizationFilter, JwtAuthenticationFilter.class);


        return http.build();
    }
}
