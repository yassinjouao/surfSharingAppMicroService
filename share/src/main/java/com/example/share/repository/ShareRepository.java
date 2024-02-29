package com.example.share.repository;

import com.example.share.entity.Shares;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/*@Repository
public interface ComentRepository extends JpaRepository<Coment, Integer> {
    List<Coment> findAllBySchoolId(Integer schoolId);
}*/

public interface ShareRepository extends JpaRepository<Shares, Long> {
    List<Shares> findByUserId(Long userId);

    List<Shares> findByContentId(Long contentId);

}