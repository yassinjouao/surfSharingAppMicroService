package com.example.like;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LikeService implements LikeServiceI {

    private final LikeRepository likeRepository;

    @Autowired
    public LikeService(LikeRepository likeRepository) {

        this.likeRepository = likeRepository;
    }

    @Override
    public Likes addLike(LikeDTO likeDTO) {
        Likes like = new Likes();
        like.setContentId(likeDTO.getContentId());
        like.setUserId(likeDTO.getUserId());
        return likeRepository.save(like);
    }

    @Override
    public List<Likes> getLikesByUserId(Long userId) {
        return likeRepository.findByUserId(userId);
    }

    @Override
    public List<Likes> getLikesByContentId(Long contentId) {
        return likeRepository.findByContentId(contentId);
    }

    @Override
    public List<Likes> getAllLikes() {
        return likeRepository.findAll();
    }

}


/*
@Service
public class ComentService {

    private final ComentRepository comentRepository;

    @Autowired
    public ComentService(ComentRepository comentRepository) {
        this.comentRepository = comentRepository;
    }

    public Coment addComent(Coment coment) {
        return comentRepository.save(coment);
    }

    public Coment getComentById(Integer comentId) {
        Optional<Coment> optionalComent = comentRepository.findById(comentId);
        return optionalComent.orElse(null);
    }

    public Coment updateComent(Integer comentId, Coment updatedComent) {
        Optional<Coment> optionalComent = comentRepository.findById(comentId);
        if (optionalComent.isPresent()) {
            Coment existingComent = optionalComent.get();
            existingComent.setText(updatedComent.getText());
            return comentRepository.save(existingComent);
        } else {
            return null;
        }
    }

    public boolean deleteComent(Integer comentId) {
        if (comentRepository.existsById(comentId)) {
            comentRepository.deleteById(comentId);
            return true;
        } else {
            return false;
        }
    }

    public List<Coment> findAllComentsByContent(Integer contentId) {

        return comentRepository.findAllByContentId(contentId);
    }

    public List<Coment> getComentsByUserId(Integer userId) {
        // Récupérer tous les commentaires de l'utilisateur avec l'ID spécifié
        return comentRepository.findByUserId(userId);
    }

    public List<Coment> getComentsByContentId(Integer contentId) {
        // Récupérer tous les commentaires associés au contenu avec l'ID spécifié
        return comentRepository.findByContentId(contentId);
    }

    public List<Coment> getAllComents() {
        // Récupérer tous les commentaires de la base de données
        return comentRepository.findAll();
    }
/*
    public List<Coment> getComentsByDateRange(String startDate, String endDate) {
        // Récupérer tous les commentaires dans une plage de dates spécifiée
        return comentRepository.findByDateRange(startDate, endDate);
    }*/
/*
    public List<Coment> getComentsByUserAndContent(Integer userId, Integer contentId) {
        // Récupérer tous les commentaires de l'utilisateur sur le contenu spécifié
        return comentRepository.findByUserIdAndContentId(userId, contentId);
    }

}


/*@Service
@RequiredArgsConstructor
public class ComentService {

    private final ComentRepository repository;

    public void saveComent(Coment coment){
        repository.save(coment);
    }

    public List<Coment> findAllComents(){
        return repository.findAll();
    }

    public List<Coment> findAllComentsBySchool(Integer schoolId) {
        return repository.findAllBySchoolId(schoolId);
    }
}
*/