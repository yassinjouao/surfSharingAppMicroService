package org.surfsharing.identityservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.surfsharing.identityservice.entity.UserCredential;

import java.util.List;
import java.util.Optional;

public interface UserCredentialRepository extends JpaRepository<UserCredential,Integer> {
    Optional<UserCredential> findByName(String username);
    Boolean existsByName(String username);
    Boolean existsByEmail(String email);
}
