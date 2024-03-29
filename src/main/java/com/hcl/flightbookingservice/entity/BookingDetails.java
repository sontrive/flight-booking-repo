package com.hcl.flightbookingservice.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name = "booking_details")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,property = "booking_id")
public class BookingDetails implements Serializable{

	
	private static final long serialVersionUID = 1L;

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
	@Column(name="flight_name")
	private String  flightName;
	
	@Column(name="duration")
	private Double duration;

	@NotNull
	@OneToOne
	@JoinColumn(name = "login_id", nullable = false)
	private Login login;

	@NotNull
	@Column(name = "price")
	private Double price;

	@NotNull
	@Column(name = "travaler_details")
	@OneToMany(mappedBy = "bookingDetails", cascade = CascadeType.ALL)
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

	public Login getLogin() {
		return login;
	}

	public void setLogin(Login login) {
		this.login = login;
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

	public String getFlightName() {
		return flightName;
	}

	public void setFlightName(String flightName) {
		this.flightName = flightName;
	}
	public Double getDuration() {
		return duration;
	}

	public void setDuration(Double duration) {
		this.duration = duration;
	}

	@Override
	public String toString() {
		final int maxLen = 10;
		return "BookingDetails [id=" + id + ", ticketId=" + ticketId + ", flightId=" + flightId + ", flightName="
				+ flightName + ", duration=" + duration + ", login=" + login + ", price=" + price
				+ ", travellerDetails="
				+ (travellerDetails != null ? travellerDetails.subList(0, Math.min(travellerDetails.size(), maxLen))
						: null)
				+ ", arrival=" + arrival + ", departure=" + departure + ", travelDate=" + travelDate + ", travelTime="
				+ travelTime + "]";
	}
	
}
