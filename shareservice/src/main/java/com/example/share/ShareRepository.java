package com.example.share;

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