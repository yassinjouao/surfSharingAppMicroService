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


