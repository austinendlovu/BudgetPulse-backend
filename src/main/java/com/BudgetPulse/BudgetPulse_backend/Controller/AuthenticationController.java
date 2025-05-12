package com.BudgetPulse.BudgetPulse_backend.Controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.BudgetPulse.BudgetPulse_backend.Models.User;
import com.BudgetPulse.BudgetPulse_backend.Repository.AuthenticationResponse;
import com.BudgetPulse.BudgetPulse_backend.Service.AuthenticationService;

import java.util.HashMap;
import java.util.Map;

@RestController
@CrossOrigin(origins = "http://localhost:8081")
@RequestMapping("/auth/")
public class AuthenticationController {
    private final AuthenticationService authenticationService;

    public AuthenticationController(AuthenticationService authenticationService) {
        super();
        this.authenticationService = authenticationService;
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(
            @RequestBody User request
    ) {
        AuthenticationResponse response = authenticationService.register(request);

        Map<String, Object> body = new HashMap<>();
        body.put("message", "You have successfully registered!");
        body.put("authenticationResponse", response); // Optionally include the original response

        return new ResponseEntity<>(body, HttpStatus.OK);
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody User request) {
        AuthenticationResponse response = authenticationService.authenticate(request);

        Map<String, Object> body = new HashMap<>();
        body.put("message", "You have successfully logged in!");
        body.put("authenticationResponse", response); // Optionally include the original response

        return new ResponseEntity<>(body, HttpStatus.OK);
    }
}