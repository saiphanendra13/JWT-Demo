package com.jwt.services;

import com.jwt.entities.User;

import java.util.List;

public interface UserService {


    User createUser(User User);

    User updateUser(User User, Integer userId);

    User getUserById(Integer userId);

    List<User> getAllUsers();

    void deleteUser(Integer userId);
}
