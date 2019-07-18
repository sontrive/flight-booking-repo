package com.hcl.flightbookingservice.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "traveller_details")
public class TravellerDetails {

	@Id
	@Column(name = "traveller_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	
	@NotNull
	@Column(name = "traveller_name")
	private String travellerName;
	
	
	@NotNull
	@Column(name = "traveller_age")
	private Integer travellerAge;
	
	
	@NotNull
	@Column(name = "traveller_meal_pref")
	private String travellerMealPref;
	
	
	@NotNull
	@Column(name = "traveller_gender")
	private String travellerGender;
	
	@ManyToOne
	@JoinColumn(name="booking_id", nullable=false)
	//@Column(name = "booking_details")
	private BookingDetails bookingDetails;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTravellerName() {
		return travellerName;
	}

	public void setTravellerName(String travellerName) {
		this.travellerName = travellerName;
	}

	public Integer getTravellerAge() {
		return travellerAge;
	}

	public void setTravellerAge(Integer travellerAge) {
		this.travellerAge = travellerAge;
	}

	public String getTravellerMealPref() {
		return travellerMealPref;
	}

	public void setTravellerMealPref(String travellerMealPref) {
		this.travellerMealPref = travellerMealPref;
	}

	public String getTravellerGender() {
		return travellerGender;
	}

	public void setTravellerGender(String travellerGender) {
		this.travellerGender = travellerGender;
	}

	public BookingDetails getBookingDetails() {
		return bookingDetails;
	}

	public void setBookingDetails(BookingDetails bookingDetails) {
		this.bookingDetails = bookingDetails;
	}

	@Override
	public String toString() {
		return "TravalerDetails [id=" + id + ", travellerName=" + travellerName + ", travellerAge=" + travellerAge
				+ ", travellerMealPref=" + travellerMealPref + ", travellerGender=" + travellerGender
				+ ", bookingDetails=" + bookingDetails + "]";
	}
	
	

}
