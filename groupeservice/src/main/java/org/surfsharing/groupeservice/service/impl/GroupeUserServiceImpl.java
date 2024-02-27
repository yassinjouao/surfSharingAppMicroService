package org.surfsharing.groupeservice.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.surfsharing.groupeservice.dto.GroupeDto;
import org.surfsharing.groupeservice.dto.GroupeUserDto;
import org.surfsharing.groupeservice.entity.Groupe;
import org.surfsharing.groupeservice.entity.GroupeUser;
import org.surfsharing.groupeservice.repository.GroupeUserRepository;
import org.surfsharing.groupeservice.service.IGroupeUserService;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GroupeUserServiceImpl implements IGroupeUserService {

    @Autowired
    private GroupeUserRepository groupeUserRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public GroupeUserDto ajouterGroupe(GroupeUserDto groupeUserDto) {
        GroupeUser groupeUser = modelMapper.map(groupeUserDto , GroupeUser.class);
        GroupeUser saveGroupeUser = groupeUserRepository.save(groupeUser);
        return modelMapper.map(saveGroupeUser, GroupeUserDto.class);
    }

    @Override
    public List<GroupeUserDto> getGroupesUsers() {
        List<GroupeUser> groupesUsers = groupeUserRepository.findByDeletedFalse();
        return groupesUsers.stream()
                .map(groupeUser -> modelMapper.map(groupeUser , GroupeUserDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public GroupeUserDto getGroupesUsersById(Long id) {
        return groupeUserRepository.findByIdAndDeletedFalse(id)
                .map(groupeUser -> modelMapper.map(groupeUser , GroupeUserDto.class))
                .orElse(null);
    }

    @Override
    public GroupeUserDto updateGroupeUser(GroupeUserDto groupeUserDto, Long id) {
        GroupeUser existingGroupeUser = groupeUserRepository.findByIdAndDeletedFalse(id).orElse(null);

        if (existingGroupeUser != null) {
            existingGroupeUser.setUserId(groupeUserDto.getUserId());
            GroupeUser updatedGroupeUser = groupeUserRepository.save(existingGroupeUser);
            return modelMapper.map(updatedGroupeUser, GroupeUserDto.class);
        }

        return null;
    }

    @Override
    public void deleteGroupeUser(Long id) {
        GroupeUser groupeUser = groupeUserRepository.findByIdAndDeletedFalse(id).orElse(null);
        if (groupeUser != null){
            groupeUser.setDeleted(true);
            groupeUserRepository.save(groupeUser);
        }
    }
}
