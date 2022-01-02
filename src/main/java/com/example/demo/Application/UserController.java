package com.example.demo.Application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/user")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/accept-offer/{driverName}/{username}")
    public void acceptOffer(@PathVariable String driverName, @PathVariable String username) {
        userService.acceptOffer(driverName, username);
    }

    @PostMapping("/rate-driver/{userUsername}/{driverUsername}/{rating}")
    public void rateDriver(@PathVariable String userUsername, @PathVariable String driverUsername, @PathVariable double rating) {
        userService.rateDriver(userUsername, driverUsername, rating);
    }

    @PostMapping("/request-ride/{source}/{destination}/{numberOfPassengers}/{username}")
    public void requestRide(@PathVariable String source, @PathVariable String destination, @PathVariable int numberOfPassengers, @PathVariable String username) {
        userService.requestRide(source, destination, numberOfPassengers, username);
    }
}
