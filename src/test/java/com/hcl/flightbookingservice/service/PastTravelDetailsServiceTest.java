package com.hcl.flightbookingservice.service;

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
import com.hcl.flightbookingservice.entity.BookingDetails;
import com.hcl.flightbookingservice.entity.Login;
import com.hcl.flightbookingservice.repository.BookingDetailsRepository;
import com.hcl.flightbookingservice.repository.LoginRepository;
import com.hcl.flightbookingservice.service.PastTravelDetailsService;

@RunWith(MockitoJUnitRunner.class)
public class PastTravelDetailsServiceTest {

	@InjectMocks
	PastTravelDetailsService pastTravelDetailsService;
	
	@Mock
	BookingDetailsRepository bookingDetailsRepository;
	
	@Mock
	LoginRepository loginRepository;
	
	@Before
	public void setup() {
		
	}
	
	@Test
	public void getPastTravelDetailsIfUserNameIsCorrect() {

		String userName = "sagar"; 
		List<BookingDetailsHistory> bookingDetailsHistoryList = new ArrayList<>();
		BookingDetailsHistory bookingDetailsHistory = new BookingDetailsHistory();
		bookingDetailsHistoryList.add(bookingDetailsHistory);
		List<BookingDetails> bookingDetails = new ArrayList<>();
		BookingDetails bookingDetail = new BookingDetails();
		bookingDetails.add(bookingDetail);
		Login login = new Login();
		when(loginRepository.findByUserName(userName)).thenReturn(login);
		when(bookingDetailsRepository.findByLogin(login)).thenReturn(bookingDetails);
		Assert.assertNotNull(pastTravelDetailsService.getPastTravelDetails(userName));
	}
	
	@Test
	public void getPastTravelDetailsIfUserNameIsIncorrect() {

		String userName = "saga"; 
		when(loginRepository.findByUserName(userName)).thenReturn(null);
		Assert.assertNotNull(pastTravelDetailsService.getPastTravelDetails(userName));
	}
}
