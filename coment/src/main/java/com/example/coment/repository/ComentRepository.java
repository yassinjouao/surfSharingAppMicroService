package com.example.coment.repository;

import com.example.coment.entity.Coment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/*@Repository
public interface ComentRepository extends JpaRepository<Coment, Integer> {
    List<Coment> findAllBySchoolId(Integer schoolId);
}*/

public interface ComentRepository extends JpaRepository<Coment, Integer> {
    List<Coment> findAllByContentId(Integer contentId);

    List<Coment> findByUserId(Integer userId);

    List<Coment> findByContentId(Integer contentId);

    //List<Coment> findByDateRange(String startDate, String endDate);

    List<Coment> findByUserIdAndContentId(Integer userId, Integer contentId);

    // Ajoutez ici des méthodes personnalisées si nécessaire
}