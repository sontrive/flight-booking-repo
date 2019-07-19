package com.hcl.flightbookingservice.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.ResponseEntity;

import com.hcl.flightbookingservice.domain.BookFlightRequest;
import com.hcl.flightbookingservice.domain.BookFlightResponse;
import com.hcl.flightbookingservice.exception.ApplicationException;
import com.hcl.flightbookingservice.service.BookFlightService;

@RunWith(MockitoJUnitRunner.class)
public class BookFlightServiceTest {

	/*
	 * 
	 * 
	 * @InjectMocks BookFlightController bookFlightController;
	 * 
	 * @Mock BookFlightService bookFlightServiceMock;
	 * 
	 * BookFlightRequest bookFlightRequest;
	 * 
	 * @Before public void setUp() {
	 * 
	 * }

	 * 
	 * @Test public void testBookFlight() { BookFlightResponse bookFlightResponse =
	 * new BookFlightResponse();
	 * Mockito.when(bookFlightServiceMock.bookFlight(bookFlightRequest)).thenReturn(
	 * bookFlightResponse); ResponseEntity<?> bookFlight =
	 * bookFlightController.bookFlight(bookFlightRequest);
	 * 
	 * assertNotNull(bookFlight); assertEquals(200,
	 * bookFlight.getStatusCodeValue()); }
	 * 
	 * public BookFlightResponse creatBootFlightResponse(){
	 * 
	 * BookFlightResponse bookFlightResponse = new BookFlightResponse();
	 * bookFlightResponse.setArrival("Pune");
	 * bookFlightResponse.setDeparture("Mumbai");
	 * bookFlightResponse.setFlightId("1234");
	 * bookFlightResponse.setNumberOfPerson(2);
	 * bookFlightResponse.setTicketId("12345");
	 * bookFlightResponse.setTotalTravelDuration(2.0);
	 * bookFlightResponse.setTravelDate(LocalDate.of(2019, 7, 3));
	 * bookFlightResponse.setTravelTime(LocalTime.of(3, 30)); return
	 * bookFlightResponse; }
	 * 

	 */	
}
