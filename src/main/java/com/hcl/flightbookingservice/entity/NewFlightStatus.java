package com.hcl.flightbookingservice.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "newflightstatus")
public class NewFlightStatus {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String flightId;

	private String flightName;

	private String boarding;

	private String destination;

	@Column(name = "flight_request_status")
	private String flightRequestStatus = "Pending";

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
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

	public String getFlightRequestStatus() {
		return flightRequestStatus;
	}

	public void setFlightRequestStatus(String flightRequestStatus) {
		this.flightRequestStatus = flightRequestStatus;
	}

}
