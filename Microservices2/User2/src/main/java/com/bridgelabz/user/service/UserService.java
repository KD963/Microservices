package com.bridgelabz.user.service;

import com.bridgelabz.user.dto.LoginDTO;
import com.bridgelabz.user.dto.UserDTO;

public interface UserService {

	String registerUser(UserDTO userDTO, StringBuffer requestUrl);

	String loginUser(LoginDTO loginDTO);

	String forgotPassword(String emailId, StringBuffer requestUrl);

	String resetPassword(String password, String token);

	String validateUser(String token);
}
