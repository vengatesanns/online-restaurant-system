package com.hackprotech.securityservice.exceptions;

public class UserAlreadyExistsException extends RuntimeException {


    public UserAlreadyExistsException(String message) {
        super(message);
    }


}
