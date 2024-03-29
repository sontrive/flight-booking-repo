package com.hcl.flightbookingservice.service;



import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import org.mockito.junit.MockitoJUnitRunner;

import com.hcl.flightbookingservice.domain.LoginDTO;
import com.hcl.flightbookingservice.entity.Login;
import com.hcl.flightbookingservice.repository.LoginRepository;


@RunWith(MockitoJUnitRunner.class)
public class LoginServiceTest {

	
	@InjectMocks
	LoginService loginService;

	@Mock
	LoginRepository loginRepositoryMock;
	
	LoginDTO userLogin;
	
	Login userDetails;
	 
	@Before
	public void setUp() {
		userLogin = new LoginDTO();
		userLogin.setUserName("abc123");
		userLogin.setPassword("sagar");

	}

	@Test
	public void testValidateGC() {
		userDetails = new Login();
		userDetails.setUserName("abc123");
		userDetails.setPassword("sagar");
		when(loginRepositoryMock.findByUserName(userLogin.getUserName())).thenReturn(userDetails);
		String validateUser = loginService.validateUser(userLogin);
		//assertEquals(200, validateUser.getStatusCodeValue());
		
	}
	 
	
}
