package com.hcl.flightbookingservice.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.flightbookingservice.domain.BookingDetailsHistory;
import com.hcl.flightbookingservice.entity.BookingDetails;
import com.hcl.flightbookingservice.repository.PastTravelDetailsRepository;

@Service
public class PastTravelDetailsService {

	@Autowired
	PastTravelDetailsRepository pastTravelDetailsRepository;

	public List<BookingDetailsHistory> getPastTravelDetails(String userName) {

		List<BookingDetailsHistory> bookingDetailsHistory = new ArrayList<>();
		List<BookingDetails> bookingDetails = pastTravelDetailsRepository.findAll();
		if (null != bookingDetails && !bookingDetails.isEmpty()) {
			for (int i = 0; i < bookingDetails.size(); i++) {
				BookingDetailsHistory bookingHistory = new BookingDetailsHistory();
				BookingDetails bookingDetail = bookingDetails.get(i);
				bookingHistory.setArrival(bookingDetail.getArrival());
				bookingHistory.setDeaparture(bookingDetail.getDeaparture());
				bookingHistory.setFlightId(bookingDetail.getFlightId());
				bookingHistory.setPrice(bookingDetail.getPrice());
				bookingHistory.setTicketId(bookingDetail.getTicketId());
				bookingHistory.setTravalerDetails(bookingDetail.getTravalerDetails());
				bookingHistory.setTravelDate(bookingDetail.getTravelDate());
				bookingHistory.setTravelTime(bookingDetail.getTravelTime());

				bookingDetailsHistory.add(bookingHistory);
			}
		}

		return bookingDetailsHistory;
	}
}
