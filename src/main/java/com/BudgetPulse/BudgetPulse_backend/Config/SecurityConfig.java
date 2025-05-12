package com.BudgetPulse.BudgetPulse_backend.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.BudgetPulse.BudgetPulse_backend.Filter.JwtAuthenticationFilter;
import com.BudgetPulse.BudgetPulse_backend.Service.UserDetailsImp;



@Configuration
@EnableWebSecurity
public class SecurityConfig {
	
	private final UserDetailsImp userDetailsImpService;
	
	public SecurityConfig(UserDetailsImp userDetailsImpService, JwtAuthenticationFilter jwtAuthenticationFilter) {
		super();
		this.userDetailsImpService = userDetailsImpService;
		this.jwtAuthenticationFilter = jwtAuthenticationFilter;
	}





	private final JwtAuthenticationFilter jwtAuthenticationFilter;
	




	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
		return http
				.csrf(AbstractHttpConfigurer ::disable)
				.authorizeHttpRequests(
						req->req.requestMatchers("/profile/user/{userId}","/profile/create/{userId}","/budget/user/{userId}","/transaction/user/{userId}","/transaction/addTransaction","/auth/login/**","/auth/register/**","/swagger-ui/**","/v3/api-docs/**")
						.permitAll()
						.anyRequest()
						.authenticated()
				).userDetailsService(userDetailsImpService)
						.sessionManagement(session->session
						.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
						.addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class)
						.build();
				
		
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public AuthenticationManager authenticationManager(AuthenticationConfiguration configuration) throws Exception {
		
		return configuration.getAuthenticationManager();
	}
	
	
}
