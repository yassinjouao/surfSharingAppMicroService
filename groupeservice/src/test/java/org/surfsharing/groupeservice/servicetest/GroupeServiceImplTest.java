package org.surfsharing.groupeservice.servicetest;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.surfsharing.groupeservice.dto.GroupeDto;
import org.surfsharing.groupeservice.service.impl.GroupeServiceImpl;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
@ExtendWith(SpringExtension.class)
class GroupeServiceImplTest {

    @Autowired
    private GroupeServiceImpl groupeService;

    private GroupeDto groupeDto;

    @BeforeEach
    void setUp() {
        groupeDto = new GroupeDto();
        groupeDto.setTitle("surf");
        groupeDto.setAdminId(2L);
        groupeDto = groupeService.ajouterGroupe(groupeDto);
    }

    @AfterEach
    void tearDown() {
        groupeService.deleteGroupe(groupeDto.getId(), groupeDto.getAdminId());
    }

    @Test
    void ajouterGroupe() {
        assertNotNull(groupeDto, "groupe not inserted");
        GroupeDto retrievedGroupeDto = groupeService.getGroupeById(groupeDto.getId());
        assertNotNull(retrievedGroupeDto, "Groupe not found in the database");
    }

    @Test
    void getAllMyGroupes() {
        List<GroupeDto> groupeDtos = groupeService.getAllMyGroupes(groupeDto.getAdminId());
        assertNotNull(groupeDtos, "List is empty");
    }

    @Test
    void getGroupeById() {
        GroupeDto retrievedGroupeDto = groupeService.getGroupeById(groupeDto.getId());
        assertNotNull(retrievedGroupeDto, "Groupe Not found");
    }

    @Test
    void updateGroupe() {
        groupeDto.setTitle("aa");
        GroupeDto updatedGroupeDto = groupeService.updateGroupe(groupeDto, groupeDto.getId(), groupeDto.getAdminId());
        assertEquals("aa", updatedGroupeDto.getTitle(), "title should be updated");
    }
}
