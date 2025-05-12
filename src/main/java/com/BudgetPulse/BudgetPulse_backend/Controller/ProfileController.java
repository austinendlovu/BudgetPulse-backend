package com.BudgetPulse.BudgetPulse_backend.Controller;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.BudgetPulse.BudgetPulse_backend.Models.UserProfile;
import com.BudgetPulse.BudgetPulse_backend.Models.UserProfileRequest;
import com.BudgetPulse.BudgetPulse_backend.Service.UserProfileService;

import io.jsonwebtoken.io.IOException;

@RestController
@CrossOrigin(origins = "http://localhost:8081")
@RequestMapping("/profile")
public class ProfileController {

	 private final UserProfileService userProfileService;

	public ProfileController(UserProfileService userProfileService) {
		super();
		this.userProfileService = userProfileService;
	}
    
	@PostMapping("/create/{userId}")
	public ResponseEntity<?> createProfile(@RequestBody UserProfileRequest request,
	                                       @PathVariable Long userId) throws IOException {
	    UserProfile profile = userProfileService.createUserProfile(request, userId);
	    return ResponseEntity.ok(profile);
	}
	
	@GetMapping("/user/{userId}")
	public ResponseEntity<UserProfile> getProfileByUser(@PathVariable Integer userId) {
	    Optional<UserProfile> userProfileOptional = userProfileService.getBudgetsByUser(userId);
	    
	    if (userProfileOptional.isPresent()) {
	        return ResponseEntity.ok(userProfileOptional.get());
	    } else {
	        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null); // Return 404 if profile not found
	    }
	}
	
	@PutMapping("/user/{userId}")
	public ResponseEntity<UserProfile> updateUserProfile(
	        @PathVariable Integer userId,
	        @RequestBody UserProfile updatedProfile) {

	    Optional<UserProfile> existingProfileOpt = userProfileService.getBudgetsByUser(userId);

	    if (existingProfileOpt.isEmpty()) {
	        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
	    }

	    UserProfile existingProfile = existingProfileOpt.get();

	    existingProfile.setFirstName(updatedProfile.getFirstName());
	    existingProfile.setLastName(updatedProfile.getLastName());
	    existingProfile.setMonthlyIncome(updatedProfile.getMonthlyIncome());
	    existingProfile.setPhoneNumber(updatedProfile.getPhoneNumber());

	    UserProfile savedProfile = userProfileService.save(existingProfile);

	    return ResponseEntity.ok(savedProfile);
	}



	
	  
}
