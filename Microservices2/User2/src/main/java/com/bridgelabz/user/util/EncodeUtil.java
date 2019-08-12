package com.bridgelabz.user.util;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.bridgelabz.user.dto.LoginDTO;
import com.bridgelabz.user.model.User;

@Component
public class EncodeUtil {

	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	public String encryptPassword(String password) {
		return passwordEncoder.encode(password);
	}
	
	public boolean isPassword(LoginDTO loginDTO, User user) {
		return passwordEncoder.matches(loginDTO.getPassword(),user.getPassword());
	}
	
	
	
	
}
