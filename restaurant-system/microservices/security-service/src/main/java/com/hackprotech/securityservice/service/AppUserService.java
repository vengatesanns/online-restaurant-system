package com.hackprotech.securityservice.service;

import com.hackprotech.securityservice.model.AppUser;
import com.hackprotech.securityservice.dto.UserRequest;

public interface AppUserService {

    void signUpUser(UserRequest userRequest);

    AppUser validateLoginUser(String email);

}
