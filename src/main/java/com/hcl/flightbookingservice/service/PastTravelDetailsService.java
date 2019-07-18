package com.hcl.flightbookingservice.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.flightbookingservice.domain.BookingDetailsHistory;
import com.hcl.flightbookingservice.entity.BookingDetails;
import com.hcl.flightbookingservice.entity.Login;
import com.hcl.flightbookingservice.repository.BookingDetailsRepository;
import com.hcl.flightbookingservice.repository.LoginRepository;

@Service
public class PastTravelDetailsService {

	@Autowired
	BookingDetailsRepository bookingDetailsRepository;

	@Autowired
	LoginRepository loginRepository;

	public List<BookingDetailsHistory> getPastTravelDetails(String userName) {

		List<BookingDetailsHistory> bookingDetailsHistory = new ArrayList<>();

		Login login = loginRepository.findByUserName(userName);
		if (null != login) {
			List<BookingDetails> bookingDetails = bookingDetailsRepository.findByLogin(login);
			System.out.println(bookingDetails.size());

			if (null != bookingDetails && !bookingDetails.isEmpty()) {
				for (int i = 0; i < bookingDetails.size(); i++) {
					BookingDetailsHistory bookingHistory = new BookingDetailsHistory();
					BookingDetails bookingDetail = bookingDetails.get(i);
					bookingHistory.setArrival(bookingDetail.getArrival());
					bookingHistory.setdeparture(bookingDetail.getDeparture());
					bookingHistory.setFlightId(bookingDetail.getFlightId());
					bookingHistory.setPrice(bookingDetail.getPrice());
					bookingHistory.setTicketId(bookingDetail.getTicketId());
					bookingHistory.setTravellerDetails(bookingDetail.getTravellerDetails());
					bookingHistory.setTravelDate(bookingDetail.getTravelDate());
					bookingHistory.setTravelTime(bookingDetail.getTravelTime());

					bookingDetailsHistory.add(bookingHistory);
				}
			}
		}
		return bookingDetailsHistory;
	}
}
