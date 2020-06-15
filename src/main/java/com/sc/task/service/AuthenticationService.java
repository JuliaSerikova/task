package com.sc.task.service;

import com.sc.task.domain.User;
import com.sc.task.dto.LoginDto;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface AuthenticationService extends UserDetailsService {
    UserDetails getUserByToken(String uuid);
    void addUserByToken(String token, User user);
    String login(LoginDto loginDto);
}
