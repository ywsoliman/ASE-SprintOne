package com.example.demo.SystemLogin;

import com.example.demo.Core.Driver;
import com.example.demo.Database.AppSystem;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DriverLogin extends Login {

    @Override
    @PostMapping("/driverlogin/{username}/{password}")
    public Driver login(@PathVariable String username, @PathVariable String  password) {
        for (Driver driver : system.retrieveDrivers()) {
            if (driver.getUsername().equals(username) && driver.getPassword().equals(password)) {
                if(driver.isSuspended()) {
                    System.out.println("This account is suspended.");
                    return null;
                }
                else if(!driver.isVerified()) {
                    System.out.println("This account is not verified yet.");
                    return null;
                }
                else {
                    System.out.println("Welcome " + driver.getUsername() + ".");
                    return driver;
                }
            }
        }
        System.out.println("No account found with these credentials");
        return null;
    }

}
