package com.example.demo;

public class DriverLogin extends Login {

    public DriverLogin(AppSystem system) {
        super.system = system;
    }

    @Override
    public Driver login(String username, String password) {
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
