package com.example.photoserviceapp.exception;

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(String login){
        super("User with id %d is not found".formatted(login));
    }
}
