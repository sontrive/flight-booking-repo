package com.hcl.flightbookingservice.domain;

import java.time.LocalDateTime;
import java.util.List;

/*
 * This is pojo class for Book Flight Request 
 */
public class BookFlightResponse {

	private String flightId;

	private String ticketId;

	private String flightName;

	private Integer numberOfPerson;

	private List<Person> person;

	private String arrival;

	private String departure;

	private LocalDateTime travelDateTime;

	private Double totalTravelDuration;

	public String getFlightId() {
		return flightId;
	}

	public void setFlightId(String flightId) {
		this.flightId = flightId;
	}

	public String getTicketId() {
		return ticketId;
	}

	public void setTicketId(String ticketId) {
		this.ticketId = ticketId;
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

	public Double getTotalTravelDuration() {
		return totalTravelDuration;
	}

	public void setTotalTravelDuration(Double totalTravelDuration) {
		this.totalTravelDuration = totalTravelDuration;
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
		return "BookFlightResponse [flightId=" + flightId + ", ticketId=" + ticketId + ", flightName=" + flightName
				+ ", numberOfPerson=" + numberOfPerson + ", person="
				+ (person != null ? person.subList(0, Math.min(person.size(), maxLen)) : null) + ", arrival=" + arrival
				+ ", departure=" + departure + ", travelDateTime=" + travelDateTime + ", totalTravelDuration="
				+ totalTravelDuration + "]";
	}

}
