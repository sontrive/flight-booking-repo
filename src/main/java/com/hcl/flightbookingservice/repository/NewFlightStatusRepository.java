package com.hcl.flightbookingservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hcl.flightbookingservice.entity.NewFlightStatus;

@Repository
public interface NewFlightStatusRepository extends JpaRepository<NewFlightStatus, Long> {

}
