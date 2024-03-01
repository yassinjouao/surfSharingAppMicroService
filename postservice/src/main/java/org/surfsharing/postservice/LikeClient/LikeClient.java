package org.surfsharing.postservice.LikeClient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.surfsharing.postservice.dto.LikeDto;

@FeignClient(name = "reactionservice")
public interface LikeClient {
    @GetMapping("/api/v1/likes/add/{idPost}/{idUser}")
    LikeDto addLike(@PathVariable("idPost") Long idPost,@PathVariable("idUser") Long idUser);
    @GetMapping("/api/v1/likes/post/{idPost}")
    Integer getLikesByContentId(@PathVariable Long idPost);
}


