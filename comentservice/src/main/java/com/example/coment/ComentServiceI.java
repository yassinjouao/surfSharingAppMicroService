package com.example.coment;

import java.util.List;

public interface ComentServiceI {

    Coment addComent(Coment coment);

    Coment getComentById(Integer comentId);

    Coment updateComent(Integer comentId, Coment updatedComent);

    boolean deleteComent(Integer comentId);

    List<Coment> findAllComentsByContent(Integer contentId);

    List<Coment> getComentsByUserId(Integer userId);

    List<Coment> getComentsByContentId(Integer contentId);

    List<Coment> getAllComents();

    List<Coment> getComentsByUserAndContent(Integer userId, Integer contentId);
}

