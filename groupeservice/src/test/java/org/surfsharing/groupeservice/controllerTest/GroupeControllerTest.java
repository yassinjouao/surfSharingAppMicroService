package org.surfsharing.groupeservice.controllerTest;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.surfsharing.groupeservice.dto.GroupeDto;
import org.surfsharing.groupeservice.service.IGroupeService;
import org.surfsharing.groupeservice.controller.GroupeController;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class GroupeControllerTest {

    @Mock
    private IGroupeService groupeService;

    @InjectMocks
    private GroupeController groupeController;

    private final MockMvc mockMvc;
    private final ObjectMapper objectMapper;

    public GroupeControllerTest() {
        // Use new GroupeController() instead of groupeController
        this.mockMvc = MockMvcBuilders.standaloneSetup(new GroupeController()).build();
        this.objectMapper = new ObjectMapper();
    }

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void ajouterGroupe() {
        GroupeDto groupeDto = new GroupeDto();
        when(groupeService.ajouterGroupe(any())).thenReturn(groupeDto);

        ResponseEntity<GroupeDto> responseEntity = groupeController.ajouterGroupe(groupeDto);

        assertResponse(HttpStatus.CREATED, responseEntity, groupeDto);
        verify(groupeService, times(1)).ajouterGroupe(any());
    }

    @Test
    void getGroupes() {
        List<GroupeDto> groupeDtos = Arrays.asList(new GroupeDto(), new GroupeDto());
        when(groupeService.getGroupes()).thenReturn(groupeDtos);

        ResponseEntity<List<GroupeDto>> responseEntity = groupeController.getGroupes();

        assertResponse(HttpStatus.OK, responseEntity, groupeDtos);
        verify(groupeService, times(1)).getGroupes();
    }

    @Test
    void getGroupeById() {
        Long id = 1L;
        GroupeDto groupeDto = new GroupeDto();
        when(groupeService.getGroupesById(id)).thenReturn(groupeDto);

        ResponseEntity<GroupeDto> responseEntity = groupeController.getGroupeById(id);

        assertResponse(HttpStatus.OK, responseEntity, groupeDto);
        verify(groupeService, times(1)).getGroupesById(id);
    }

    @Test
    void updateGroupe() {
        Long id = 1L;
        GroupeDto groupeDto = new GroupeDto();
        when(groupeService.updateGroupe(any(), eq(id))).thenReturn(groupeDto);

        ResponseEntity<GroupeDto> responseEntity = groupeController.updateGroupe(groupeDto, id);

        assertResponse(HttpStatus.OK, responseEntity, groupeDto);
        verify(groupeService, times(1)).updateGroupe(any(), eq(id));
    }

    @Test
    void deleteGroupe() {
        Long id = 1L;
        doNothing().when(groupeService).deleteGroupe(id);

        ResponseEntity<String> responseEntity = groupeController.deleteGroupe(id);

        assertEquals(HttpStatus.NO_CONTENT, responseEntity.getStatusCode());
        assertEquals("Groupe with id " + id + " was deleted successfully", responseEntity.getBody());
        verify(groupeService, times(1)).deleteGroupe(id);
    }

    private <T> void assertResponse(HttpStatus expectedStatus, ResponseEntity<T> responseEntity, T expectedBody) {
        assertEquals(expectedStatus, responseEntity.getStatusCode());
        assertEquals(expectedBody, responseEntity.getBody());
    }
}
