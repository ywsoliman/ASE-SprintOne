package com.example.demo;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class Admin {
    AppSystem system;

    public Admin(AppSystem system) {
        this.system = system;
    }

    @PutMapping("/drivers/verify/{username}")
    public void verifyDriver(@PathVariable String username) {
        for (Driver driver : system.retrieveDrivers()) {
            if (driver.getUsername().equals(username))
                driver.setVerified(true);
        }
    }
    @PutMapping("/drivers/suspend/{username}")
    public void suspendDriver(@PathVariable String username) {
        for (Driver driver : system.retrieveDrivers()) {
            if (driver.getUsername().equals(username))
                driver.setSuspended(true);
        }
    }
    @PutMapping("/users/suspend/{username}")
    public void suspendUser(@PathVariable String username) {
        for (User user : system.retrieveUsers()) {
            if (user.getUsername().equals(username))
                user.setSuspended(true);
        }
    }
    @GetMapping("/admin/pending-registration")
    public ArrayList<Driver> listPendingRegistrations() {
        return system.retrievePendingRegistrations();
    }
    @GetMapping("/admin/listRides")
    public ArrayList<Ride> listRides() {
        return system.retrieveRides();
    }
    @PostMapping("/admin/add-discounted-area/{destination}")
    public void addDiscountedArea(@PathVariable String destination) {
        system.addDiscountedArea(destination);
    }
}