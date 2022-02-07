package com.apiharas.webharas.service;

import com.apiharas.webharas.entity.Role;
import com.apiharas.webharas.entity.User;
import java.util.List;

public interface UserService {

    User saveUser(User user);
    Role saveRole(Role role);
    void addRoleToUser(String userName, String roleName);
    User getUser(String userName);
    List<User> getUsers();
}
