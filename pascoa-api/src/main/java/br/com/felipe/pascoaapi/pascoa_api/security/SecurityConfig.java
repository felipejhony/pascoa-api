package br.com.felipe.pascoaapi.pascoa_api.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import static org.springframework.security.config.Customizer.withDefaults;

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
		http.authorizeHttpRequests(auth -> auth.requestMatchers("/pascoa-sorte/reset").hasRole("ADMIN") // 🔒 só ADMIN
																										// acessa
				.anyRequest().authenticated() // os outros precisam só estar logados
		).csrf(csrf -> csrf.disable()).formLogin(withDefaults());

		return http.build();
	}

}
