package org.surfsharing.relationservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.surfsharing.relationservice.entites.Friends;

import java.util.List;
import java.util.Optional;

public interface FriendsRepository extends JpaRepository<Friends,Long> {

    Optional<Friends> findByIdRecieverAndIdSender(Long idReciever, Long idSender);
    List<Friends> findAllByIdRecieverOrIdSenderAndStatusTrue(Long IdSender, Long idSender);
}
