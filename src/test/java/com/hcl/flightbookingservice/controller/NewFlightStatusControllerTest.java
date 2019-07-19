package com.hcl.flightbookingservice.controller;

import static org.mockito.Mockito.when;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.hcl.flightbookingservice.domain.NewFlightRequestStatus;
import com.hcl.flightbookingservice.service.NewFlightStatusService;

@RunWith(MockitoJUnitRunner.class)
public class NewFlightStatusControllerTest {

	@InjectMocks
	NewFlightStatusController newFlightStatusController;
	
	@Mock
	NewFlightStatusService newFlightStatusService;
	
	NewFlightRequestStatus newFlightRequestStatus;
	
	@Before
	public void setUp() {
		newFlightRequestStatus = new NewFlightRequestStatus();
	}
	
	@Test
	public void addNewFlightRequestIfNewFlightRequestIsCorrect() {
		newFlightRequestStatus.setBoarding("Kota");
		newFlightRequestStatus.setDestination("Pune");
		newFlightRequestStatus.setFlightId("ARV-235");
		newFlightRequestStatus.setFlightName("Air Vistara");
		when(newFlightStatusService.addNewFlightRequest(newFlightRequestStatus)).thenReturn("new flight request submitted.");
		Assert.assertNotNull(newFlightStatusController.addNewFlightRequest(newFlightRequestStatus));
	}
	
	@Test
	public void addNewFlightRequestIfNewFlightRequestDetailsAreIncorrectOrEmpty() {
		
		Assert.assertNotNull(newFlightStatusController.addNewFlightRequest(newFlightRequestStatus));
	}
}
