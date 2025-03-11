/*
package com.pravin;

import java.beans.Customizer;

import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class AppSecurityConfigurer {
	@Bean
	public SecurityFilterChain securityConfig(HttpSecurity http) throws Exception {
		
		http.authorizeHttpRequests((req) -> req.requestMatchers("/welcome").permitAll()
		//.requestMatchers("/submit").permitAll()
		//.requestMatchers("/form-data").permitAll()
		.anyRequest().authenticated()) 
		.httpBasic(Customizer.withDefaults())
		.formLogin(Customizer.withDefaults());
		return http.build();	
	}
	@Bean
	public InMemoryUserDetailsManager inMemoryUsers() {
		UserDetails u1= User.withDefaultPasswordEncoder().username("pravin@1250").password("pravin@1250").build();
		UserDetails u2= User.withDefaultPasswordEncoder().username("pravin").password("pravin@1250")
				//.roles("Guest")
				.build();
		
		return new InMemoryUserDetailsManager (u1,u2);
	}
	
	
	
}
*/