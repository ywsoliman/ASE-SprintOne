package com.example.demo.Database;

import com.example.demo.Core.Ride;
import com.example.demo.Core.User;
import com.example.demo.Core.Driver;
import com.example.demo.Core.Member;

import java.util.ArrayList;

public class ArrayStrategy implements SaveStrategy {

    ArrayList<User> users;
    ArrayList<Driver> drivers;
    ArrayList<Ride> rides;
    ArrayList<String> discountedAreas;
    ArrayList<String> publicHolidays;

    public ArrayStrategy() {
        users = new ArrayList<User>();
        drivers = new ArrayList<Driver>();
        rides = new ArrayList<Ride>();
        discountedAreas = new ArrayList<String>();
        publicHolidays = new ArrayList<>();
        publicHolidays.add("25/01");
        publicHolidays.add("07/01");
        publicHolidays.add("15/09");
        publicHolidays.add("19/07");
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
            if(!driver.isVerified()) {
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
        for (User user : users) {
            if (user.getUsername().equals(username)) {
                return user;
            }
        }
        return null;
    }

    @Override
    public Member searchDriver(String username) {
        for (Driver driver : drivers) {
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

    @Override
    public ArrayList<String> retrievePublicHolidays() {
        return publicHolidays;
    }
}