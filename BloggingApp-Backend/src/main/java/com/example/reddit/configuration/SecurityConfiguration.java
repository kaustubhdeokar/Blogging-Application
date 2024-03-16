package com.example.reddit.configuration;

import com.example.reddit.security.JwtAuthFilter;
import com.example.reddit.security.JwtAuthenticationEntryPoint;
import com.example.reddit.service.UserDetailsServiceImpl;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.CorsConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.thymeleaf.TemplateEngine;

@Configuration
@EnableWebSecurity
@AllArgsConstructor
@OpenAPIDefinition
public class SecurityConfiguration {

    private JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;
    private UserDetailsServiceImpl userDetailsService;
    private JwtAuthFilter jwtAuthenticationFilter;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authManager() {
        DaoAuthenticationProvider daoProvider = new DaoAuthenticationProvider();
        daoProvider.setUserDetailsService(userDetailsService);
        daoProvider.setPasswordEncoder(passwordEncoder());
        return new ProviderManager(daoProvider);
    }

    @Bean
    public Customizer<CorsConfigurer<HttpSecurity>> corsCustomizer() {
        return (corsConfigurer) -> {
            corsConfigurer.configurationSource(corsConfigurationSource());
            // You can further customize CORS settings if needed
            // For example: corsConfigurer.allowedOrigins("http://localhost:3000");
            // corsConfigurer.allowedMethods("GET", "POST", "PUT", "DELETE");
        };
    }

    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.addAllowedOriginPattern("*"); // Allow all origins (you can customize based on your requirements)
        configuration.addAllowedMethod("*"); // Allow all HTTP methods
        configuration.addAllowedHeader("*"); // Allow all headers
        configuration.setAllowCredentials(true); // Allow credentials (e.g., cookies)

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration); // Apply CORS configuration to all paths

        return source;
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        //noinspection removal
        http.cors(corsCustomizer()).
        csrf().disable()
                .authorizeHttpRequests((authorize) -> {
                            authorize.requestMatchers("api/auth/**").permitAll();
                            authorize.anyRequest().authenticated();
                        }
                ).httpBasic(Customizer.withDefaults());
        http.exceptionHandling(exception -> exception.authenticationEntryPoint(jwtAuthenticationEntryPoint));
        http.addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);
        return http.build();

    }

    @Bean
    public TemplateEngine templateEngine() {
        return new TemplateEngine();
    }
}
