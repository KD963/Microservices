package com.bridgelabz.user.util;

import java.io.UnsupportedEncodingException;

public interface JwtTokenInterface {

	String generateToken(String userid) throws UnsupportedEncodingException;
	String verifyToken(String token);
	
}
