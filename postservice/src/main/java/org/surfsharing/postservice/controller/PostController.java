package org.surfsharing.postservice.controller;


import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.surfsharing.postservice.dto.PostDto;
import org.surfsharing.postservice.service.impl.IpostService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/post")
@RequiredArgsConstructor
public class PostController {

    @Autowired
    private IpostService postService;
    @PostMapping
    public ResponseEntity<PostDto> addPost(@RequestBody PostDto postDto, HttpServletRequest request){
        Long adminid = Long.parseLong(request.getHeader("hid"));
        postDto.setUserId(adminid);
        PostDto post = postService.addPost(postDto);
        return new ResponseEntity<>(post, HttpStatus.CREATED);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePost(@PathVariable Long id,HttpServletRequest request){
       try{
           Long adminid = Long.parseLong(request.getHeader("hid"));
           postService.deletePost(id,adminid);
           return ResponseEntity.ok("Post with id " + id + " was deleted successfully");
       }catch (Exception e){
           return new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
       }
    }
    @GetMapping("allmyposts")
    public ResponseEntity<List<PostDto>> getAllMyPosts(HttpServletRequest request){
        Long adminid = Long.parseLong(request.getHeader("hid"));
        List<PostDto> posts = postService.getAllPosts(adminid);
        return new ResponseEntity<>(posts,HttpStatus.OK);
    }
    // DONE:
    // TO9OSSE
    // TODO:
    // service like mn 3nd sofia
    // linking likepost b chfanchtayger l posts
    // linking friends b chfanchtayger l users
    // ...

}
