package net.hamzaouggadi.secure4j.services;

import net.hamzaouggadi.secure4j.entities.User;

import java.util.List;

public interface UserService {
    List<User> getUsers();
    User getUserById(Long userId);
    void addUser(User user);
    void deleteUserById(Long userId);
}
