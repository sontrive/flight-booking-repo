package com.hcl.flightbookingservice.domain;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Data
@Getter
@Setter
@NoArgsConstructor
public class LoginDTO {

	private Integer loginId;
	private String userName;
	private String password;
	private String role;



	@Override
	public String toString() {
		return "Login [loginId=" + loginId + ", userName=" + userName + "]";
	}

}
