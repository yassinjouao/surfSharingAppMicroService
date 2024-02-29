package org.surfsharing.postservice.Dto.MapperPostDto;

import org.mapstruct.Mapper;
import org.surfsharing.postservice.Dto.PostDto;
import org.surfsharing.postservice.Entity.EntityPost;

import java.util.List;

@Mapper(componentModel="spring")
public interface IMapperPostDto {
    EntityPost toEntity(PostDto dto);
    PostDto toDTO(EntityPost entity);
    List<PostDto>toDTOS(List<EntityPost> dto);
}
