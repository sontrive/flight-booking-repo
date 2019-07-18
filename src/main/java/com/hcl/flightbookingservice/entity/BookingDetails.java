package com.hcl.flightbookingservice.entity;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "booking_details")
public class BookingDetails {

	@Id
	@Column(name = "booking_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	@Column(name = "ticket_id")
	private String ticketId;
	
	@NotNull
	@Column(name = "flight_id")
	private String flightId;
	
	
	@NotNull
	@Column(name = "username")
	private String username;
	
	@NotNull
	@Column(name = "price")
	private Double price;
	
	@NotNull
	@Column(name = "travaler_details")
	@OneToMany(mappedBy="bookingDetails", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<TravellerDetails> TravalerDetails;
	
	@NotNull
	@Column(name = "arrival")
	private String arrival;
	
	@NotNull
	@Column(name = "deaparture")
	private String deaparture;
	
	@NotNull
	@Column(name = "travelDate")
	private LocalDate  travelDate;
	
	@NotNull
	@Column(name = "travelTime")
	private LocalTime  travelTime;
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTicketId() {
		return ticketId;
	}

	public void setTicketId(String ticketId) {
		this.ticketId = ticketId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
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

	public String getFlightId() {
		return flightId;
	}

	public void setFlightId(String flightId) {
		this.flightId = flightId;
	}

	public String getArrival() {
		return arrival;
	}

	public void setarrival(String arrival) {
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

	@Override
	public String toString() {
		final int maxLen = 10;
		return "BookingDetails [id=" + id + ", ticketId=" + ticketId + ", flightId=" + flightId + ", username="
				+ username + ", price=" + price + ", TravalerDetails="
				+ (TravalerDetails != null ? TravalerDetails.subList(0, Math.min(TravalerDetails.size(), maxLen))
						: null)
				+ ", arrival=" + arrival + ", deaparture=" + deaparture + ", travelDate=" + travelDate + ", travelTime="
				+ travelTime + "]";
	}

	

	
	
	


}
