package com.hcl.flightbookingservice.domain;

import javax.validation.constraints.NotNull;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Getter
@Setter
@NoArgsConstructor
public class Passenger {

	@NotNull(message = "Traveller Name is missing.")
	private String travellerName;

	@NotNull(message = "Traveller Age is missing.")
	private Integer travellerAge;
	
	@NotNull(message = "Traveller Meal Preferance is missing.")
	private String travellerMealPref;
	
	@NotNull(message = "Traveller Gender is missing.")
	private String travellerGender;
	
}
