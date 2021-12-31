package com.example.demo;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;

public interface SaveStrategy {
    public void saveUser(User user);
    public void saveDriver(Driver driver);
    public ArrayList<Driver> retrieveDrivers();
    public ArrayList<Driver> retrievePendingRegistrations();
    public ArrayList<User> retrieveUsers();
    public Member searchUser(String username);
    public Member searchDriver(String username);
    public ArrayList<Ride> retrieveRides();
    public ArrayList<String> retrieveDiscountedAreasCopy();
    public ArrayList<String> retrieveDiscountedAreas();
}
