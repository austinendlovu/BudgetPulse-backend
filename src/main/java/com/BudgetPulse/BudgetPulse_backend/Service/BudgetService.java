package com.BudgetPulse.BudgetPulse_backend.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.BudgetPulse.BudgetPulse_backend.Models.Budget;
import com.BudgetPulse.BudgetPulse_backend.Models.User;
import com.BudgetPulse.BudgetPulse_backend.Repository.UserRepository;
import com.BudgetPulse.BudgetPulse_backend.Repository.budgetRepository;

@Service
public class BudgetService {

	 @Autowired
	 private budgetRepository budgetRepository;
	 
	 @Autowired
	 private UserRepository userRepository;
	 
	 public Budget createBudgetForUser(Integer userId, Budget budget) {
		    User user = userRepository.findById(userId)
		        .orElseThrow(() -> new RuntimeException("User not found"));

		    budget.setUser(user);
		    return budgetRepository.save(budget);

}
	 public List<Budget> getBudgetsByUser(Integer userId) {
		    return budgetRepository.findByUserId(userId);
		}
}