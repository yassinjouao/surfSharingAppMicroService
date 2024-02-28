package org.surfsharing.groupeservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.surfsharing.groupeservice.dto.GroupeDto;
import org.surfsharing.groupeservice.service.IGroupeService;

import java.util.List;

@RestController
@RequestMapping("/api/groupes")
public class GroupeController {
    @Autowired
    private IGroupeService groupeService;

    @PostMapping
    public ResponseEntity<GroupeDto> ajouterGroupe(@RequestBody GroupeDto groupeDto) {
        GroupeDto addedGroupe = groupeService.ajouterGroupe(groupeDto);
        return new ResponseEntity<>(addedGroupe, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<GroupeDto>> getGroupes() {
        List<GroupeDto> groupes = groupeService.getGroupes();
        return new ResponseEntity<>(groupes, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<GroupeDto> getGroupeById(@PathVariable Long id) {
        GroupeDto groupe = groupeService.getGroupesById(id);
        if (groupe != null) {
            return new ResponseEntity<>(groupe, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<GroupeDto> updateGroupe(@RequestBody GroupeDto groupeDto, @PathVariable Long id) {
        GroupeDto updatedGroupe = groupeService.updateGroupe(groupeDto, id);
        if (updatedGroupe != null) {
            return new ResponseEntity<>(updatedGroupe, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteGroupe(@PathVariable Long id) {
        groupeService.deleteGroupe(id);
        return ResponseEntity.ok("GroupeUser with id " + id + " was deleted successfully");

    }
}
