package com.BudgetPulse.BudgetPulse_backend.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.BudgetPulse.BudgetPulse_backend.Models.Transaction;
import com.BudgetPulse.BudgetPulse_backend.Models.User;
import com.BudgetPulse.BudgetPulse_backend.Repository.TransactionRepository;
import com.BudgetPulse.BudgetPulse_backend.Repository.UserRepository;
import com.BudgetPulse.BudgetPulse_backend.Service.TransactionService;

@RestController
@CrossOrigin(origins = "http://localhost:8081")
@RequestMapping("/transaction/")
public class AddTransactionController {

	@Autowired
	private final TransactionRepository transactionRepository;
	
	@Autowired
	private TransactionService transactionService;
	
	@Autowired
	private UserRepository userRepository;

	public AddTransactionController(TransactionRepository transactionRepository) {
		super();
		this.transactionRepository = transactionRepository;
	}
	
	@PostMapping("/addTransaction")
	public ResponseEntity<String> addTransaction(@RequestBody Transaction transaction) {
	    if (transaction.getUser() == null || transaction.getUser().getId() == null) {
	        return ResponseEntity.badRequest().body("User information is missing");
	    }

	    int userId = transaction.getUser().getId();
	    Optional<User> userOptional = userRepository.findById(userId);

	    if (userOptional.isEmpty()) {
	        return ResponseEntity.badRequest().body("User not found");
	    }

	    transaction.setUser(userOptional.get());
	    transactionRepository.save(transaction);
	    return ResponseEntity.ok("Transaction Added Successfully");
	}

	@GetMapping("/user/{userId}")
    public ResponseEntity<List<Transaction>> getTransactionsByUser(@PathVariable Long userId) {
        List<Transaction> transactions = transactionService.getTransactionsByUserId(userId);
        return ResponseEntity.ok(transactions);
    }
	
	
}
