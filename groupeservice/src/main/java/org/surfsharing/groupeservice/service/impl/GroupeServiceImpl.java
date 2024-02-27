package org.surfsharing.groupeservice.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.surfsharing.groupeservice.dto.GroupeDto;
import org.surfsharing.groupeservice.entity.Groupe;
import org.surfsharing.groupeservice.repository.GroupeRepository;
import org.surfsharing.groupeservice.service.IGroupeService;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GroupeServiceImpl implements IGroupeService {
    @Autowired
    private GroupeRepository groupeRepository;
    @Autowired
    private ModelMapper modelMapper;
    @Override
    public GroupeDto ajouterGroupe(GroupeDto groupeDto) {
        Groupe groupe = modelMapper.map(groupeDto , Groupe.class);
        Groupe saveGroupe = groupeRepository.save(groupe);
        return modelMapper.map(saveGroupe, GroupeDto.class);
    }

    @Override
    public List<GroupeDto> getGroupes() {
        List<Groupe> groupes = groupeRepository.findByDeletedFalse();
        return groupes.stream()
                .map(groupe -> modelMapper.map(groupe , GroupeDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public GroupeDto getGroupesById(Long id) {
        return groupeRepository.findByIdAndDeletedFalse(id)
                .map(groupe -> modelMapper.map(groupe , GroupeDto.class))
                .orElse(null);
    }

    @Override
    public GroupeDto updateGroupe(GroupeDto groupeDto, Long id) {
        Groupe existingGroupe = groupeRepository.findByIdAndDeletedFalse(id).orElse(null);

        if (existingGroupe != null) {
            existingGroupe.setTitle(groupeDto.getTitle());

            Groupe updatedGroupe = groupeRepository.save(existingGroupe);

            return modelMapper.map(updatedGroupe, GroupeDto.class);
        }

        return null;
    }

    @Override
    public void deleteGroupe(Long id) {
        Groupe groupe = groupeRepository.findByIdAndDeletedFalse(id).orElse(null);
        if (groupe != null){
            groupe.setDeleted(true);
            groupeRepository.save(groupe);
        }
    }
}
