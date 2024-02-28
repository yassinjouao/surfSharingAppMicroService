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
/*
public class ComentController {

    //@Autowired
    private final ComentService service;

    @PostMapping("/add")
    public ResponseEntity<Coment> addComent(@RequestBody Coment coment) {
        Coment savedComent = service.addComent(coment);
        return new ResponseEntity<>(savedComent, HttpStatus.CREATED);
    }

    @GetMapping("/{comentId}")
    public ResponseEntity<Coment> getComentById(@PathVariable Integer comentId) {
        Coment coment = service.getComentById(comentId);
        if (coment != null) {
            return new ResponseEntity<>(coment, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/update/{comentId}")
    public ResponseEntity<Coment> updateComent(@PathVariable Integer comentId, @RequestBody Coment updatedComent) {
        Coment coment = service.updateComent(comentId, updatedComent);
        if (coment != null) {
            return new ResponseEntity<>(coment, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/delete/{comentId}")
    public ResponseEntity<Void> deleteComent(@PathVariable Integer comentId) {
        boolean deleted = service.deleteComent(comentId);
        if (deleted) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/content/{content-id}")
    public ResponseEntity<List<Coment>> fingAllComentsByContentId(
            @PathVariable("content-id") Integer contentId
    ){
        List<Coment> comments = service.getComentsByContentId(contentId);
        return new ResponseEntity<>(comments, HttpStatus.OK);
       // return ResponseEntity.ok(service.findAllComentsByContent(contentId));

    }

    @GetMapping("/all")
    public ResponseEntity<List<Coment>> getAllComents() {
        List<Coment> coments = service.getAllComents();
        System.out.println(" *******getAllComents***");

        return new ResponseEntity<>(coments, HttpStatus.OK);
    }
/*
    @GetMapping("/dateRange")
    public ResponseEntity<List<Coment>> getComentsByDateRange(
            @RequestParam("startDate") String startDate,
            @RequestParam("endDate") String endDate) {
        List<Coment> coments = service.getComentsByDateRange(startDate, endDate);
        return new ResponseEntity<>(coments, HttpStatus.OK);
    }
*//*
    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Coment>> getComentsByUserId(@PathVariable Integer userId) {
        List<Coment> comments = service.getComentsByUserId(userId);
        return new ResponseEntity<>(comments, HttpStatus.OK);
    }

    @GetMapping("/user/{userId}/content/{contentId}")
    public ResponseEntity<List<Coment>> getComentsByUserAndContent(
            @PathVariable Integer userId,
            @PathVariable Integer contentId) {
        List<Coment> coments = service.getComentsByUserAndContent(userId, contentId);
        return new ResponseEntity<>(coments, HttpStatus.OK);
    }

}*/