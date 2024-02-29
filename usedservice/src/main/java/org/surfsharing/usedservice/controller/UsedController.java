package org.surfsharing.usedservice.controller;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.Value;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/used")
@RequiredArgsConstructor
public class UsedController {
    @Autowired
    Environment environment;
    @GetMapping("/from")
    public ResponseEntity<String> fromUsedFunction(HttpServletRequest request) {
        int port = request.getLocalPort();
        System.out.println("test " + port);
        return ResponseEntity.ok("data of BOOK-SERVICE, Running on port: " + port);
    }
}
