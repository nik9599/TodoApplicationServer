package com.example.spring_rest.service;

import com.example.spring_rest.Interfaces.ApiResponses;
import com.example.spring_rest.dto.ApiResponse;
import com.example.spring_rest.dto.LoginRequest;
import com.example.spring_rest.dto.LoginResponse;
import com.example.spring_rest.dto.SignupRequest;
import com.example.spring_rest.model.User;
import com.example.spring_rest.repo.AuthRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    private AuthRepo authRepo;


    public ApiResponses signupUser(SignupRequest loginData) {
        int resp = authRepo.signUpUser(loginData);

        if (resp > 0) {
            return new ApiResponse("Signup successful", 200);
        }

        return new ApiResponse("Signup failed", 400);
    }

    public LoginResponse loginUser (LoginRequest userResponse){
      User userData = authRepo.fetchUserByEmail(userResponse.getEmail());

      if(userData != null) {
          if (userData.getPassword().equals(userResponse.getPassword())) {
              return new LoginResponse(userData.getEmail(), userData.getUserName());
          }
      }
    return new LoginResponse("no data found", "null");
    }

}
