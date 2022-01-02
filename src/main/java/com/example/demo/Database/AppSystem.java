package com.example.demo.Database;

import com.example.demo.Core.Driver;
import com.example.demo.Core.Ride;
import com.example.demo.Core.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class AppSystem {
    static SaveStrategy saveStrategy;
    private static  AppSystem appSystem;

    private AppSystem(){
    }

    public  static AppSystem getAppSystem(){
        if(appSystem == null){
            appSystem = new AppSystem();
            saveStrategy = new ArrayStrategy();
        }
        return appSystem;
    }
    public void setSaveStrategy(SaveStrategy saveStrategy) {
        this.saveStrategy = saveStrategy;
    }
    @PostMapping("/add/user")
    public static void saveUser(@RequestBody User user) {
        saveStrategy.saveUser(user);
    }
    @PostMapping("/add/driver")
    public static void saveDriver(@RequestBody Driver driver) {
        saveStrategy.saveDriver(driver);
    }
    public ArrayList<Driver> retrievePendingRegistrations() {
        return saveStrategy.retrievePendingRegistrations();
    }
    @GetMapping("/users")
    public static ArrayList<User> retrieveUsers() {
        return saveStrategy.retrieveUsers();
    }
    @GetMapping("/drivers")
    public static ArrayList<Driver> retrieveDrivers() {
        return saveStrategy.retrieveDrivers();
    }
    public ArrayList<Ride> retrieveRides() {
        return saveStrategy.retrieveRides();
    }
    public void addDiscountedArea(String destination) {
        saveStrategy.retrieveDiscountedAreas().add(destination);
    }
    public ArrayList<String> retrieveDiscountedAreasCopy(){
        return saveStrategy.retrieveDiscountedAreasCopy();
    }

    public ArrayList<String> retrievePublicHolidays(){
        return saveStrategy.retrievePublicHolidays();
    }

}