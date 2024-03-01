package org.surfsharing.reactionservice.services;

import org.surfsharing.reactionservice.dto.LikeDto;
import org.surfsharing.reactionservice.entity.Likes;

import java.util.List;

public interface ILikeservice {
    Likes addLike(LikeDto likeDTO);
    List<Likes> getLikesByUserId(Long userId);
    List<Likes> getLikesByContentId(Long contentId);
    List<Likes> getAllLikes();
}