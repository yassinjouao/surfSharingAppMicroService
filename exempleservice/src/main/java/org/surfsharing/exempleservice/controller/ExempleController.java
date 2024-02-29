package org.surfsharing.exempleservice.controller;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.surfsharing.exempleservice.UsedService.UsedClient;

@RestController
@RequestMapping("/api/v1/exemple")
@RequiredArgsConstructor
public class ExempleController {
    private final UsedClient usedClient;
    @GetMapping("/getusername")
    public ResponseEntity<String> findAllStudents(HttpServletRequest request) {
        System.out.println("id = "+request.getHeader("hid"));
        System.out.println("username = "+request.getHeader("husername"));
        System.out.println("role = "+request.getHeader("hrole"));
        String fromusedString = usedClient.fromUsedFunction();

        return ResponseEntity.ok(fromusedString);
//        return request.getHeader("husername" + fromusedString);
//        return request.getHeader("husername");
    }
}
