package com.hcl.flightbookingservice.domain;

import java.time.LocalDate;
import java.time.LocalTime;


public class FlightDetailsDTO {

	
	private String  flightName;

	private String boarding;

	private String destination;

	private LocalDate dateOfJourney;
	
	private LocalTime timeOfJourney;
	
	private Double price;

	private Double duration;
	
	private Integer availableSeats;
	

	public String getFlightName() {
		return flightName;
	}

	public void setFlightName(String flightName) {
		this.flightName = flightName;
	}

	public String getBoarding() {
		return boarding;
	}

	public void setBoarding(String boarding) {
		this.boarding = boarding;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public LocalDate getDateOfJourney() {
		return dateOfJourney;
	}

	public void setDateOfJourney(LocalDate dateOfJourney) {
		this.dateOfJourney = dateOfJourney;
	}

	public LocalTime getTimeOfJourney() {
		return timeOfJourney;
	}

	public void setTimeOfJourney(LocalTime timeOfJourney) {
		this.timeOfJourney = timeOfJourney;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Double getDuration() {
		return duration;
	}

	public void setDuration(Double duration) {
		this.duration = duration;
	}

	public Integer getAvailableSeats() {
		return availableSeats;
	}

	public void setAvailableSeats(Integer availableSeats) {
		this.availableSeats = availableSeats;
	}

	@Override
	public String toString() {
		return "FlightDetailsDTO [flightName=" + flightName + ", boarding=" + boarding + ", destination=" + destination
				+ ", dateOfJourney=" + dateOfJourney + ", timeOfJourney=" + timeOfJourney + ", price=" + price
				+ ", duration=" + duration + ", availableSeats=" + availableSeats + "]";
	}
	
	

}
