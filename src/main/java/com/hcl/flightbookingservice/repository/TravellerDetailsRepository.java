package com.hcl.flightbookingservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hcl.flightbookingservice.entity.BookingDetails;
import com.hcl.flightbookingservice.entity.TravellerDetails;

public interface TravellerDetailsRepository extends JpaRepository<TravellerDetails, Long> {
	
	List<TravellerDetails> findByBookingDetails(BookingDetails bookingDetails);

}
