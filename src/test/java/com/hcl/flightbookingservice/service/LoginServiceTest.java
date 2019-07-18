package com.hcl.flightbookingservice.service;

import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.hcl.flightbookingservice.entity.Login;
import com.hcl.flightbookingservice.repository.LoginRepository;


@RunWith(MockitoJUnitRunner.class)
public class LoginServiceTest {

	
	@InjectMocks
	LoginService loginService;

	@Mock
	LoginRepository loginRepositoryMock;
	
	Login userLogin;
	 
	@Before
	public void setUp() {
		userLogin = new Login();
		userLogin.setUserName("abc123");
		userLogin.setPassword("sagar");

	}
	
	
	@Test
	public void testValidateGC() {

		Mockito.when(loginRepositoryMock.findByUserName(userLogin.getUserName())).thenReturn(userLogin);
		boolean validateUser = loginService.validateUser(userLogin);
		assertNotNull(validateUser);
	
	}
	

	
}
