package com.hcl.flightbookingservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.flightbookingservice.domain.NewFlightRequestStatus;
import com.hcl.flightbookingservice.service.NewFlightStatusService;

@RestController
@RequestMapping("/newflight")
public class NewFlightStatusController {

	@Autowired
	NewFlightStatusService newFlightStatusService;

	@PostMapping("/newflightstatus")
	public ResponseEntity<Object> addNewFlightRequest(@RequestBody NewFlightRequestStatus newFlightRequestStatus) {

		if (null != newFlightRequestStatus && !isNullOrEmpty(newFlightRequestStatus.getBoarding())
				&& !isNullOrEmpty(newFlightRequestStatus.getDestination())
				&& !isNullOrEmpty(newFlightRequestStatus.getFlightId())
				&& !isNullOrEmpty(newFlightRequestStatus.getFlightName())) {
			if ("new flight request submitted."
					.equalsIgnoreCase(newFlightStatusService.addNewFlightRequest(newFlightRequestStatus)))
				return new ResponseEntity<>("New Flight Request Submitted successfully", HttpStatus.ACCEPTED);
		}

		return new ResponseEntity<>("Please enter valid details", HttpStatus.BAD_REQUEST);

	}

	private boolean isNullOrEmpty(String value) {
		if (null == value || "".equals(value))
			return true;
		return false;
	}

}
