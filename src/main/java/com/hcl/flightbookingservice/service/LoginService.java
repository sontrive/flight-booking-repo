package com.hcl.flightbookingservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.flightbookingservice.entity.Login;
import com.hcl.flightbookingservice.repository.LoginRepository;

@Service
public class LoginService {

	@Autowired
	LoginRepository loginRepository;

	public boolean validateUser(Login userDetails) {
		// TODO Auto-generated method stub

		Login user = loginRepository.findByUserName(userDetails.getUserName());
		if (user != null)
			if (user.getUserName().equals(userDetails.getUserName())
					&& user.getPassword().equals(userDetails.getPassword()))
				return true;
		return false;
	}

}
