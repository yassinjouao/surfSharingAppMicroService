package org.surfsharing.groupeservice.service;

import org.surfsharing.groupeservice.dto.GroupeDto;

import java.util.List;

public interface IGroupeService {
    GroupeDto ajouterGroupe(GroupeDto groupeDto);
    List<GroupeDto> getAllMyGroupes(Long id);
    GroupeDto getGroupeById(Long id);
    GroupeDto updateGroupe(GroupeDto groupeDto, Long id, Long adminid);
    void deleteGroupe(Long id, Long adminid);
}
