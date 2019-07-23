package com.hcl.flightbookingservice.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.flightbookingservice.domain.NewFlightRequestStatus;
import com.hcl.flightbookingservice.entity.NewFlightStatus;
import com.hcl.flightbookingservice.repository.NewFlightStatusRepository;

@Service
public class NewFlightStatusService {

	@Autowired
	NewFlightStatusRepository newFlightStatusRepository;
	
	public String addNewFlightRequest(NewFlightRequestStatus newFlightRequestStatus) {
		NewFlightStatus newFlightStatus = new NewFlightStatus();
		BeanUtils.copyProperties(newFlightRequestStatus, newFlightStatus);
		newFlightStatusRepository.save(newFlightStatus);
		return "new flight request submitted.";
	}
}
