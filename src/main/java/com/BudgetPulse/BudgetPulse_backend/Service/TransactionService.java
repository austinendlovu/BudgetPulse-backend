package com.BudgetPulse.BudgetPulse_backend.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.BudgetPulse.BudgetPulse_backend.Models.Transaction;
import com.BudgetPulse.BudgetPulse_backend.Repository.TransactionRepository;

@Service
public class TransactionService {

	 @Autowired
	    private TransactionRepository transactionRepository;

	    public List<Transaction> getTransactionsByUserId(Long userId) {
	        return transactionRepository.findByUserId(userId);
	    }
}
