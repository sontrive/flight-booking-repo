package com.hcl.flightbookingservice.domain;

import javax.validation.constraints.NotNull;

public class Passenger {

	@NotNull(message = "Traveller Name is missing.")
	private String travellerName;

	@NotNull(message = "Traveller Age is missing.")
	private Integer travellerAge;
	
	@NotNull(message = "Traveller Meal Preferance is missing.")
	private String travellerMealPref;
	
	@NotNull(message = "Traveller Gender is missing.")
	private String travellerGender;

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
	
	
	
}
