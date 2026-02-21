package com.example.spring_rest.controller;

import com.example.spring_rest.Interfaces.ApiResponses;
import com.example.spring_rest.dto.LoginRequest;
import com.example.spring_rest.dto.LoginResponse;
import com.example.spring_rest.dto.SignupRequest;
import com.example.spring_rest.model.User;
import com.example.spring_rest.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequestMapping("auth")
@RestController
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("login")
    public LoginResponse loginUser (@RequestBody LoginRequest userData){
       return authService.loginUser(userData);
    }

    @PostMapping("signup")
    public ApiResponses signUpUser (@RequestBody SignupRequest userData){
        return authService.signupUser(userData);
    }
}
