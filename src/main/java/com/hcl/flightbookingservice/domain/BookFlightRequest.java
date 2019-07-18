package com.hcl.flightbookingservice.domain;

import java.time.LocalDateTime;
import java.util.List;

import javax.validation.constraints.NotNull;

/*
 * This is pojo class for Book Flight Request 
 */
public class BookFlightRequest {
	
	@NotNull(message = "FlightId is missing.")
	private String flightId;
	
	@NotNull(message = "Flight Name is missing.")
	private String flightName;

	@NotNull(message = "Username is missing.")
	private String userName;
	
	@NotNull(message = "Number of Person is missing.")
	private Integer numberOfPerson;
	
	@NotNull(message = "Person ddetails are missing.")
	private List<Person> person;
	
	@NotNull(message = "Arrival is missing.")
	private String arrival;
	
	@NotNull(message = "Departure is missing.")
	private String departure;
	
	@NotNull(message = "Travel Date/time is missing.")
	private LocalDateTime  travelDateTime;
	
	
	public String getFlightId() {
		return flightId;
	}

	public void setFlightId(String flightId) {
		this.flightId = flightId;
	}

	public String getFlightName() {
		return flightName;
	}

	public void setFlightName(String flightName) {
		this.flightName = flightName;
	}


	public Integer getNumberOfPerson() {
		return numberOfPerson;
	}

	public void setNumberOfPerson(Integer numberOfPerson) {
		this.numberOfPerson = numberOfPerson;
	}

	public List<Person> getPerson() {
		return person;
	}

	public void setPerson(List<Person> person) {
		this.person = person;
	}

	public String getArrival() {
		return arrival;
	}

	public void setArrival(String arrival) {
		this.arrival = arrival;
	}

	public String getDeparture() {
		return departure;
	}

	public void setDeparture(String departure) {
		this.departure = departure;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public LocalDateTime getTravelDateTime() {
		return travelDateTime;
	}

	public void setTravelDateTime(LocalDateTime travelDateTime) {
		this.travelDateTime = travelDateTime;
	}

	@Override
	public String toString() {
		final int maxLen = 10;
		return "BookFlightRequest [flightId=" + flightId + ", flightName=" + flightName + ", userName=" + userName
				+ ", numberOfPerson=" + numberOfPerson + ", person="
				+ (person != null ? person.subList(0, Math.min(person.size(), maxLen)) : null) + ", arrival=" + arrival
				+ ", departure=" + departure + ", travelDateTime=" + travelDateTime + "]";
	}

	

}
