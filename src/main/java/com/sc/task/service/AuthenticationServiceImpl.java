package com.sc.task.service;


import com.sc.task.domain.User;
import com.sc.task.dto.LoginDto;
import com.sc.task.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

@Service
@Transactional
public class AuthenticationServiceImpl implements AuthenticationService {

    private Map<String, User> userMap = new ConcurrentHashMap<>();

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        return userRepository.findByUsernameEquals(s);
    }

    @Override
    public UserDetails getUserByToken(String token) {
        return userMap.get(token);
    }

    @Override
    public void addUserByToken(String token, User user) {
        userMap.put(token, user);
    }

    @Override
    public String login(LoginDto loginDto) {
        User user = (User) loadUserByUsername(loginDto.getLogin());
//jwt , токен

        return "token";
    }
}
