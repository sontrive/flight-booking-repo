package com.hcl.flightbookingservice.domain;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

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
public class BookFlightResponse {

	private String flightId;

	private String ticketId;

	private String flightName;

	private Integer numberOfPerson;

	private List<Passenger> passenger;

	private String arrival;

	private String departure;

	private LocalDate travelDate;

	private LocalTime travelTime;

	private Double totalTravelDuration;

}