package com.BudgetPulse.BudgetPulse_backend.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.BudgetPulse.BudgetPulse_backend.Models.Budget;
import com.BudgetPulse.BudgetPulse_backend.Service.BudgetService;

@RestController
@CrossOrigin(origins = "http://localhost:8081")
@RequestMapping("/budget")
public class BudgetController {
	
	@Autowired
	private BudgetService budgetService;

	@PostMapping("/user/{userId}")
	public ResponseEntity<Budget> createBudgetForUser(@PathVariable Integer userId, @RequestBody Budget budget) {
	    Budget created = budgetService.createBudgetForUser(userId, budget);
	    return new ResponseEntity<>(created, HttpStatus.CREATED);
	}

	@GetMapping("/user/{userId}")
	public ResponseEntity<List<Budget>> getBudgetsByUser(@PathVariable Integer userId) {
	    return ResponseEntity.ok(budgetService.getBudgetsByUser(userId));
	}

	
}
