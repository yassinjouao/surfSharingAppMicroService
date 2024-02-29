package org.surfsharing.postservice.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.surfsharing.postservice.Dto.PostDto;
import org.surfsharing.postservice.Service.PostService;

import java.util.List;

@RestController
@RequestMapping("/posts")
public class PostController {

    private final PostService postService;

    @Autowired
    public PostController(PostService postService) {
        this.postService = postService;
    }

    @PostMapping("/create")
    public PostDto createPost(@RequestBody PostDto postDto) {
        return postService.save(postDto);
    }

    @GetMapping
    public List<PostDto> getAllPosts() {
        return postService.getAll();
    }

    @GetMapping("/{id}")
    public PostDto getPostById(@PathVariable Long id) {
        return postService.get(id);
    }

    @PutMapping("/update/{id}")
    public PostDto updatePost(@PathVariable Long id, @RequestBody PostDto postDto) {
        return postService.update(id, postDto);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<String> deletePost(@PathVariable Long id) {
        postService.delete(id);
        return ResponseEntity.ok("POst deleted");


    }
}

