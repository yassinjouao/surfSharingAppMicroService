package org.surfsharing.postservice.Dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.surfsharing.postservice.Entity.Enumuration.TypePost;

import java.util.ArrayList;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PostDto {

    private Long id ;
    private  Long idUser;
    private int liceCounter;
    private TypePost type;
    private String Content ;
    private Long idGroup;
    private ArrayList<String> comment=new ArrayList<>();
    private ArrayList<String>  likes=new ArrayList<>();
}
