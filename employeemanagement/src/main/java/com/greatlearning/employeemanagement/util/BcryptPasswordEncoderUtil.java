package com.greatlearning.employeemanagement.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class BcryptPasswordEncoderUtil {
	
	public static void main(String[] args) {
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String encodedPassword1 = passwordEncoder.encode("welcome");
		String encodedPassword2 = passwordEncoder.encode("welcome");
		
		System.out.println(encodedPassword1);
		System.out.println(encodedPassword2);
	}

}

