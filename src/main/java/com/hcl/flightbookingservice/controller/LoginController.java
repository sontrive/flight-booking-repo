package com.hcl.flightbookingservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.flightbookingservice.entity.Login;
import com.hcl.flightbookingservice.service.LoginService;

@RestController
@RequestMapping(value = "/login")
public class LoginController {

	@Autowired
	LoginService loginSrevice;

	@PostMapping(value = "/validate")
	public ResponseEntity<String> validateUser(@RequestBody Login userDetails) {
		if (null != userDetails && !"".equals(userDetails.getUserName()) && !"".equals(userDetails.getPassword())) {
			boolean status = loginSrevice.validateUser(userDetails);
			if (status)
				return new ResponseEntity<String>("Login Successful", HttpStatus.OK);
		}
		return new ResponseEntity<String>("Login Failed. Please enter Valid Credentials...", HttpStatus.BAD_REQUEST);

	}
}
