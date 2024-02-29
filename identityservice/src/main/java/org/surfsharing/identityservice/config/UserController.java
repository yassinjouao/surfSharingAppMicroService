package org.surfsharing.identityservice.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.surfsharing.identityservice.entity.UserCredential;
import org.surfsharing.identityservice.repository.UserCredentialRepository;
import org.surfsharing.identityservice.service.AuthService;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private AuthService service;
    @Autowired
    UserCredentialRepository userCredentialRepository;
    @Autowired
    private UserCredentialRepository repository;
    @Autowired
    private AuthenticationManager authenticationManager;
    @GetMapping("/alluser/{id}")
    public ResponseEntity<?> findAllUsers(@PathVariable("id") Integer id
    ) {
        Optional<UserCredential> userCredential = repository.findById(id);
        if(userCredential.isPresent()){
            return ResponseEntity.ok(userCredential.get().getId());
        }else {
            return ResponseEntity.ok(null);
        }

    }
}
