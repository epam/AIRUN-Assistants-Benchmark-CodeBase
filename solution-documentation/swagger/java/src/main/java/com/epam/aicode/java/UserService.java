package com.epam.aicode.java;

import java.util.List;
import org.springframework.stereotype.Service;

@Service
public interface UserService {

    User createUser(User user);

    User getUser(Long id);

    List<User> getAllUsers();

    User updateUser(Long id, User user);

    void deleteUser(Long id);
}
