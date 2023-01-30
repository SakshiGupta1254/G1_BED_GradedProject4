package com.greatlearning.employeemanagement.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class ApplicationConfigurationSecurity extends WebSecurityConfigurerAdapter {
	
	private final UserDetailsService userDetailsService;
	
	public ApplicationConfigurationSecurity(UserDetailsService userDetailsService) {
		this.userDetailsService = userDetailsService;
	}

	/**
	 * This method is to setup the Authorization
	 */
	@Override
	public void configure(HttpSecurity http) throws Exception {
		http.cors().disable();
		http.csrf().disable();
		http.headers().frameOptions().disable();
		http.authorizeRequests()
			.antMatchers("/")
				.permitAll()
			.antMatchers("/employees/**", "/employees")
				.hasAnyRole("USER", "ADMIN")
			.antMatchers("/employees/new/**", "/employees/new/**")	
				.hasAnyRole("ADMIN")
			.antMatchers("/employees/edit/**", "/employees/edit/**")	
				.hasAnyRole("ADMIN")
			.antMatchers("/employees/delete/**", "/employees/delete**")	
				.hasAnyRole("ADMIN")
			.anyRequest()
				.fullyAuthenticated()
			.and()
			.httpBasic();
	}
	
	/**
	 * This method is to setup the authentication
	 */
    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userDetailsService());
        authProvider.setPasswordEncoder(passwordEncoder());
         
        return authProvider;
    }
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    	auth.authenticationProvider(authenticationProvider());
    }	
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

}

