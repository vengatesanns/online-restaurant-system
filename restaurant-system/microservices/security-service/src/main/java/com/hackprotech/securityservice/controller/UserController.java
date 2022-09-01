package com.hackprotech.securityservice.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

//    @PostMapping("/register-new-user")
//    public ResponseEntity<String> registerNewUser(@RequestBody UserRequest userRequest) {
//        return ResponseEntity.ok("Hello Vengat!!!");
//    }

    @GetMapping("/register-new-user")
    public ResponseEntity<String> registerNewUser() {
        return ResponseEntity.ok("Hello Vengat!!!");
    }

}
