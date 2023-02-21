package com.greatlearning.employeemanagement.service;

import java.util.Optional;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.greatlearning.employeemanagement.model.DomainUserDetails;
import com.greatlearning.employeemanagement.model.User;
import com.greatlearning.employeemanagement.repository.UserRepository;


import org.springframework.beans.factory.annotation.Autowired;


public class DomainUserDetailsServiceImpl implements UserDetailsService {

	   @Autowired
	    private UserRepository userRepository;
	     
	    @Override
	    public UserDetails loadUserByUsername(String username)
	            throws UsernameNotFoundException {
	        User user = userRepository.findByUsername(username);
	 
	        if (user == null) {
	            throw new UsernameNotFoundException("Could not find user");
	        }
	         
	        return new DomainUserDetails(user);
	    }

}