package com.example.photoserviceapp.repository;

import com.example.photoserviceapp.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Query(value = "select user from User user")
    List<User> findAll();

    @Query(value = "select user from User user where user.id =:id")
    Optional<User> findById(Long id);

    @Query(value = "select user from User user where user.login =:login")
    Optional<User> findByLogin(String login);
}
