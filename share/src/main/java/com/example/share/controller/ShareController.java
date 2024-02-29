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
