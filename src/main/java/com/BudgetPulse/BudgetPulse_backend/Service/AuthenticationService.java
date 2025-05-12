package com.BudgetPulse.BudgetPulse_backend.Service;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.BudgetPulse.BudgetPulse_backend.Models.User;
import com.BudgetPulse.BudgetPulse_backend.Repository.AuthenticationResponse;
import com.BudgetPulse.BudgetPulse_backend.Repository.UserRepository;



@Service
public class AuthenticationService {

    private final UserRepository repository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public AuthenticationService(
        AuthenticationManager authenticationManager,
        UserRepository repository,
        PasswordEncoder passwordEncoder,
        JwtService jwtService
    ) {
        this.repository = repository;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
        this.authenticationManager = authenticationManager;
    }

    public AuthenticationResponse register(User request) {
        User user = new User();
        
        user.setEmail(request.getEmail());
        user.setUsername(request.getUsername());

        // Fix: Encode the password from requests
        user.setPassword(passwordEncoder.encode(request.getPassword()));

        // Fix: Set role from request
        user.setRole(request.getRole());

        user = repository.save(user);

        String token = jwtService.generateToken(user);

        return new AuthenticationResponse(token);
    }

    public AuthenticationResponse authenticate(User request) {
        authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(
                request.getUsername(),
                request.getPassword()
            )
        );

        User user = repository.findByUsername(request.getUsername()).orElseThrow();
        String token = jwtService.generateToken(user);

        return new AuthenticationResponse(token);
    }
}

