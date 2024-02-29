package org.surfsharing.exempleservice.UsedService;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "usedservice")
public interface UsedClient {
    @GetMapping("/api/v1/used/from")
    String fromUsedFunction();
}
