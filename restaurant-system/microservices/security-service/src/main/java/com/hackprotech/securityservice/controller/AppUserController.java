package com.hackprotech.securityservice.controller;

import com.hackprotech.securityservice.request.UserRequest;
import com.hackprotech.securityservice.service.AppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class AppUserController {

    @Autowired
    private AppUserService appUserService;

    @PostMapping("/register-user")
    public ResponseEntity<String> registerNewUser(@RequestBody UserRequest userRequest) {
        return ResponseEntity.ok("Hello Vengat!!!");
    }

    @GetMapping("/test")
    public ResponseEntity<String> registerNewUser() {
        return ResponseEntity.ok("Hello Vengat!!!");
    }
}
