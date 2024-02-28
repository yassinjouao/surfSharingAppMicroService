package com.example.coment;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class ComentServiceTest {

    @Mock
    private ComentRepository comentRepository;

    @InjectMocks
    private ComentService comentService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testAddComent() {
        // Arrange
        Coment newComent = new Coment();
        when(comentRepository.save(any(Coment.class))).thenReturn(newComent);

        // Act
        Coment addedComent = comentService.addComent(newComent);

        // Assert
        assertNotNull(addedComent);
        verify(comentRepository, times(1)).save(any(Coment.class));
    }

    @Test
    void testGetComentById() {
        // Arrange
        int comentId = 1;
        Coment expectedComent = new Coment();
        when(comentRepository.findById(comentId)).thenReturn(Optional.of(expectedComent));

        // Act
        Coment result = comentService.getComentById(comentId);

        // Assert
        assertNotNull(result);
        assertSame(expectedComent, result);
        verify(comentRepository, times(1)).findById(comentId);
    }

    // Ajoutez des tests similaires pour les autres méthodes du service

    @Test
    void testDeleteComent() {
        // Arrange
        int comentId = 1;
        when(comentRepository.existsById(comentId)).thenReturn(true);

        // Act
        boolean result = comentService.deleteComent(comentId);

        // Assert
        assertTrue(result);
        verify(comentRepository, times(1)).existsById(comentId);
        verify(comentRepository, times(1)).deleteById(comentId);
    }

    @Test
    void testFindAllComentsByContent() {
        // Arrange
        int contentId = 1;
        List<Coment> expectedComents = Arrays.asList(new Coment(), new Coment());
        when(comentRepository.findAllByContentId(contentId)).thenReturn(expectedComents);

        // Act
        List<Coment> result = comentService.findAllComentsByContent(contentId);

        // Assert
        assertNotNull(result);
        assertEquals(expectedComents.size(), result.size());
        verify(comentRepository, times(1)).findAllByContentId(contentId);
    }

    @Test
    void testGetComentsByUserId() {
        // Arrange
        int userId = 1;
        List<Coment> expectedComents = Arrays.asList(new Coment(), new Coment());
        when(comentRepository.findByUserId(userId)).thenReturn(expectedComents);

        // Act
        List<Coment> result = comentService.getComentsByUserId(userId);

        // Assert
        assertNotNull(result);
        assertEquals(expectedComents.size(), result.size());
        verify(comentRepository, times(1)).findByUserId(userId);
    }

    @Test
    void testGetComentsByContentId() {
        // Arrange
        int contentId = 1;
        List<Coment> expectedComents = Arrays.asList(new Coment(), new Coment());
        when(comentRepository.findByContentId(contentId)).thenReturn(expectedComents);

        // Act
        List<Coment> result = comentService.getComentsByContentId(contentId);

        // Assert
        assertNotNull(result);
        assertEquals(expectedComents.size(), result.size());
        verify(comentRepository, times(1)).findByContentId(contentId);
    }

    @Test
    void testGetAllComents() {
        // Arrange
        List<Coment> expectedComents = Arrays.asList(new Coment(), new Coment());
        when(comentRepository.findAll()).thenReturn(expectedComents);

        // Act
        List<Coment> result = comentService.getAllComents();

        // Assert
        assertNotNull(result);
        assertEquals(expectedComents.size(), result.size());
        verify(comentRepository, times(1)).findAll();
    }

    @Test
    void testUpdateComent() {
        // Arrange
        int comentId = 1;
        Coment existingComent = new Coment();
        existingComent.setId(comentId);
        existingComent.setText("Old text");

        Coment updatedComent = new Coment();
        updatedComent.setText("New text");

        when(comentRepository.findById(comentId)).thenReturn(Optional.of(existingComent));
        when(comentRepository.save(any(Coment.class))).thenAnswer(invocation -> invocation.getArgument(0));

        // Act
        Coment result = comentService.updateComent(comentId, updatedComent);

        // Assert
        assertNotNull(result);
        assertEquals(updatedComent.getText(), result.getText());
        verify(comentRepository, times(1)).findById(comentId);
        verify(comentRepository, times(1)).save(any(Coment.class));
    }
}
