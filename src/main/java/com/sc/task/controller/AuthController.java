package com.sc.task.controller;

import com.sc.task.dto.LoginDto;
import com.sc.task.service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {

    @Autowired
    private AuthenticationService authenticationService;

    @PostMapping(value = "/login")
    public String login(@RequestBody LoginDto dto) {
        return authenticationService.login(dto);
    }
}
