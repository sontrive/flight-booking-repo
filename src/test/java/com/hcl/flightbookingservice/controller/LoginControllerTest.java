package com.hcl.flightbookingservice.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Ignore;
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

	LoginDTO userLoginEmpty;


	@Before
	public void setUp() {
		userLogin = new LoginDTO();
		userLogin.setUserName("abc");
		userLogin.setPassword("sagar");

	}

	@Test
	public void testValidate() {

		Mockito.when(loginServiceMock.validateUser(userLogin)).thenReturn("user");
		ResponseEntity<String> validateUser = loginController.validateUser(userLogin);
		assertNotNull(validateUser);
		assertEquals(200, validateUser.getStatusCodeValue());
	}

	@Test
	public void testValidateFlightAdmin() {

		Mockito.when(loginServiceMock.validateUser(userLogin)).thenReturn("flight admin");
		ResponseEntity<String> validateUser = loginController.validateUser(userLogin);
		assertNotNull(validateUser);
		assertEquals(200, validateUser.getStatusCodeValue());
	}

	@Test
	public void testValidateSuperAdmin() {

		Mockito.when(loginServiceMock.validateUser(userLogin)).thenReturn("super admin");
		ResponseEntity<String> validateUser = loginController.validateUser(userLogin);
		assertNotNull(validateUser);
		assertEquals(200, validateUser.getStatusCodeValue());
	}

	@Test
	public void testInvalidDetails() {

		Mockito.when(loginServiceMock.validateUser(userLogin)).thenReturn("invalid user Credentials");
		ResponseEntity<String> validateUser = loginController.validateUser(userLogin);
		assertNotNull(validateUser);
		assertEquals(400, validateUser.getStatusCodeValue());

	}

	@Test
	public void testUserNameAndPasswordNull() {

		userLogin = new LoginDTO();
		userLogin.setUserName(null);
		userLogin.setPassword(null);
		//Mockito.when(loginServiceMock.validateUser(userLogin)).thenReturn("");
		ResponseEntity<String> validateUser = loginController.validateUser(userLogin);
		assertNotNull(validateUser);
		assertEquals(400, validateUser.getStatusCodeValue());
	}

	@Test
	public void testUserNameNull() {

		userLogin = new LoginDTO();
		userLogin.setUserName(null);
		userLogin.setPassword("abc");
		//Mockito.when(loginServiceMock.validateUser(userLogin)).thenReturn("");
		ResponseEntity<String> validateUser = loginController.validateUser(userLogin);
		assertNotNull(validateUser);
		assertEquals(400, validateUser.getStatusCodeValue());
	}

	@Test
	public void testPasswordNull() {

		userLogin = new LoginDTO();
		userLogin.setUserName(null);
		userLogin.setPassword("abc");
	//	Mockito.when(loginServiceMock.validateUser(userLogin)).thenReturn("");
		ResponseEntity<String> validateUser = loginController.validateUser(userLogin);
		assertNotNull(validateUser);
		assertEquals(400, validateUser.getStatusCodeValue());
	}
	
	@Test
	public void testObjectNull() {

		userLoginEmpty = new LoginDTO();
		
	//	Mockito.when(loginServiceMock.validateUser(userLoginEmpty)).thenReturn("");
		ResponseEntity<String> validateUser = loginController.validateUser(userLoginEmpty);
		assertNotNull(validateUser);
		assertEquals(400, validateUser.getStatusCodeValue());
	}

}
