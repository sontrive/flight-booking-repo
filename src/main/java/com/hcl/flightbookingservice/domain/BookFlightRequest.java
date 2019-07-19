package com.hcl.flightbookingservice.domain;

import java.util.List;

import javax.validation.constraints.NotNull;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/*
 * This is pojo class for Book Flight Request 
 */
@Data
@Getter
@Setter
@NoArgsConstructor
public class BookFlightRequest {

	@NotNull(message = "FlightId is missing.")
	private String flightId;

	@NotNull(message = "Username is missing.")
	private String userName;

	@NotNull(message = "Person ddetails are missing.")
	private List<Passenger> passenger;

}
