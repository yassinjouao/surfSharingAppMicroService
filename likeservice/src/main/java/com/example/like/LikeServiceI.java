package com.example.like;

import java.util.List;

public interface LikeServiceI {
    Likes addLike(LikeDTO likeDTO);

    List<Likes> getLikesByUserId(Long userId);

    List<Likes> getLikesByContentId(Long contentId);

    List<Likes> getAllLikes();

}