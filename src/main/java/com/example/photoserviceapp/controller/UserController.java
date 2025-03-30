package com.example.photoserviceapp.controller;

import com.example.photoserviceapp.entity.User;
import com.example.photoserviceapp.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping("/users")
    public List<User> getAllUsers(){
        return userService.findAllUsers();
    }

    @GetMapping("/users/{login}")
    public User getUserByLogin(@PathVariable(name = "login") String login){
        return userService.findUserByLogin(login);
    }

    @PostMapping("/users")
    public User saveUser(@RequestBody User user){
        return userService.saveUser(user);
    }

    @PatchMapping("/users/{login}")
    public User updateUser(@PathVariable(name = "login") String login,
                                           @RequestBody User user){
        user.setLogin(login);
        return userService.updateUser(user);
    }

    @DeleteMapping("/users/{login}")
    public void deleteUser(@PathVariable(name = "login") String login){
        userService.deleteUser(login);
    }
}
