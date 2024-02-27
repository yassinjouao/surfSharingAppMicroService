package org.surfsharing.groupeservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.surfsharing.groupeservice.entity.Groupe;
import org.surfsharing.groupeservice.entity.GroupeUser;

import java.util.List;
import java.util.Optional;

public interface GroupeUserRepository extends JpaRepository<GroupeUser , Long> {
    List<GroupeUser> findByDeletedFalse();
    Optional<GroupeUser> findByIdAndDeletedFalse(Long id);
}
