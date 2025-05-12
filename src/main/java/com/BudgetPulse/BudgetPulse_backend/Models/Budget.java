package com.BudgetPulse.BudgetPulse_backend.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "budgets")
public class Budget {
    
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private Double monthlyIncome;
	private String category;
	private Double budgetLimit;
	@ManyToOne
	@JoinColumn(name = "user_id", nullable = false)
	private User user;
	public Budget() {
		super();
	}
	public Budget(Integer id, Double monthlyIncome, String category, Double budgetLimit, User user) {
		super();
		this.id = id;
		this.monthlyIncome = monthlyIncome;
		this.category = category;
		this.budgetLimit = budgetLimit;
		this.user = user;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Double getMonthlyIncome() {
		return monthlyIncome;
	}
	public void setMonthlyIncome(Double monthlyIncome) {
		this.monthlyIncome = monthlyIncome;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public Double getBudgetLimit() {
		return budgetLimit;
	}
	public void setBudgetLimit(Double budgetLimit) {
		this.budgetLimit = budgetLimit;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	
	
}
