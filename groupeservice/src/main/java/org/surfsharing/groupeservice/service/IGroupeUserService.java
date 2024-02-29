package org.surfsharing.groupeservice.service;

import org.surfsharing.groupeservice.dto.GroupeUserDto;

import java.util.List;

public interface IGroupeUserService {
    GroupeUserDto ajouterGroupeUser(GroupeUserDto groupeUserDto);

    List<GroupeUserDto> getGroupesUsers();

    GroupeUserDto getGroupesUsersById(Long id);

    GroupeUserDto updateGroupeUser(GroupeUserDto groupeUserDto, Long id);

    void deleteGroupeUser(GroupeUserDto groupeUserDto);
    List<GroupeUserDto> getUsersInGroup(Long groupId);
}
