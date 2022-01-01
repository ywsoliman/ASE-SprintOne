package com.example.demo;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserLogin extends Login {

    public UserLogin(AppSystem system) {
        super.system = system;
    }

    @Override
    @PostMapping("/userlogin/{username}/{password}")
    public User login(@PathVariable String username,@PathVariable String password) {
        for (User user : system.retrieveUsers()) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                if(user.isSuspended()) {
                    System.out.println("This account is suspended.");
                    return null;
                }
                else {
                    System.out.println("Welcome " + user.getUsername() + ".");
                    return user;
                }
            }
        }
        System.out.println("No account found with these credentials");
        return null;
    }

}
