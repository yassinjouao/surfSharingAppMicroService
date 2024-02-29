package org.surfsharing.groupeservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.surfsharing.groupeservice.entity.Groupe;

import java.util.List;
import java.util.Optional;

public interface GroupeRepository extends JpaRepository<Groupe , Long> {
    List<Groupe> findByDeletedFalse();
    Optional<Groupe> findByIdAndDeletedFalse(Long id);
    List<Groupe> findByAdminId(Long id);
}
