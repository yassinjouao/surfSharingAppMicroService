package com.example.share.repository;

import com.example.share.entity.Shares;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface ShareRepository extends JpaRepository<Shares, Long> {
    List<Shares> findByUserId(Long userId);

    List<Shares> findByContentId(Long contentId);

}
