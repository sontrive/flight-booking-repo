package com.hcl.flightbookingservice.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.BeanUtils;
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
		
		BookingDetails bookingDetails = new BookingDetails();
		bookingDetails.setFlightId(bookFlightRequest.getFlightId());

		Login savedLogin = loginRepository.findByUserName(bookFlightRequest.getUserName());
		Login login = new Login();
		BeanUtils.copyProperties(savedLogin, login);
		bookingDetails.setLogin(login);

		FlightDetails flightDetails = searchFlightRepository.findByflightId(bookFlightRequest.getFlightId());
		//check for availbale seats.
		
		
		List<Passenger> personList = bookFlightRequest.getPassenger();
		Double price = personList.size() * flightDetails.getPrice();
		bookingDetails.setPrice(price);

		Long ticketId = (long) (Math.random() * 100000 + 3333300000L);
		bookingDetails.setTicketId(ticketId.toString());
		bookingDetails.setTravelDate(flightDetails.getDateOfJourney());
		bookingDetails.setTravelTime(flightDetails.getTimeOfJourney());
		bookingDetails.setDuration(flightDetails.getDuration());
		bookingDetails.setFlightName(flightDetails.getFlightName());
		
		
		List<TravellerDetails> travellerDetailsList = new ArrayList<>();
		
		for (Passenger person : personList) {
			TravellerDetails travellerDetails = new TravellerDetails();
			BeanUtils.copyProperties(person, travellerDetails);
			travellerDetails.setBookingDetails(bookingDetails);
			travellerDetailsList.add(travellerDetails);
		}
		bookingDetails.setTravellerDetails(travellerDetailsList);
		BookingDetails saveBookingDetails = bookingDetailsRepository.save(bookingDetails);

		//creating response
		BeanUtils.copyProperties(saveBookingDetails, bookFlightResponse);
		bookFlightResponse.setNumberOfPerson(personList.size());
		System.out.println(bookFlightResponse);
		return bookFlightResponse;
	}

}
