package org.surfsharing.groupeservice.controller;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.surfsharing.groupeservice.dto.GroupeDto;
import org.surfsharing.groupeservice.service.IGroupeService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/grp/groupe")
@RequiredArgsConstructor
public class GroupeController {
    @Autowired
    private IGroupeService groupeService;
    @PostMapping
    public ResponseEntity<GroupeDto> ajouterGroupe(@RequestBody GroupeDto groupeDto,HttpServletRequest request) {
        Long adminid = Long.parseLong(request.getHeader("hid"));
        groupeDto.setAdminId(adminid);
        GroupeDto addedGroupe = groupeService.ajouterGroupe(groupeDto);
        return new ResponseEntity<>(addedGroupe, HttpStatus.CREATED);
    }
    //work
    @GetMapping("allmygroupes")
    public ResponseEntity<List<GroupeDto>> getAllMyGroupes(HttpServletRequest request) {
        Long adminid = Long.parseLong(request.getHeader("hid"));
        List<GroupeDto> groupes = groupeService.getAllMyGroupes(adminid);
        return new ResponseEntity<>(groupes, HttpStatus.OK);
    }
    //not yet
    @GetMapping("/{id}")
    public ResponseEntity<GroupeDto> getGroupeById(@PathVariable Long id) {
        GroupeDto groupe = groupeService.getGroupeById(id);
        if (groupe != null) {
            return new ResponseEntity<>(groupe, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    //work
    @PutMapping("/{id}")
    public ResponseEntity<?> updateGroupe(@RequestBody GroupeDto groupeDto, @PathVariable Long id,HttpServletRequest request) {
        try{
            Long adminid = Long.parseLong(request.getHeader("hid"));
            System.out.println("c"+ adminid);
            GroupeDto updatedGroupe = groupeService.updateGroupe(groupeDto, id,adminid);
            if (updatedGroupe != null) {
                return new ResponseEntity<>(updatedGroupe, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.OK);
        }
    }
    //work
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteGroupe(@PathVariable Long id,HttpServletRequest request) {
        try{
            Long adminid = Long.parseLong(request.getHeader("hid"));
            groupeService.deleteGroupe(id,adminid);
            return ResponseEntity.ok("Groupe with id " + id + " was deleted successfully");
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.OK);
        }



    }
    //test
    @GetMapping("/from")
    public ResponseEntity<String> fromUsedFunction(HttpServletRequest request) {
        int port = request.getLocalPort();
        System.out.println("test " + port);
        System.out.println("id = "+request.getHeader("hid"));
        System.out.println("username = "+request.getHeader("husername"));
        System.out.println("role = "+request.getHeader("hrole"));
        return ResponseEntity.ok("data of groupe, Running on port: " + port);
    }

}