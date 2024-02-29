package org.surfsharing.groupeservice.userClient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.surfsharing.groupeservice.dto.UserDto;

import java.util.List;

@FeignClient(name = "identityservice")
public interface UserClient {
    @GetMapping("/users/alluser/{id}")
    UserDto findUserById(@PathVariable("id") Long id);

}

