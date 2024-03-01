package org.surfsharing.groupeservice.servicetest;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.surfsharing.groupeservice.dto.GroupeUserDto;
import org.surfsharing.groupeservice.entity.GroupeUser;
import org.surfsharing.groupeservice.repository.GroupeUserRepository;
import org.surfsharing.groupeservice.service.impl.GroupeUserServiceImpl;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

@SpringBootTest
@ExtendWith(SpringExtension.class)
class GroupeUserServiceImplTest {

    @Autowired
    private GroupeUserServiceImpl groupeUserService;

    private GroupeUserDto groupeUserDto;

    @BeforeEach
    void setUp() {
        groupeUserDto = new GroupeUserDto();
        groupeUserDto.setUserId(1L);
        groupeUserDto.setGroupeId(1L);
        groupeUserDto = groupeUserService.ajouterGroupeUser(groupeUserDto);
    }

    @AfterEach
    void tearDown() {
        groupeUserService.deleteGroupeUser(groupeUserDto);
    }

    @Test
    void ajouterGroupeUser() {
        assertNotNull(groupeUserDto, "groupeUser not inserted");
        GroupeUserDto retrievedGroupeUserDto = groupeUserService.getGroupesUsersById(groupeUserDto.getId());
        assertNotNull(retrievedGroupeUserDto, "GroupeUser not found in the database");
    }

    @Test
    void getGroupesUsers() {
        List<GroupeUserDto> groupeUserDtos = groupeUserService.getGroupesUsers();
        assertNotNull(groupeUserDtos, "List is empty");
    }

    @Test
    void getGroupesUsersById() {
        GroupeUserDto retrievedGroupeUserDto = groupeUserService.getGroupesUsersById(groupeUserDto.getId());
        assertNotNull(retrievedGroupeUserDto, "GroupeUser Not found");
    }

    @Test
    void updateGroupeUser() {
        groupeUserDto.setUserId(2L);
        GroupeUserDto updatedGroupeUserDto = groupeUserService.updateGroupeUser(groupeUserDto, groupeUserDto.getId());
        assertEquals(2L, updatedGroupeUserDto.getUserId(), "userId should be updated");
    }

    @Test
    void deleteGroupeUser() {
        Long groupeUserId = groupeUserDto.getId();
        assertNotNull(groupeUserService.getGroupesUsersById(groupeUserId), "groupeUser not found before deletion");
        groupeUserService.deleteGroupeUser(groupeUserDto);
        assertNull(groupeUserService.getGroupesUsersById(groupeUserId), "groupeUser not deleted");
    }

    @Test
    void getUsersInGroup() {
        Long groupId = groupeUserDto.getGroupeId();
        List<GroupeUserDto> groupUsers = groupeUserService.getUsersInGroup(groupId);
        assertNotNull(groupUsers, "List is empty");
        assertEquals(1, groupUsers.size(), "One user should be in the group");
    }
}