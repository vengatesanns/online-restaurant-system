package com.hackprotech.securityservice.service;

import com.hackprotech.securityservice.model.AppUser;
import com.hackprotech.securityservice.request.UserRequest;
import org.springframework.security.core.userdetails.UserDetails;

public interface AppUserService {

    void signUpUser(UserRequest userRequest);

    AppUser validateLoginUser(String email);

}
