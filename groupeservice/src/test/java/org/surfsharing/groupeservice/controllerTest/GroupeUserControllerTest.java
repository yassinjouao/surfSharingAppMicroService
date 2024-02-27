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
import org.surfsharing.groupeservice.dto.GroupeUserDto;
import org.surfsharing.groupeservice.service.IGroupeUserService;
import org.surfsharing.groupeservice.controller.GroupeUserController;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class GroupeUserControllerTest {

    @Mock
    private IGroupeUserService groupeUserService;

    @InjectMocks
    private GroupeUserController groupeUserController;

    private final MockMvc mockMvc;
    private final ObjectMapper objectMapper;

    public GroupeUserControllerTest() {
        this.mockMvc = MockMvcBuilders.standaloneSetup(new GroupeUserController()).build();
        this.objectMapper = new ObjectMapper();
    }

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void ajouterGroupeUser() {
        GroupeUserDto groupeUserDto = new GroupeUserDto();
        when(groupeUserService.ajouterGroupe(any())).thenReturn(groupeUserDto);

        ResponseEntity<GroupeUserDto> responseEntity = groupeUserController.ajouterGroupeUser(groupeUserDto);

        assertResponse(HttpStatus.CREATED, responseEntity, groupeUserDto);
        verify(groupeUserService, times(1)).ajouterGroupe(any());
    }

    @Test
    void getGroupesUsers() {
        List<GroupeUserDto> groupeUserDtos = Arrays.asList(new GroupeUserDto(), new GroupeUserDto());
        when(groupeUserService.getGroupesUsers()).thenReturn(groupeUserDtos);

        ResponseEntity<List<GroupeUserDto>> responseEntity = groupeUserController.getGroupesUsers();

        assertResponse(HttpStatus.OK, responseEntity, groupeUserDtos);
        verify(groupeUserService, times(1)).getGroupesUsers();
    }

    @Test
    void getGroupeUserById() {
        Long id = 1L;
        GroupeUserDto groupeUserDto = new GroupeUserDto();
        when(groupeUserService.getGroupesUsersById(id)).thenReturn(groupeUserDto);

        ResponseEntity<GroupeUserDto> responseEntity = groupeUserController.getGroupeUserById(id);

        assertResponse(HttpStatus.OK, responseEntity, groupeUserDto);
        verify(groupeUserService, times(1)).getGroupesUsersById(id);
    }

    @Test
    void updateGroupeUser() {
        Long id = 1L;
        GroupeUserDto groupeUserDto = new GroupeUserDto();
        when(groupeUserService.updateGroupeUser(any(), eq(id))).thenReturn(groupeUserDto);

        ResponseEntity<GroupeUserDto> responseEntity = groupeUserController.updateGroupeUser(groupeUserDto, id);

        assertResponse(HttpStatus.OK, responseEntity, groupeUserDto);
        verify(groupeUserService, times(1)).updateGroupeUser(any(), eq(id));
    }

    @Test
    void deleteGroupeUser() {
        Long id = 1L;
        doNothing().when(groupeUserService).deleteGroupeUser(id);

        ResponseEntity<Void> responseEntity = groupeUserController.deleteGroupeUser(id);

        assertEquals(HttpStatus.NO_CONTENT, responseEntity.getStatusCode());
        verify(groupeUserService, times(1)).deleteGroupeUser(id);
    }

    private <T> void assertResponse(HttpStatus expectedStatus, ResponseEntity<T> responseEntity, T expectedBody) {
        assertEquals(expectedStatus, responseEntity.getStatusCode());
        assertEquals(expectedBody, responseEntity.getBody());
    }
}
