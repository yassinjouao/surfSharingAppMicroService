package com.example.like;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface LikeRepository extends JpaRepository<Likes, Long> {
    List<Likes> findByUserId(Long userId);

    List<Likes> findByContentId(Long contentId);

}
