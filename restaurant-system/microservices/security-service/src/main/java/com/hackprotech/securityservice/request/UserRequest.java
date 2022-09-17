package com.hackprotech.securityservice.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserRequest {

    private String firstName;
    private String lastName;
    private String password;
    private String email;
    private Integer phoneNumber;


}
