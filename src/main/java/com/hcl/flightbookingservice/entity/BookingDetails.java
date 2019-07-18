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
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
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
	@OneToOne
	@JoinColumn(name="login_id", nullable=false)
	private Login Login;

	@NotNull
	@Column(name = "price")
	private Double price;

	@NotNull
	@Column(name = "travaler_details")
	@OneToMany(mappedBy = "bookingDetails", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<TravellerDetails> travellerDetails;

	@NotNull
	@Column(name = "arrival")
	private String arrival;

	@NotNull
	@Column(name = "departure")
	private String departure;

	@NotNull
	@Column(name = "travelDate")
	private LocalDate travelDate;

	@NotNull
	@Column(name = "travelTime")
	private LocalTime travelTime;

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

	public String getFlightId() {
		return flightId;
	}

	public void setFlightId(String flightId) {
		this.flightId = flightId;
	}

	public Login getLogin() {
		return Login;
	}

	public void setLogin(Login login) {
		Login = login;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public List<TravellerDetails> getTravellerDetails() {
		return travellerDetails;
	}

	public void setTravellerDetails(List<TravellerDetails> travellerDetails) {
		this.travellerDetails = travellerDetails;
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
		return "BookingDetails [id=" + id + ", ticketId=" + ticketId + ", flightId=" + flightId + ", Login=" + Login
				+ ", price=" + price + ", travellerDetails="
				+ (travellerDetails != null ? travellerDetails.subList(0, Math.min(travellerDetails.size(), maxLen))
						: null)
				+ ", arrival=" + arrival + ", departure=" + departure + ", travelDate=" + travelDate + ", travelTime="
				+ travelTime + "]";
	}

	
	

}
