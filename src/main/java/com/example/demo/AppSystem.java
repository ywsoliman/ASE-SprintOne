package com.example.demo;

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
        Driver newDriver = driver;
        saveStrategy.saveDriver(newDriver);
    }
    //@GetMapping("/drivers/pending-registration")
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
    //@GetMapping("/rides")
    public ArrayList<Ride> retrieveRides() {
        return saveStrategy.retrieveRides();
    }
    void addDiscountedArea(String destination) {
        saveStrategy.retrieveDiscountedAreas().add(destination);
    }


//    public static void main(String[] args) {
//
//        Menu menu = new Menu();
//
//    }
}