package com.BudgetPulse.BudgetPulse_backend.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.BudgetPulse.BudgetPulse_backend.Models.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {

	 List<Transaction> findByUserId(Long userId);
}
