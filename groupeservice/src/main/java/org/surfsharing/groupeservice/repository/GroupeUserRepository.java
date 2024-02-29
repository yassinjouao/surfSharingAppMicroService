package org.surfsharing.groupeservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.surfsharing.groupeservice.entity.GroupeUser;

import java.util.List;
import java.util.Optional;

public interface GroupeUserRepository extends JpaRepository<GroupeUser , Long> {
    List<GroupeUser> findByDeletedFalse();
    Optional<GroupeUser> findByIdAndDeletedFalse(Long id);
    boolean existsByUserIdAndGroupeIdAndDeletedFalse(Long userId, Long groupeId);
    List<GroupeUser> findByGroupeIdAndDeletedFalse(Long groupId);
    Optional<GroupeUser> findGroupeUserByGroupeIdAndUserId(long groupId,Long userId);
    void deleteByGroupeIdAndUserId(Long groupId, Long userId);
}
