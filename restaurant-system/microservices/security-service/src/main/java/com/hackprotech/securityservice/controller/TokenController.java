package com.hackprotech.securityservice.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TokenController {

    @GetMapping("/token")
    public ResponseEntity<String> checkToken() {
        return ResponseEntity.ok("Here is the new Token!!!");
    }

}
