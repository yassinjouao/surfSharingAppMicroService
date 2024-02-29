package com.example.share.controller;

import com.example.share.dto.ShareDTO;
import com.example.share.entity.Shares;
import com.example.share.service.ShareServiceI;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/shares")
@RequiredArgsConstructor
public class ShareController {

    private final ShareServiceI shareService;
/*
    @Autowired
    public LikeController(LikeServiceI likeService) {
        this.likeService = likeService;
    }*/

    @PostMapping("/add")
    public ResponseEntity<Shares> addShare(@RequestBody ShareDTO shareDTO) {
        Shares savedShare = shareService.addShare(shareDTO);
        return new ResponseEntity<>(savedShare, HttpStatus.CREATED);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Shares>> getSharesByUserId(@PathVariable Long userId) {
        List<Shares> shares = shareService.getSharesByUserId(userId);
        return new ResponseEntity<>(shares, HttpStatus.OK);
    }

    @GetMapping("/content/{contentId}")
    public ResponseEntity<List<Shares>> getSharesByContentId(@PathVariable Long contentId) {
        List<Shares> shares = shareService.getSharesByContentId(contentId);
        return new ResponseEntity<>(shares, HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Shares>> getAllShares() {
        List<Shares> shares = shareService.getAllShares();
        return new ResponseEntity<>(shares, HttpStatus.OK);
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