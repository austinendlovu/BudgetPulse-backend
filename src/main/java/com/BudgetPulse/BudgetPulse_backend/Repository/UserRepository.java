package com.BudgetPulse.BudgetPulse_backend.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.BudgetPulse.BudgetPulse_backend.Models.User;

public interface UserRepository extends JpaRepository<User, Integer> {
	
	Optional<User> findByUsername(String username);
	Optional<User> findById(Long userId);

}
