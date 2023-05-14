package com.venkatesh.springSecurity.service;

import com.venkatesh.springSecurity.model.User;
import org.springframework.stereotype.Service;

import java.util.List;

public interface UserService {

    public List<User> getUsers();

    public User getUserById(Long userId);

    public void updateUser(User user);

    public void createUser(User user);
}
