package com.hackprotech.securityservice.controller;

import com.hackprotech.securityservice.dto.UserRequest;
import com.hackprotech.securityservice.service.AppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class AppUserController {

    @Autowired
    private AppUserService appUserServiceImpl;

    @PostMapping("/sign-up")
    public ResponseEntity<String> registerNewUser(@RequestBody UserRequest userRequest) {
        appUserServiceImpl.signUpUser(userRequest);
        return ResponseEntity.ok("User Created Successfully!!!");
    }

    @PutMapping("/profile/update")
    public ResponseEntity<String> profileUpdate(@RequestBody UserRequest userRequest) {
        appUserServiceImpl.profileUpdate(userRequest);
        return ResponseEntity.ok().body("Profile Updated!");
    }

    @GetMapping("/login")
    public ResponseEntity<String> registerNewUser1() {
        return ResponseEntity.ok("Hello Vengat!!!");
    }
}
