package org.surfsharing.relationservice.controller;


import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.surfsharing.relationservice.entites.Friends;
import org.surfsharing.relationservice.service.IFriendsService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/friends")
public class FriendsController {
    @Autowired
    private IFriendsService friendsService;
    @GetMapping("/send/{receiver}")
    public ResponseEntity<Friends> addFriend(@PathVariable Long receiver, HttpServletRequest request) {
        Long sender = Long.parseLong(request.getHeader("hid"));
        Friends newFriend = friendsService.addFriend(sender, receiver);
        return new ResponseEntity<>(newFriend, HttpStatus.CREATED);
    }
    @GetMapping("/accept/{id}")
    public ResponseEntity<String> acceptFriend(@PathVariable Long id, HttpServletRequest request){
        Long adminid = Long.parseLong(request.getHeader("hid"));
        Friends friends = friendsService.AccepteRelation(adminid,id);
        return new ResponseEntity<>("accepted", HttpStatus.CREATED);
    }
    @GetMapping("/all")
    public List<Friends> getAllFriends(HttpServletRequest request){
        Long adminid = Long.parseLong(request.getHeader("hid"));
        return friendsService.getAllFriends(adminid);
    }
    @GetMapping("/allIds/{id}")
    public List<Long> getAllIdFriends(@PathVariable Long id){

        return friendsService.getAllidFriends(id);
    }
}
