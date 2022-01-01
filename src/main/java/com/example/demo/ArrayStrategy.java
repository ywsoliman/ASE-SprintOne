package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

public class ArrayStrategy implements SaveStrategy {

    AppSystem system ;
    ArrayList<User> users = new ArrayList<User>();
    ArrayList<Driver> drivers = new ArrayList<Driver>();
    ArrayList<Ride> rides = new ArrayList<Ride>();
    ArrayList<String> discountedAreas = new ArrayList<String>();

    public ArrayStrategy(AppSystem system) {
        this.system = AppSystem.getAppSystem();
    }

    @Override
    public void saveUser(User user) {
        users.add(user);
    }

    @Override
    public void saveDriver(Driver driver) {
        drivers.add(driver);
    }

    @Override
    public ArrayList<Driver> retrieveDrivers() {
        return drivers;
    }

    @Override
    public ArrayList<Driver> retrievePendingRegistrations() {
        ArrayList<Driver> pendingRegistrations = new ArrayList<Driver>();
        for(Driver driver : drivers) {
            if(!driver.verified) {
                pendingRegistrations.add(driver);
            }
        }
        return pendingRegistrations;
    }

    @Override
    public ArrayList<User> retrieveUsers() {
        return users;
    }

    @Override
    public Member searchUser(String username) {
        for (User user : system.retrieveUsers()) {
            if (user.getUsername().equals(username)) {
                return user;
            }
        }
        return null;
    }

    @Override
    public Member searchDriver(String username) {
        for (Driver driver : system.retrieveDrivers()) {
            if (driver.getUsername().equals(username)) {
                return driver;
            }
        }
        return null;
    }

    @Override
    public ArrayList<Ride> retrieveRides() {
        return rides;
    }

    @Override
    public ArrayList<String> retrieveDiscountedAreasCopy() {
        ArrayList<String> discountedCopy = discountedAreas;
        return discountedCopy;
    }

    @Override
    public ArrayList<String> retrieveDiscountedAreas() {
        return discountedAreas;
    }

}