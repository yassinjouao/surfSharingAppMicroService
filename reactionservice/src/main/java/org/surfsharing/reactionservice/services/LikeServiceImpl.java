package org.surfsharing.reactionservice.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.surfsharing.reactionservice.dto.LikeDto;
import org.surfsharing.reactionservice.entity.Likes;
import org.surfsharing.reactionservice.repository.LikeRepository;

import java.util.List;

@Service
public class LikeServiceImpl implements ILikeservice {

    private final LikeRepository likeRepository;

    @Autowired
    public LikeServiceImpl(LikeRepository likeRepository) {
        this.likeRepository = likeRepository;
    }

    @Override
    public Likes addLike(LikeDto likeDTO) {
        Likes like = new Likes();
        like.setContentId(likeDTO.getIdPost());
        like.setUserId(likeDTO.getIdUser());
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
