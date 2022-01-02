package com.example.demo.Database;

import com.example.demo.Core.Ride;
import com.example.demo.Core.User;
import com.example.demo.Core.Driver;
import com.example.demo.Core.Member;

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
    public ArrayList<String> retrievePublicHolidays();

}
