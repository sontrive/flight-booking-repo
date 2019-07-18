package com.hcl.flightbookingservice.domain;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import com.hcl.flightbookingservice.entity.TravellerDetails;

public class BookingDetailsHistory {

	private String ticketId;
	
	private String flightId;

	private Double price;
	
	private List<TravellerDetails> TravalerDetails;
	
	private String arrival;
	
	private String deaparture;
	
	private LocalDate  travelDate;
	
	private LocalTime  travelTime;

	public String getTicketId() {
		return ticketId;
	}

	public void setTicketId(String ticketId) {
		this.ticketId = ticketId;
	}

	public String getFlightId() {
		return flightId;
	}

	public void setFlightId(String flightId) {
		this.flightId = flightId;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public List<TravellerDetails> getTravalerDetails() {
		return TravalerDetails;
	}

	public void setTravalerDetails(List<TravellerDetails> travalerDetails) {
		TravalerDetails = travalerDetails;
	}

	public String getArrival() {
		return arrival;
	}

	public void setArrival(String arrival) {
		this.arrival = arrival;
	}

	public String getDeaparture() {
		return deaparture;
	}

	public void setDeaparture(String deaparture) {
		this.deaparture = deaparture;
	}

	public LocalDate getTravelDate() {
		return travelDate;
	}

	public void setTravelDate(LocalDate travelDate) {
		this.travelDate = travelDate;
	}

	public LocalTime getTravelTime() {
		return travelTime;
	}

	public void setTravelTime(LocalTime travelTime) {
		this.travelTime = travelTime;
	}
	
}
