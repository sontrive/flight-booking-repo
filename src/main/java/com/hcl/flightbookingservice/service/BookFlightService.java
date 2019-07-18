package com.hcl.flightbookingservice.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.flightbookingservice.domain.BookFlightRequest;
import com.hcl.flightbookingservice.domain.BookFlightResponse;
import com.hcl.flightbookingservice.domain.Person;
import com.hcl.flightbookingservice.entity.BookingDetails;
import com.hcl.flightbookingservice.entity.FlightDetails;
import com.hcl.flightbookingservice.entity.Login;
import com.hcl.flightbookingservice.entity.TravellerDetails;
import com.hcl.flightbookingservice.exception.ApplicationException;
import com.hcl.flightbookingservice.repository.BookingDetailsRepository;
import com.hcl.flightbookingservice.repository.LoginRepository;
import com.hcl.flightbookingservice.repository.SearchFlightRepository;
import com.hcl.flightbookingservice.repository.TravellerDetailsRepository;

@Service
public class BookFlightService {

	@Autowired
	LoginRepository loginRepository;

	@Autowired
	SearchFlightRepository searchFlightRepository;

	@Autowired
	TravellerDetailsRepository travellerDetailsRepository;

	@Autowired
	BookingDetailsRepository bookingDetailsRepository;

	public BookFlightResponse bookFlight(BookFlightRequest bookFlightRequest) throws ApplicationException {

		BookFlightResponse bookFlightResponse = new BookFlightResponse();
		
		BookingDetails bookingDetails = new BookingDetails();
		bookingDetails.setArrival(bookFlightRequest.getArrival());
		bookingDetails.setDeparture(bookFlightRequest.getDeparture());
		bookingDetails.setFlightId(bookFlightRequest.getFlightId());

		Login savedLogin = loginRepository.findByUserName(bookFlightRequest.getUserName());

		Login login = new Login();
		BeanUtils.copyProperties(savedLogin, login);
		
		bookingDetails.setLogin(login);

		FlightDetails flightDetails = searchFlightRepository.findByflightId(bookFlightRequest.getFlightId());
		Double price = bookFlightRequest.getNumberOfPerson() * flightDetails.getPrice();
		bookingDetails.setPrice(price);

		Long ticketId = (long) (Math.random() * 100000 + 3333300000L);
		bookingDetails.setTicketId(ticketId.toString());
		bookingDetails.setTravelDateTime(bookFlightRequest.getTravelDateTime());
		BookingDetails saveBookingDetails = bookingDetailsRepository.save(bookingDetails);

		List<Person> personList = bookFlightRequest.getPerson();

		for (Person person : personList) {
			TravellerDetails travellerDetails = new TravellerDetails();
			BeanUtils.copyProperties(person, travellerDetails);
			
			travellerDetailsRepository.save(travellerDetails);
		}

		//creating response
		bookFlightResponse.setArrival(saveBookingDetails.getArrival());
		bookFlightResponse.setDeparture(saveBookingDetails.getDeparture());
		bookFlightResponse.setFlightId(saveBookingDetails.getFlightId());
		bookFlightResponse.setNumberOfPerson(bookFlightRequest.getNumberOfPerson());

		List<TravellerDetails> travellerDetailsList = saveBookingDetails.getTravellerDetails();
		List<Person> savedpersonList = new ArrayList<>();

		for (TravellerDetails travellerDetails : travellerDetailsList) {
			Person person = new Person();
			BeanUtils.copyProperties(travellerDetails, person);
			savedpersonList.add(person);
		}

		bookFlightResponse.setPerson(savedpersonList);
		bookFlightResponse.setTicketId(saveBookingDetails.getTicketId());
		bookFlightResponse.setTotalTravelDuration(flightDetails.getDuration());
		bookFlightResponse.setTravelDateTime(saveBookingDetails.getTravelDateTime());

		return bookFlightResponse;
	}

}
