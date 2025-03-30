package com.example.photoserviceapp.exception;

public class UserAlreadyExistsException extends RuntimeException{
    public UserAlreadyExistsException(String login) {
        super("User with login %s is already exists.".
                formatted(login));
    }
}
