package com.hcl.flightbookingservice.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.flightbookingservice.domain.BookingDetailsHistory;
import com.hcl.flightbookingservice.entity.BookingDetails;
import com.hcl.flightbookingservice.repository.BookingDetailsRepository;

@Service
public class PastTravelDetailsService {

	@Autowired
	BookingDetailsRepository pastTravelDetailsRepository;

	public List<BookingDetailsHistory> getPastTravelDetails(String userName) {

		List<BookingDetailsHistory> bookingDetailsHistory = new ArrayList<>();
		List<BookingDetails> bookingDetails = pastTravelDetailsRepository.findByUserName(userName);
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

		return bookingDetailsHistory;
	}
}
