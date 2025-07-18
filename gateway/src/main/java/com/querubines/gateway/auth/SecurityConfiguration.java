package com.querubines.gateway.auth;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.reactive.CorsConfigurationSource;
import org.springframework.web.cors.reactive.UrlBasedCorsConfigurationSource;
@Configuration
public class SecurityConfiguration {
	
	@Bean
	SecurityWebFilterChain springSecurityFilterChain(ServerHttpSecurity http) {
		http.cors(cors -> cors.configurationSource(corsConfigurationSource()));

        http
            .csrf(ServerHttpSecurity.CsrfSpec::disable)
            .authorizeExchange(exchange -> exchange
                .pathMatchers("/eureka/**", "/actuador/**").permitAll()
                .pathMatchers(HttpMethod.GET, "/**").permitAll()
                .pathMatchers(HttpMethod.OPTIONS, "/**").permitAll()
                .anyExchange().authenticated()
            )
            .httpBasic(Customizer.withDefaults());

        return http.build();
	}
	
	 @Bean
	    CorsConfigurationSource corsConfigurationSource() {
	        CorsConfiguration config = new CorsConfiguration();
	        config.setAllowCredentials(true); // Si usas cookies o autenticación
	        config.addAllowedOrigin("http://localhost:4200"); // Origen de Angular
	        config.addAllowedMethod("*"); // Métodos permitidos (GET, POST, etc.)
	        config.addAllowedHeader("*"); // Headers permitidos

	        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
	        source.registerCorsConfiguration("/**", config); // Aplica a todas las rutas

	        return source;
	    }
}
