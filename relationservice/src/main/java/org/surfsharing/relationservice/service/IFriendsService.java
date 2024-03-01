package org.surfsharing.relationservice.service;

import org.surfsharing.relationservice.entites.Friends;

import java.util.List;

public interface IFriendsService {
    Friends addFriend(Long idSender, Long idReciever);
    Friends AccepteRelation(Long id, Long adminid);
    void deleteFriend(Long friendshipId);
    List<Friends> getAllFriends(Long id);
    List<Long> getAllidFriends(Long id);
    Friends getFriendById(Long friendId);
}
