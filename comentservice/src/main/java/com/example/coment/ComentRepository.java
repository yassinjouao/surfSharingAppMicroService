package com.example.coment;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/*@Repository
public interface ComentRepository extends JpaRepository<Coment, Integer> {
    List<Coment> findAllBySchoolId(Integer schoolId);
}*/
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ComentRepository extends JpaRepository<Coment, Integer> {
    List<Coment> findAllByContentId(Integer contentId);

    List<Coment> findByUserId(Integer userId);

    List<Coment> findByContentId(Integer contentId);

    //List<Coment> findByDateRange(String startDate, String endDate);

    List<Coment> findByUserIdAndContentId(Integer userId, Integer contentId);

    // Ajoutez ici des méthodes personnalisées si nécessaire
}