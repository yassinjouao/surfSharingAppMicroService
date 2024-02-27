package org.surfsharing.groupeservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.surfsharing.groupeservice.dto.GroupeUserDto;
import org.surfsharing.groupeservice.service.IGroupeUserService;

import java.util.List;

@RestController
@RequestMapping("/api/groupe-users")
public class GroupeUserController {

    @Autowired
    private IGroupeUserService groupeUserService;

    @PostMapping
    public ResponseEntity<GroupeUserDto> ajouterGroupeUser(@RequestBody GroupeUserDto groupeUserDto) {
        GroupeUserDto addedGroupeUser = groupeUserService.ajouterGroupe(groupeUserDto);
        return new ResponseEntity<>(addedGroupeUser, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<GroupeUserDto>> getGroupesUsers() {
        List<GroupeUserDto> groupesUsers = groupeUserService.getGroupesUsers();
        return new ResponseEntity<>(groupesUsers, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<GroupeUserDto> getGroupeUserById(@PathVariable Long id) {
        GroupeUserDto groupeUser = groupeUserService.getGroupesUsersById(id);
        if (groupeUser != null) {
            return new ResponseEntity<>(groupeUser, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<GroupeUserDto> updateGroupeUser(@RequestBody GroupeUserDto groupeUserDto, @PathVariable Long id) {
        GroupeUserDto updatedGroupeUser = groupeUserService.updateGroupeUser(groupeUserDto, id);
        if (updatedGroupeUser != null) {
            return new ResponseEntity<>(updatedGroupeUser, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteGroupeUser(@PathVariable Long id) {
        groupeUserService.deleteGroupeUser(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
