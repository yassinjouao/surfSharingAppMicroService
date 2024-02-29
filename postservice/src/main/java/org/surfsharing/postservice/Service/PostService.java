package org.surfsharing.postservice.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.surfsharing.postservice.Dto.PostDto;
import org.surfsharing.postservice.Dto.MapperPostDto.IMapperPostDto;
import org.surfsharing.postservice.Entity.EntityPost;
import org.surfsharing.postservice.Repostry.EntityPostRepository;

import java.util.List;

@Service
public class PostService implements IPostService{

    @Autowired
    private EntityPostRepository  entityPost;
    @Autowired
    private IMapperPostDto mapper;


    @Override
    public PostDto save(PostDto entityPost) {

        EntityPost post=EntityPost.builder()
                .idGroup(entityPost.getIdGroup())
                .Content(entityPost.getContent())
                .idUser(entityPost.getIdUser())
                .liceCounter(entityPost.getLiceCounter())
                .likes(entityPost.getLikes())
                .comment(entityPost.getComment())
                .type(entityPost.getType()).build();


        return mapper.toDTO(post);
    }

    @Override
    public PostDto get(Long id) {
        EntityPost post = entityPost.getById(id);
        return mapper.toDTO(post);
    }

    @Override
    public List<PostDto> getAll() {
        List<EntityPost> posts=entityPost.findAll();

        return mapper.toDTOS(posts);
    }

    @Override
    public PostDto update(Long id ,PostDto entityPost) {
        EntityPost post=EntityPost.builder()
                .id(id)
                .idGroup(entityPost.getIdGroup())
                .Content(entityPost.getContent())
                .idUser(entityPost.getIdUser())
                .liceCounter(entityPost.getLiceCounter())
                .likes(entityPost.getLikes())
                .comment(entityPost.getComment())
                .type(entityPost.getType()).build();


        return mapper.toDTO(post);
    }

    @Override
    public void delete(Long id) {
          entityPost.deleteById(id);
    }
}
