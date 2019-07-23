package com.hcl.flightbookingservice.service;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.hcl.flightbookingservice.domain.NewFlightRequestStatus;
import com.hcl.flightbookingservice.entity.NewFlightStatus;
import com.hcl.flightbookingservice.repository.NewFlightStatusRepository;

@RunWith(MockitoJUnitRunner.class)
public class NewFlightStatusServiceTest {

	@InjectMocks
	NewFlightStatusService newFlightStatusService;

	@Mock
	NewFlightStatusRepository newFlightStatusRepository;

	NewFlightRequestStatus newFlightRequestStatus;

	@Before
	public void setUp() {
		newFlightRequestStatus = new NewFlightRequestStatus();
	}

	@Test
	public void addNewFlightRequestIfNewFlightRequestIsCorrect() {
		
		NewFlightStatus newFlightStatus = new NewFlightStatus();
		newFlightRequestStatus.setBoarding("Pune");
		newFlightRequestStatus.setDestination("Kota");
		newFlightRequestStatus.setFlightId("ARV-231");
		newFlightRequestStatus.setFlightName("Air Vistara");
		Assert.assertNotNull(newFlightStatusService.addNewFlightRequest(newFlightRequestStatus));
	}
	
}
