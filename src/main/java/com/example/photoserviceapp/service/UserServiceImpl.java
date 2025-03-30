package com.example.photoserviceapp.service;

import com.example.photoserviceapp.entity.User;
import com.example.photoserviceapp.exception.UserAlreadyExistsException;
import com.example.photoserviceapp.exception.UserNotFoundException;
import com.example.photoserviceapp.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> findAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User findUserByLogin(String login) {
        if (!existsUserByLogin(login)){
            throw new UserNotFoundException(login);
        }
        return userRepository.findByLogin(login).orElseThrow();
    }

    @Override
    public User saveUser(User user) {
        if (existsUserByLogin(user.getLogin())) {
            throw new UserAlreadyExistsException(user.getLogin());
        }
        return userRepository.save(user);
    }

    @Override
    public User updateUser(User user) {
        if (!existsUserByLogin(user.getLogin())) {
            throw new UserNotFoundException(user.getLogin());
        } else {
            user.setId(userRepository.findByLogin(user.getLogin()).get().getId());
        }
        return userRepository.save(user);
    }

    @Override
    public void deleteUser(String login) {
        if (!existsUserByLogin(login)){
            throw new UserNotFoundException(login);
        }
        userRepository.deleteById(userRepository.findByLogin(login).get().getId());
    }

    public boolean existsUserByLogin(String login) {
        if (!userRepository.findByLogin(login).isEmpty()) {
            return true;
        }
        return false;
    }
}
