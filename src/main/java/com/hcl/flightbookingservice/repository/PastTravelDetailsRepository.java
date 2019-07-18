package com.hcl.flightbookingservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hcl.flightbookingservice.entity.BookingDetails;

@Repository
public interface PastTravelDetailsRepository extends JpaRepository<BookingDetails, Long> {

	public List<BookingDetails> findByUserName(String userName);
}
