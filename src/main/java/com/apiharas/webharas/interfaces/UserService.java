package com.apiharas.webharas.interfaces;
import com.apiharas.webharas.entity.Role;
import com.apiharas.webharas.entity.User;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public interface UserService {

    User saveUser(User user);
    Role saveRole(Role role);
    void addRoleToUser(String userName, String roleName);
    void refreshToken(String authorizationHeader, HttpServletRequest request, HttpServletResponse response) throws IOException;
    User getUser(String userName);
    List<User> getUsers();
}
