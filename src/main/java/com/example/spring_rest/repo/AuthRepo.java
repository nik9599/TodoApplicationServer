package com.example.spring_rest.repo;

import com.example.spring_rest.model.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public class AuthRepo {
    List<User> userDetails = new ArrayList<>(Arrays.asList(
            new User(1 , "Tester", "test@gmailcom", "T@123"),
            new User(2 , "Tester-1", "test@gmailcom", "T@123"),
            new User(3 , "Tester-2", "test@gmailcom", "T@123"),
            new User(4 , "Tester-3", "test@gmailcom", "T@123"),
            new User(5 , "Tester-4", "test@gmailcom", "T@123")
    ));

    public int signUpUser(User loginData) {
        userDetails.add(loginData);
        return 1;
    }


    public User fetchUserByEmail(String email) {
        for (User user : userDetails) {
            if (email.equals(user.getEmail())) {
                return user;
            }
        }
        return null; // user not found
    }
}
