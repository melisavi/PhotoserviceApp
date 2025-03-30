package com.example.photoserviceapp.service;

import com.example.photoserviceapp.entity.User;

import java.util.List;

public interface UserService {
    List<User> findAllUsers();
    User findUserByLogin(String login);
    User saveUser(User user);
    User updateUser(User user);
    void deleteUser(String login);
}
