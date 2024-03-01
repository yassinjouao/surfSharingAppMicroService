package org.surfsharing.relationservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.surfsharing.relationservice.entites.Friends;
import org.surfsharing.relationservice.exeption.FriendsNotFoundException;
import org.surfsharing.relationservice.repository.FriendsRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class FriendsServiceImp implements IFriendsService{
    @Autowired
    private FriendsRepository friendsRepository;
    @Override
    public Friends addFriend(Long idSender, Long idReciever) {
        Friends newFriend = new Friends();
        newFriend.setIdSender(idSender);
        newFriend.setIdReciever(idReciever);
        newFriend.setStatus(false);

        return friendsRepository.save(newFriend);
    }

    @Override
    public Friends AccepteRelation(Long adminid, Long id) {
        Optional<Friends> friends = friendsRepository.findByIdRecieverAndIdSender(adminid,id);
        friends.get().setStatus(true);
        return friendsRepository.save(friends.get());

    }
    @Override
    public void deleteFriend(Long id) {

        friendsRepository.deleteById(id);
    }
    @Override
    public List<Friends> getAllFriends(Long id) {
        return friendsRepository.findAllByIdRecieverOrIdSenderAndStatusTrue(id,id);
    }

    @Override
    public List<Long> getAllidFriends(Long id) {
        List<Friends> F = friendsRepository.findAllByIdRecieverOrIdSenderAndStatusTrue(id, id);
        List<Long> idFriends = F.stream().map(friends -> {
                    if (friends.getIdReciever().equals(id)) {
                        return friends.getIdSender();
                    } else if (friends.getIdSender().equals(id)) {
                        return friends.getIdReciever();
                    }
                    return null;
                }).toList();
        return idFriends;
    }

    @Override
    public Friends getFriendById(Long friendId) {
        return null;
    }
}
