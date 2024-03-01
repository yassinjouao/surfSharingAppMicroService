package org.surfsharing.postservice.service.impl;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.surfsharing.postservice.LikeClient.LikeClient;
import org.surfsharing.postservice.dto.PostDto;
import org.surfsharing.postservice.entity.Post;
import org.surfsharing.postservice.repository.PostRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements IpostService{
    @Autowired
    private PostRepository postRepository;
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private LikeClient likeClient;

    @Override
    public PostDto addPost(PostDto postDto) {
        Post post = modelMapper.map(postDto,Post.class);
        Post savePost = postRepository.save(post);
        return modelMapper.map(savePost,PostDto.class);
    }

    @Override
    public void deletePost(Long id, Long adminid) {
        Post poste = postRepository.findById(id).orElse(null);
        if(!poste.getUserId().toString().equals(adminid.toString()))
        {
            throw new RuntimeException("Your are not eligible to delete this Post");
        }
        poste.setDeleted(true);
        postRepository.save(poste);
    }

    @Override
    public PostDto updatePost(PostDto postDto, Long id, Long adminid) {
        return null;
    }

    @Override
    public List<PostDto> getAllPosts(Long adminid) {
        List<Post> posts = postRepository.findByUserId(adminid);

        return posts.stream().map(post -> {
            PostDto postDto = modelMapper.map(post, PostDto.class);
            Integer likecounter = likeClient.getLikesByContentId(post.getId());
            postDto.setLikeCounter(likecounter);
            return postDto;
        }).collect(Collectors.toList());
    }
}
