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

    @PostMapping()
    public ResponseEntity<Object> ajouterGroupeUser(@RequestBody GroupeUserDto groupeUserDto) {
        GroupeUserDto result = groupeUserService.ajouterGroupeUser(groupeUserDto);

        if (result == null) {
            return new ResponseEntity<>("User is already in the group", HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(result, HttpStatus.CREATED);
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

    @PutMapping("/update/{id}")
    public ResponseEntity<GroupeUserDto> updateGroupeUser(@PathVariable Long id, @RequestBody GroupeUserDto groupeUserDto) {
        GroupeUserDto updatedGroupeUser = groupeUserService.updateGroupeUser(groupeUserDto, id);
        if (updatedGroupeUser != null) {
            return new ResponseEntity<>(updatedGroupeUser, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteGroupeUser(@PathVariable Long id) {
        groupeUserService.deleteGroupeUser(id);
        return ResponseEntity.ok("GroupeUser with id " + id + " was deleted successfully");
    }
    @GetMapping
    public ResponseEntity<List<GroupeUserDto>> getGroupesUsers() {
        List<GroupeUserDto> groupesUsers = groupeUserService.getGroupesUsers();
        return new ResponseEntity<>(groupesUsers, HttpStatus.OK);
    }
    @GetMapping("/getUsersInGroup/{groupId}")
    public ResponseEntity<List<GroupeUserDto>> getUsersInGroup(@PathVariable Long groupId) {
        List<GroupeUserDto> usersInGroup = groupeUserService.getUsersInGroup(groupId);
        return new ResponseEntity<>(usersInGroup, HttpStatus.OK);
    }

}
