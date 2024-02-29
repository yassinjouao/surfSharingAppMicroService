package com.example.share;

import com.example.share.dto.ShareDTO;
import com.example.share.entity.Shares;
import com.example.share.repository.ShareRepository;
import com.example.share.service.ShareService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ShareServiceTest {

    @Mock
    private ShareRepository shareRepository;

    @InjectMocks
    private ShareService shareService;

    private List<Shares> sharesList;


    @BeforeEach
    public void setUp() {
        // Vérifie si l'annotation @SetupRequired est présente
        if (isSetupRequired(getClass())) {
            sharesList = new ArrayList<>();
            when(shareRepository.save(ArgumentMatchers.any(Shares.class))).thenAnswer(invocation -> {
                Shares savedShares = invocation.getArgument(0);
                sharesList.add(savedShares);
                return savedShares;
            });
        }
       
    }
    @ShareServiceTest.SetupRequired
    @Test
    public void testAddShare() {

        sharesList = new ArrayList<>();
        when(shareRepository.save(ArgumentMatchers.any(Shares.class))).thenAnswer(invocation -> {
            Shares savedShares = invocation.getArgument(0);
            sharesList.add(savedShares);
            return savedShares;
        });

        ShareDTO shareDTO = new ShareDTO();
        shareDTO.setContentId(1L);
        shareDTO.setUserId(2L);


        Shares result = shareService.addShare(shareDTO);

        // Vérifie si le résultat n'est pas null avant d'effectuer les assertions
        assertNotNull(result, "La méthode addShare a retourné null");

        // Assert
        assertEquals(1L, result.getContentId());
        assertEquals(2L, result.getUserId());
        assertEquals(1, sharesList.size());
    }

    @Test
    public void testGetSharesByUserId() {

        Long userId = 1L;

        List<Shares> result = shareService.getSharesByUserId(userId);

        // Assert
        assertEquals(0, result.size());
    }

    @Test
    public void testGetSharesByContentId() {

        Long contentId = 1L;

        List<Shares> result = shareService.getSharesByContentId(contentId);

        // Assert
        assertEquals(0, result.size());
    }

    @Test
    public void testGetAllShares() {

        List<Shares> result = shareService.getAllShares();

        // Assert
        assertEquals(0, result.size());
    }

    // Méthode pour vérifier si l'annotation @SetupRequired est présente sur la classe
    private boolean isSetupRequired(Class<?> testClass) {
        return testClass.isAnnotationPresent(SetupRequired.class);
    }

    // Annotation personnalisée
    @Target(ElementType.METHOD)
    @Retention(RetentionPolicy.RUNTIME)
    public @interface SetupRequired {
    }
}
