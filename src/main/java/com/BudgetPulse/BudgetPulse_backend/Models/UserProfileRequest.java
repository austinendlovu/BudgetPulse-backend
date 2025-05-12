package com.BudgetPulse.BudgetPulse_backend.Models;

import org.springframework.web.multipart.MultipartFile;

public class UserProfileRequest {

	private String firstName;
    private String lastName;
    private Double monthlyIncome;
    private String phoneNumber;
    private MultipartFile image;
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public Double getMonthlyIncome() {
		return monthlyIncome;
	}
	public void setMonthlyIncome(Double monthlyIncome) {
		this.monthlyIncome = monthlyIncome;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public MultipartFile getImage() {
		return image;
	}
	public void setImage(MultipartFile image) {
		this.image = image;
	}
    
    
    
}
