package org.surfsharing.identityservice.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import org.surfsharing.identityservice.config.CustomUserDetails;
import org.surfsharing.identityservice.dto.AuthRequest;
import org.surfsharing.identityservice.entity.UserCredential;
import org.surfsharing.identityservice.enums.ERole;
import org.surfsharing.identityservice.repository.UserCredentialRepository;
import org.surfsharing.identityservice.service.AuthService;

import java.util.List;

@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    private AuthService service;
    @Autowired
    UserCredentialRepository userCredentialRepository;
    @Autowired
    private UserCredentialRepository repository;
    @Autowired
    private AuthenticationManager authenticationManager;

    @PostMapping("/register")
    public String addNewUser(@RequestBody UserCredential user) {
        if(userCredentialRepository.existsByName(user.getName())){
            return "Username is already taken!";
        }
        if(userCredentialRepository.existsByEmail(user.getEmail())){
            return "Email is already taken!";
        }
        return service.saveUser(user);
    }



    @PostMapping("/token")
    public String getToken(@RequestBody AuthRequest authRequest) {
        Authentication authenticate = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword()));
        if (authenticate.isAuthenticated()) {
            CustomUserDetails userDetails = (CustomUserDetails) authenticate.getPrincipal();
            ERole role = userDetails.getRole();
            int idUser = userDetails.getId();
            return service.generateToken(authRequest.getUsername(),role,idUser);

        } else {
            throw new RuntimeException("invalid access");
        }
    }

    @GetMapping("/validate")
    public String validateToken(@RequestParam("token") String token) {
        service.validateToken(token);
        return "Token is valid";
    }

}
