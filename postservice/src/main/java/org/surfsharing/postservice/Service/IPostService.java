package org.surfsharing.postservice.Service;

import org.surfsharing.postservice.Dto.PostDto;

import java.util.List;

public interface IPostService {
     PostDto save(PostDto entityPost);
    PostDto get(Long id);
    List<PostDto> getAll();
    PostDto update(Long id ,PostDto entityPost);
    void delete(Long id);
}
