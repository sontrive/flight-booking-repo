package com.hcl.flightbookingservice.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.ResponseEntity;

import com.hcl.flightbookingservice.domain.LoginDTO;
import com.hcl.flightbookingservice.service.LoginService;

@RunWith(MockitoJUnitRunner.class)
public class LoginControllerTest {

	@InjectMocks
	LoginController loginController;

	@Mock
	LoginService loginServiceMock;

	LoginDTO userLogin;

	@Before
	public void setUp() {
		userLogin = new LoginDTO();
		userLogin.setUserName("abc123");
		userLogin.setPassword("sagar");

	}

	@Test
	public void testValidate() {

		Mockito.when(loginServiceMock.validateUser(userLogin)).thenReturn(true);
		ResponseEntity<String> validateUser = loginController.validateUser(userLogin);
		assertNotNull(validateUser);
		assertEquals(200, validateUser.getStatusCodeValue());
	}

	@Test
	public void testInvalidDetails() {

		Mockito.when(loginServiceMock.validateUser(userLogin)).thenReturn(false);
		ResponseEntity<String> validateUser = loginController.validateUser(userLogin);
		assertNotNull(validateUser);
		assertEquals(400, validateUser.getStatusCodeValue());

	}

	@Test
	public void testUserNameAndPasswordNull() {

		userLogin = new LoginDTO();
		userLogin.setUserName(null);
		userLogin.setPassword(null);
		Mockito.when(loginServiceMock.validateUser(userLogin)).thenReturn(false);
		ResponseEntity<String> validateUser = loginController.validateUser(userLogin);
		assertNotNull(validateUser);
		assertEquals(400, validateUser.getStatusCodeValue());
	}

	
	@Test
	public void testUserNameNull() {

		userLogin = new LoginDTO();
		userLogin.setUserName(null);
		userLogin.setPassword("abc");
		Mockito.when(loginServiceMock.validateUser(userLogin)).thenReturn(false);
		ResponseEntity<String> validateUser = loginController.validateUser(userLogin);
		assertNotNull(validateUser);
		assertEquals(400, validateUser.getStatusCodeValue());
	}
	
}
