package com.BudgetPulse.BudgetPulse_backend.Repository;

public class AuthenticationResponse {

	private String token;

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public AuthenticationResponse(String token) {
		super();
		this.token = token;
	}
	
	
	
	
	
}

