package com.querubines.gateway.auth;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;

@Configuration
public class SecurityConfiguration {
	
	@Bean
	SecurityWebFilterChain springSecurityFilterChain(ServerHttpSecurity http) {
		http
			.csrf(ServerHttpSecurity.CsrfSpec::disable)
			.authorizeExchange(exchange -> exchange
					.pathMatchers("/eureka/**","/actuador/**").permitAll()
					.pathMatchers(HttpMethod.GET, "/**").permitAll()
					.pathMatchers(HttpMethod.OPTIONS, "/**").permitAll()
					.anyExchange().authenticated()
				
					)
			.httpBasic(Customizer.withDefaults());
		return http.build();

	}
	

}
