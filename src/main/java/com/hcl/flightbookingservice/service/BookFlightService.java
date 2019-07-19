package com.hcl.flightbookingservice.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.flightbookingservice.domain.BookFlightRequest;
import com.hcl.flightbookingservice.domain.BookFlightResponse;
import com.hcl.flightbookingservice.domain.Passenger;
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

	@Transactional
	public BookFlightResponse bookFlight(BookFlightRequest bookFlightRequest) throws ApplicationException{

		BookFlightResponse bookFlightResponse = new BookFlightResponse();
		
		List<Passenger> personList = bookFlightRequest.getPassenger();
		BookingDetails bookingDetails = new BookingDetails();
		bookingDetails.setFlightId(bookFlightRequest.getFlightId());

		Login savedLogin = loginRepository.findByUserName(bookFlightRequest.getUserName());
		Login login = new Login();
		login.setLoginId(savedLogin.getLoginId());
		login.setPassword(savedLogin.getPassword());
		login.setRole(savedLogin.getRole());
		login.setUserName(savedLogin.getUserName());
		bookingDetails.setLogin(login);

		FlightDetails flightDetails = searchFlightRepository.findByflightId(bookFlightRequest.getFlightId());
		if(flightDetails.getAvailableSeats() - personList.size() <0) {
			throw new ApplicationException("Required number of seats are not available.");
		}
		
		flightDetails.setAvailableSeats(flightDetails.getAvailableSeats() - personList.size());
		searchFlightRepository.save(flightDetails);
		
		Double price = personList.size() * flightDetails.getPrice();
		bookingDetails.setPrice(price);

		Long ticketId = (long) (Math.random() * 100000 + 3333300000L);
		bookingDetails.setTicketId(ticketId.toString());
		bookingDetails.setTravelDate(flightDetails.getDateOfJourney());
		bookingDetails.setTravelTime(flightDetails.getTimeOfJourney());
		bookingDetails.setDuration(flightDetails.getDuration());
		bookingDetails.setFlightName(flightDetails.getFlightName());
		bookingDetails.setDeparture(flightDetails.getBoarding());
		bookingDetails.setArrival(flightDetails.getDestination());
		
		List<TravellerDetails> travellerDetailsList = new ArrayList<>();
		
		for (Passenger person : personList) {
			TravellerDetails travellerDetails = new TravellerDetails();
			travellerDetails.setTravellerAge(person.getTravellerAge());
			travellerDetails.setTravellerGender(person.getTravellerGender());
			travellerDetails.setTravellerMealPref(person.getTravellerMealPref());
			travellerDetails.setTravellerName(person.getTravellerName());
			travellerDetails.setBookingDetails(bookingDetails);
			travellerDetailsList.add(travellerDetails);
		}
		bookingDetails.setTravellerDetails(travellerDetailsList);
		BookingDetails saveBookingDetails = bookingDetailsRepository.save(bookingDetails);

		//creating response
		bookFlightResponse.setArrival(saveBookingDetails.getArrival());
		bookFlightResponse.setDeparture(saveBookingDetails.getDeparture());
		bookFlightResponse.setFlightId(saveBookingDetails.getFlightId());
		bookFlightResponse.setFlightName(saveBookingDetails.getFlightName());
		bookFlightResponse.setNumberOfPerson(personList.size());
		
		List<TravellerDetails> savedTravellerDetailsList = saveBookingDetails.getTravellerDetails();
		List<Passenger> savedPersonList = new ArrayList<>();
		
		for (TravellerDetails travellerDetails : savedTravellerDetailsList) {
			
			Passenger passenger = new Passenger();
			passenger.setTravellerAge(travellerDetails.getTravellerAge());
			passenger.setTravellerGender(travellerDetails.getTravellerGender());
			passenger.setTravellerMealPref(travellerDetails.getTravellerMealPref());
			passenger.setTravellerName(travellerDetails.getTravellerName());
			savedPersonList.add(passenger);
		}
		
		bookFlightResponse.setPassenger(savedPersonList);
		bookFlightResponse.setTicketId(saveBookingDetails.getTicketId());
		bookFlightResponse.setTotalTravelDuration(saveBookingDetails.getDuration());
		bookFlightResponse.setTravelTime(saveBookingDetails.getTravelTime());
		
		System.out.println(bookFlightResponse);
		return bookFlightResponse;
	}

}
