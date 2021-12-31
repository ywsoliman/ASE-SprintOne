package com.example.demo;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public void suspend(Member member) {
        member.setSuspended(true);
    }
    public void listPendingRegistrations() {
        for(Driver driver : system.retrievePendingRegistrations()) {
            System.out.println(driver.toString());
        }
    }
    public void listRides() {
        for(Ride ride : system.retrieveRides()) {
            System.out.println(ride.toString());
        }
    }
    public void addDiscountedArea(String destination) {
        system.addDiscountedArea(destination);
    }
}