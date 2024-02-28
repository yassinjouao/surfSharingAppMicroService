package com.example.like;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.lenient;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class LikeServiceTest {

    @Mock
    private LikeRepository likeRepository;

    @InjectMocks
    private LikeService likeService;

    @BeforeEach
    public void setUp() {
        // Configurer le comportement de likeRepository.save
        lenient().when(likeRepository.save(any(Likes.class))).thenAnswer(invocation -> invocation.getArgument(0));

        // Configurer le comportement de likeRepository.findByUserId
        lenient().when(likeRepository.findByUserId(1L)).thenReturn(createMockLikesList());

        // Configurer le comportement de likeRepository.findByContentId
        lenient().when(likeRepository.findByContentId(1L)).thenReturn(createMockLikesList());

        // Configurer le comportement de likeRepository.findAll
        lenient().when(likeRepository.findAll()).thenReturn(createMockLikesList());
    }

    @Test
    public void testAddLike() {
        LikeDTO likeDTO = new LikeDTO();
        likeDTO.setContentId(1L);
        likeDTO.setUserId(2L);

        Likes result = likeService.addLike(likeDTO);

        assertEquals(1L, result.getContentId());
        assertEquals(2L, result.getUserId());
    }

    @Test
    public void testGetLikesByUserId() {
        Long userId = 1L;

        List<Likes> result = likeService.getLikesByUserId(userId);

        assertEquals(2, result.size()); // Assurez-vous d'ajuster cela selon le comportement attendu
    }

    @Test
    public void testGetLikesByContentId() {
        Long contentId = 1L;

        List<Likes> result = likeService.getLikesByContentId(contentId);

        assertEquals(2, result.size()); // Assurez-vous d'ajuster cela selon le comportement attendu
    }

    @Test
    public void testGetAllLikes() {
        List<Likes> result = likeService.getAllLikes();

        assertEquals(2, result.size()); // Assurez-vous d'ajuster cela selon le comportement attendu
    }

    // Méthode utilitaire pour créer une liste fictive de Likes
    private List<Likes> createMockLikesList() {
        List<Likes> likesList = new ArrayList<>();
        Likes like1 = new Likes();
        like1.setContentId(1L);
        like1.setUserId(1L);
        Likes like2 = new Likes();
        like2.setContentId(1L);
        like2.setUserId(2L);
        likesList.add(like1);
        likesList.add(like2);
        return likesList;
    }
}