package com.hcl.flightbookingservice.controller;

import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.hcl.flightbookingservice.domain.BookingDetailsHistory;
import com.hcl.flightbookingservice.service.PastTravelDetailsService;

@RunWith(MockitoJUnitRunner.class)
public class PastTravelDetailsControllerTest {

	@InjectMocks
	PastTravelDetailsController pastTravelDetailsController;
	
	@Mock
	PastTravelDetailsService pastTravelDetailsService;
	
	@Before
	public void setUp() {
		
	}
	
	@Test
	public void getBookingHistoryIfUserNameIsValid() {
		String userName = "sagar"; 
		List<BookingDetailsHistory> bookingDetails = new ArrayList<>();
		BookingDetailsHistory bookingDetailsHistory = new BookingDetailsHistory();
		bookingDetails.add(bookingDetailsHistory);
		when(pastTravelDetailsService.getPastTravelDetails(userName)).thenReturn(bookingDetails);
		Assert.assertNotNull(pastTravelDetailsController.getBookingHistory(userName));
	}
	
	@Test
	public void getBookingHistoryIfUserNameIsBlank() {
		String userName = ""; 
		Assert.assertNotNull(pastTravelDetailsController.getBookingHistory(userName));
	}
	
	@Test
	public void getBookingHistoryIfUserNameIsNull() {
		Assert.assertNotNull(pastTravelDetailsController.getBookingHistory(null));
	}
}
