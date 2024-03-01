package org.surfsharing.reactionservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.surfsharing.reactionservice.entity.Likes;

import java.util.List;

public interface LikeRepository extends JpaRepository<Likes, Long> {
    List<Likes> findByUserId(Long userId);
    List<Likes> findByContentId(Long contentId);
}
