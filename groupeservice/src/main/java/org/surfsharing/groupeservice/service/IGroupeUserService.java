package org.surfsharing.groupeservice.service;

import org.surfsharing.groupeservice.dto.GroupeDto;
import org.surfsharing.groupeservice.dto.GroupeUserDto;

import java.util.List;

public interface IGroupeUserService {

    GroupeUserDto ajouterGroupe(GroupeUserDto groupeUserDto);

    List<GroupeUserDto> getGroupesUsers();

    GroupeUserDto getGroupesUsersById(Long id);

    GroupeUserDto updateGroupeUser(GroupeUserDto groupeUserDto, Long id);

    void deleteGroupeUser(Long id);
}
