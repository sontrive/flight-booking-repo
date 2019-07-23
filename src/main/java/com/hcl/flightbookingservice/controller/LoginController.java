package com.hcl.flightbookingservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.flightbookingservice.domain.LoginDTO;
import com.hcl.flightbookingservice.service.LoginService;

/**
 * 
 * 
 * this controller is used to take the username and password from user and
 * returns either l0gin successful or not
 *
 */
@RestController
@RequestMapping(value = "/login")
public class LoginController {

	@Autowired
	LoginService loginSrevice;

	/**
	 * @param userDetails takes the user details as username and password
	 * @return weather user is valid or not
	 */
	@PostMapping(value = "/validate")
	public ResponseEntity<String> validateUser(@RequestBody LoginDTO userDetails) {
		if (!ObjectUtils.isEmpty(userDetails) && !"".equals(userDetails.getUserName())
				&& !"".equals(userDetails.getPassword()) && (null != userDetails.getUserName())
				&& (null != userDetails.getPassword())) {
			String role = loginSrevice.validateUser(userDetails);
			if (!"invalid user Credentials".equalsIgnoreCase(role)) {
				String user = "Login Successful..Welcome";
				if (role.equals("user") || role.equals("flight admin") || role.equals("super admin")) {
					user += role;
					return new ResponseEntity<>(user, HttpStatus.OK);
				}
			}
		}
		return new ResponseEntity<>("Login Failed. Please enter Valid Credentials...", HttpStatus.BAD_REQUEST);

	}

}
