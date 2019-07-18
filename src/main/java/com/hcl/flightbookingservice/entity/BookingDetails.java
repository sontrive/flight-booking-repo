package com.hcl.flightbookingservice.entity;

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
	@Column(name = "booking_id")
	@OneToMany(mappedBy="cart", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<TravalerDetails> TravalerDetails;

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

	public List<TravalerDetails> getTravalerDetails() {
		return TravalerDetails;
	}

	public void setTravalerDetails(List<TravalerDetails> travalerDetails) {
		TravalerDetails = travalerDetails;
	}

	public String getFlightId() {
		return flightId;
	}

	public void setFlightId(String flightId) {
		this.flightId = flightId;
	}

	@Override
	public String toString() {
		final int maxLen = 10;
		return "BookingDetails [id=" + id + ", ticketId=" + ticketId + ", flightId=" + flightId + ", username="
				+ username + ", price=" + price + ", TravalerDetails="
				+ (TravalerDetails != null ? TravalerDetails.subList(0, Math.min(TravalerDetails.size(), maxLen))
						: null)
				+ ", getId()=" + getId() + ", getTicketId()=" + getTicketId() + ", getUsername()=" + getUsername()
				+ ", getPrice()=" + getPrice() + ", getTravalerDetails()="
				+ (getTravalerDetails() != null
						? getTravalerDetails().subList(0, Math.min(getTravalerDetails().size(), maxLen))
						: null)
				+ ", getFlightId()=" + getFlightId() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}

	
	
	


}
