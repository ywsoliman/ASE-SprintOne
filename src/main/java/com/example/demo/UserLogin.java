package com.example.demo;

public class UserLogin extends Login {

    public UserLogin(AppSystem system) {
        super.system = system;
    }

    @Override
    public User login(String username, String password) {
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
