package com.hcl.flightbookingservice.entity;

import java.sql.Date;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="flight_details")
public class FlightDetails {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	@Column(name="flight_id")
	private String flightId;
	
	@Column(name="flight_name")
	private String  flightName;
	
	@Column(name="boarding")
	private String boarding;
	
	@Column(name="destination")
	private String destination;
	
	@Column(name="date_of_journey")
	private LocalDate dateOfJourney;
	
	@Column(name="time_of_journey")
	private LocalTime timeOfJourney;
	
	@Column(name="price")
	private double price;
	
	@Column(name="duration")
	private double duration;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

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

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	
	
	public double getDuration() {
		return duration;
	}

	public void setDuration(double duration) {
		this.duration = duration;
	}

	@Override
	public String toString() {
		return "FlightDetails [id=" + id + ", flightId=" + flightId + ", flightName=" + flightName + ", boarding="
				+ boarding + ", destination=" + destination + ", dateOfJourney=" + dateOfJourney + ", timeOfJourney="
				+ timeOfJourney + ", price=" + price + ", duration=" + duration + "]";
	}

	
	
	
	

}
