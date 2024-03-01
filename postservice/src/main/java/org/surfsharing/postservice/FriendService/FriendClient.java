package org.surfsharing.postservice.FriendService;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "relationservice")
public interface FriendClient {
    @GetMapping("/api/v1/friends/allIds/{id}")
    List<Long> getAllIdFriends(@PathVariable Long id);
}
