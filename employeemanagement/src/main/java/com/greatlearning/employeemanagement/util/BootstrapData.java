package com.greatlearning.employeemanagement.util;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.EventListener;

import com.greatlearning.employeemanagement.model.Role;
import com.greatlearning.employeemanagement.model.User;
import com.greatlearning.employeemanagement.repository.UserRepository;

@Configuration
public class BootstrapData {
	private final UserRepository userRepository;
	
	public BootstrapData(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	@EventListener(ApplicationReadyEvent.class)
	public void insertAppData(ApplicationReadyEvent event) {
//		User Sakshi = new User("Sakshi","welcome","sakshigupta@gmail.com");
//		User John = new User("John","welcome","John@gmail.com");
//		
//		Role userRole = new Role("ROLE_USER");
//		Role adminRole = new Role("ROLE_ADMIN");
//		
//		John.addRole(userRole);
//		Sakshi.addRole(adminRole);
//		Sakshi.addRole(userRole);
//		
//		this.userRepository.save(John);
//		this.userRepository.save(Sakshi);
	}
}
