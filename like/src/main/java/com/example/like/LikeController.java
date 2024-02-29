package com.example.like;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/likes")
@RequiredArgsConstructor
public class LikeController {

    private final LikeServiceI likeService;
/*
    @Autowired
    public LikeController(LikeServiceI likeService) {
        this.likeService = likeService;
    }*/

    @PostMapping("/add")
    public ResponseEntity<Likes> addLike(@RequestBody LikeDTO likeDTO) {
        Likes savedLike = likeService.addLike(likeDTO);
        return new ResponseEntity<>(savedLike, HttpStatus.CREATED);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Likes>> getLikesByUserId(@PathVariable Long userId) {
        List<Likes> likes = likeService.getLikesByUserId(userId);
        return new ResponseEntity<>(likes, HttpStatus.OK);
    }

    @GetMapping("/content/{contentId}")
    public ResponseEntity<List<Likes>> getLikesByContentId(@PathVariable Long contentId) {
        List<Likes> likes = likeService.getLikesByContentId(contentId);
        return new ResponseEntity<>(likes, HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Likes>> getAllLikes() {
        List<Likes> likes = likeService.getAllLikes();
        return new ResponseEntity<>(likes, HttpStatus.OK);
    }

    // Ajoutez d'autres méthodes en fonction des besoins
}
