package com.bridgelabz.user.controller;

import java.util.Arrays;

import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.bridgelabz.user.dto.LoginDTO;
import com.bridgelabz.user.dto.UserDTO;
import com.bridgelabz.user.response.Response;
import com.bridgelabz.user.service.UserService;

@RestController
@RequestMapping("/users")
@CrossOrigin(allowedHeaders = "*", origins = "*", exposedHeaders = { "token" })
public class UserController {

	@Autowired
	private UserService userService;

	@Autowired
	private RestTemplate restTemplate;

	@PostMapping("/register")
	public ResponseEntity<Response> registerUser(@RequestBody @Valid UserDTO userDTO, HttpServletRequest request) {
		StringBuffer requestUrl = request.getRequestURL();
		String message = userService.registerUser(userDTO, requestUrl);
		Response response = new Response(200, message, null);
		return new ResponseEntity<Response>(response, HttpStatus.OK);
	}

	@PostMapping("/login")
	public ResponseEntity<?> loginUser(@RequestBody LoginDTO loginDTO, HttpServletResponse servletResponse) {
		String token = userService.loginUser(loginDTO);
		servletResponse.setHeader("Authorization", token);

		String url = "http://localhost:8010/notes/getall";
		HttpHeaders headers = new HttpHeaders();
		headers.set("token", token);
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<String> entity = new HttpEntity<String>(headers);
		System.out.println("header-->" + headers);
		ResponseEntity<Object[]> notes = restTemplate.exchange(url, HttpMethod.GET, entity, Object[].class);
		System.out.println(notes.getBody());
		System.out.println(token);

		Response response = new Response(200, "logged in successfully", token);
		return new ResponseEntity<>(notes.getBody(), HttpStatus.OK);
	}
	

	@GetMapping("/verification/{verify}")
	public ResponseEntity<Response> validate(@PathVariable String verify) {
		String message = userService.validateUser(verify);
		Response response = new Response(200, message, null);
		return new ResponseEntity<Response>(response, HttpStatus.OK);
	}

	@GetMapping("/forgot")
	public ResponseEntity<Response> forgot(@RequestParam String emailId, HttpServletRequest request) {
		StringBuffer requestUrl = request.getRequestURL();
		String message = userService.forgotPassword(emailId, requestUrl);
		Response response = new Response(200, message, null);
		return new ResponseEntity<Response>(response, HttpStatus.OK);
	}

	@PutMapping("/reset")
	public ResponseEntity<Response> resetPassword(@RequestParam String password, @RequestHeader String token) {
		System.out.println("reset");
		String message = userService.resetPassword(password, token);

		Response response = new Response(200, message, null);
		return new ResponseEntity<Response>(response, HttpStatus.OK);
	}

}
