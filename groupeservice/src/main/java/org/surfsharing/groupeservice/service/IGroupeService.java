package org.surfsharing.groupeservice.service;

import org.surfsharing.groupeservice.dto.GroupeDto;

import java.util.List;

public interface IGroupeService {

    GroupeDto ajouterGroupe(GroupeDto groupeDto);

    List<GroupeDto> getGroupes();

    GroupeDto getGroupesById(Long id);

    GroupeDto updateGroupe(GroupeDto groupeDto, Long id);

    void deleteGroupe(Long id);
}
