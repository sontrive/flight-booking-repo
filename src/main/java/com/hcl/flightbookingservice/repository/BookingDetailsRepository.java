package com.hcl.flightbookingservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hcl.flightbookingservice.entity.BookingDetails;
import com.hcl.flightbookingservice.entity.Login;

@Repository
public interface BookingDetailsRepository extends JpaRepository<BookingDetails, Long> {

	public List<BookingDetails> findByLogin(Login login);
}
