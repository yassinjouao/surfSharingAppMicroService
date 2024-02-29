package org.surfsharing.postservice.Entity;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Data;
import lombok.extern.java.Log;
import org.surfsharing.postservice.Entity.Enumuration.TypePost;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Log
@Builder
public class EntityPost {
    @Id
    private Long id ;
    private  Long idUser;
    private int liceCounter;
    private TypePost type;
    private String Content ;
    private Long idGroup;
    @ElementCollection
    private ArrayList<String>  comment=new ArrayList<>();
    @ElementCollection
    private ArrayList<String>  likes=new ArrayList<>();








}
