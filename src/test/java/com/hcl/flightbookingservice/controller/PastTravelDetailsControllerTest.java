package com.hcl.flightbookingservice.controller;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import com.hcl.flightbookingservice.domain.BookingDetailsHistory;

@RunWith(MockitoJUnitRunner.class)
public class PastTravelDetailsControllerTest {

	@InjectMocks
	PastTravelDetailsController pastTravelDetailsController;
	
	@Before
	public void setUp() {
		
	}
	
	@Test
	public void getBookingHistoryIfUserNameIsValid() {
		List<BookingDetailsHistory> bookingDetails = new ArrayList<>();
		
	}
}
