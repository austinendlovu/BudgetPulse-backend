package com.BudgetPulse.BudgetPulse_backend.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.BudgetPulse.BudgetPulse_backend.Models.Budget;
import com.BudgetPulse.BudgetPulse_backend.Models.User;
import com.BudgetPulse.BudgetPulse_backend.Models.UserProfile;
import com.BudgetPulse.BudgetPulse_backend.Models.UserProfileRequest;
import com.BudgetPulse.BudgetPulse_backend.Repository.UserProfileRepository;
import com.BudgetPulse.BudgetPulse_backend.Repository.UserRepository;

import io.jsonwebtoken.io.IOException;

@Service
public class UserProfileService {

	@Autowired
	 private final UserRepository userRepository;
	private final UserProfileRepository userProfileRepository;
	 public UserProfileService(UserRepository userRepository, UserProfileRepository userProfileRepository) {
		super();
		this.userRepository = userRepository;
		this.userProfileRepository = userProfileRepository;
	}
	
	 public UserProfile createUserProfile(UserProfileRequest request, Long userId) throws IOException {
	        User user = userRepository.findById(userId)
	                .orElseThrow(() -> new RuntimeException("User not found"));
	        
	        UserProfile profile = new UserProfile();
	        profile.setFirstName(request.getFirstName());
	        profile.setLastName(request.getLastName());
	        profile.setMonthlyIncome(request.getMonthlyIncome());
	        profile.setPhoneNumber(request.getPhoneNumber());
	        profile.setUser(user);

	        return userProfileRepository.save(profile);
}

	 public Optional<UserProfile> getBudgetsByUser(Integer userId) {
		    return userProfileRepository.findById(userId);
		}

	public UserProfile save(UserProfile updatedProfile) {
		 
		return userProfileRepository.save(updatedProfile);
	}
}
