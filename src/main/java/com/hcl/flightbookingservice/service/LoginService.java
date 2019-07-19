package com.hcl.flightbookingservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.flightbookingservice.domain.LoginDTO;
import com.hcl.flightbookingservice.entity.Login;
import com.hcl.flightbookingservice.repository.LoginRepository;

@Service
public class LoginService {

	@Autowired
	LoginRepository loginRepository;

	/**
	 * @param userDetails takes userdetails from controller get detials from
	 *                    database table login details
	 * @return the user is valid or not after check
	 */
	public String validateUser(LoginDTO userDetails) {

		Login user = loginRepository.findByUserName(userDetails.getUserName());
		String getRole = user.getRole();
		
		if (null != user && user.getUserName().equals(userDetails.getUserName())
				&& user.getPassword().equals(userDetails.getPassword()))
			return getRole;
		return "invalid user Credentials" ;
	}

}
