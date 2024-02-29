package org.surfsharing.identityservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.surfsharing.identityservice.entity.UserCredential;
import org.surfsharing.identityservice.enums.ERole;
import org.surfsharing.identityservice.repository.UserCredentialRepository;

@Service
public class AuthService {
    @Autowired
    private UserCredentialRepository repository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private JwtService jwtService;

    public String saveUser(UserCredential credential){
        credential.setPassword(passwordEncoder.encode(credential.getPassword()));
        repository.save(credential);
        return "User added to the system";
    }
    public String generateToken(String username, ERole role, int idUser) {
        return jwtService.generateToken(username,role,idUser);
    }

    public void validateToken(String token) {
        jwtService.validateToken(token);
    }
}
