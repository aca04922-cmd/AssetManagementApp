package com.example.demo.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

	
//	@Bean
//	public UserDetailsService userDetailsService() {
//		
//		UserDetails taro = User.builder().username("taro").password("{noop}taro123").roles("ADMIN").build();
//		UserDetails jiro = User.builder().username("jiro").password("{noop}jiro123").roles("STAFF").build();
//		UserDetails saburo = User.builder().username("saburo").password("{noop}saburo123").roles("GUEST").build();
//		
//		return new InMemoryUserDetailsManager(taro,jiro,saburo);
//	}


	    @Autowired
	    private DataSource dataSource;

	    @Bean
	    public UserDetailsManager userDetailsManager() {
	        return new JdbcUserDetailsManager(dataSource);
	    }
	    
	    @Bean
	    public PasswordEncoder passwordEncoder() {
	        return new BCryptPasswordEncoder();
	    }

	    @Bean
	    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
	        http
	            .authorizeHttpRequests(auth -> auth
	                .requestMatchers("/login", "/register","/css/**","/register-complete").permitAll()
	                .anyRequest().authenticated()
	            )
	            .formLogin(form -> form
	                .loginPage("/login")
	                .defaultSuccessUrl("/mt-top", true)
	                .permitAll()
	            )
	            .logout(logout -> logout
	                .logoutSuccessUrl("/login?logout")
	                .permitAll()
	            );
	        return http.build();
	    }
	

}
