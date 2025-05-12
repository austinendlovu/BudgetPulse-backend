package com.BudgetPulse.BudgetPulse_backend.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.BudgetPulse.BudgetPulse_backend.Models.Budget;
import com.BudgetPulse.BudgetPulse_backend.Models.User;

public interface budgetRepository extends JpaRepository<Budget, Integer>{

	List<Budget> findByUser(User user); 

	 List<Budget> findByUserId(Integer userId);
}
