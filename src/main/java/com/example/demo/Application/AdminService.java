package com.example.demo.Application;

import com.example.demo.Core.Driver;
import com.example.demo.Database.AppSystem;
import com.example.demo.Core.Ride;
import com.example.demo.Core.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class AdminService implements IAdminService {

    AppSystem system = AppSystem.getAppSystem();

    public void verifyDriver(String username) {
        for (Driver driver : system.retrieveDrivers()) {
            if (driver.getUsername().equals(username))
                driver.setVerified(true);
        }
    }

    public void suspendDriver(String username) {
        for (Driver driver : system.retrieveDrivers()) {
            if (driver.getUsername().equals(username))
                driver.setSuspended(true);
        }
    }

    public void suspendUser(String username) {
        for (User user : system.retrieveUsers()) {
            if (user.getUsername().equals(username))
                user.setSuspended(true);
        }
    }

    public ArrayList<Driver> listPendingRegistrations() {
        return system.retrievePendingRegistrations();
    }

    public ArrayList<Ride> listRides() {
        return system.retrieveRides();
    }

    public void addDiscountedArea(String destination) {
        system.addDiscountedArea(destination);
    }

}
