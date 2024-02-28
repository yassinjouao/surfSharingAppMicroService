package org.surfsharing.groupeservice.service;

import org.surfsharing.groupeservice.dto.GroupeUserDto;
import org.surfsharing.groupeservice.entity.GroupeUser;

import java.util.List;
import java.util.Optional;

public interface IGroupeUserService {
    GroupeUserDto ajouterGroupeUser(GroupeUserDto groupeUserDto);

    List<GroupeUserDto> getGroupesUsers();

    GroupeUserDto getGroupesUsersById(Long id);

    GroupeUserDto updateGroupeUser(GroupeUserDto groupeUserDto, Long id);

    void deleteGroupeUser(Long id);
    List<GroupeUserDto> getUsersInGroup(Long groupId);
}
