package org.surfsharing.postservice.service.impl;

import org.surfsharing.postservice.dto.PostDto;

import java.util.List;

public interface IpostService {
    PostDto addPost(PostDto postDto);
    void deletePost(Long id,Long adminid);
    PostDto updatePost(PostDto postDto,Long id,Long adminid);
    List<PostDto> getAllPosts(Long adminid);

}
