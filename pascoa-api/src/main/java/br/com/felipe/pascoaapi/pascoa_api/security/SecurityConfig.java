package br.com.felipe.pascoaapi.pascoa_api.security;

import static org.springframework.security.config.Customizer.withDefaults;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

	@Bean
	public UserDetailsService userDetailsService() {
		UserDetails user1 = User.withUsername("felipe").password("{noop}navio").roles("ADMIN").build();

		UserDetails user2 = User.withUsername("pedro").password("{noop}1234").roles("USER").build();
		UserDetails user3 = User.withUsername("rebeca").password("{noop}1234").roles("USER").build();
		UserDetails user4 = User.withUsername("gabriel").password("{noop}1234").roles("USER").build();
		UserDetails user5 = User.withUsername("dyogo").password("{noop}1234").roles("USER").build();
		UserDetails user6 = User.withUsername("isaac").password("{noop}1234").roles("USER").build();
		UserDetails user7 = User.withUsername("rodrigo").password("{noop}1234").roles("USER").build();

		return new InMemoryUserDetailsManager(user1, user2, user3, user4, user5, user6, user7);
	}

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http.authorizeHttpRequests(auth -> auth.requestMatchers("/pascoa-sorte/reset").hasRole("ADMIN") 												
				.anyRequest().authenticated() 
		).httpBasic(Customizer.withDefaults())
		.csrf(csrf -> csrf.disable()).formLogin(withDefaults()).cors(withDefaults());

		return http.build();
	}

	@Bean
	public CorsConfigurationSource corsConfigurationSource() {
		 CorsConfiguration config = new CorsConfiguration();
		    
		    // Permite todas as origens
		    config.setAllowedOriginPatterns(List.of("*")); // Permite todas as origens
		    
		    // Permite os métodos especificados
		    config.setAllowedMethods(List.of("GET", "POST", "PUT", "DELETE", "OPTIONS"));
		    
		    // Permite todos os cabeçalhos
		    config.setAllowedHeaders(List.of("*"));
		    
		    // Permite o envio de credenciais (cookies, cabeçalhos de autorização)
		    config.setAllowCredentials(true); 
		    
		    // Cria uma fonte baseada em URL para a configuração de CORS
		    UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		    source.registerCorsConfiguration("/**", config);  // Aplica a configuração para todos os endpoints
		    
		    return source;
	}

}
