package com.example.demo.Application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@RequestMapping(path = "/driver")
public class DriverController {

    private final IDriverService driverService;

    @Autowired
    public DriverController(DriverService driverService) {
        this.driverService = driverService;
    }

    @PostMapping("/add-fav/{username}/{area}")
    public void addFavArea(@PathVariable String username, @PathVariable String area) {
        driverService.addFavArea(username, area);
    }

    @PostMapping("arrived-to-location/{username}")
    public void arrivedToLocation(@PathVariable String username) {
        driverService.arrivedToLocation(username);
    }

    @PostMapping("arrived-to-destination/{username}")
    public void arrivedToDestination(@PathVariable String username) {
        driverService.arrivedToDestination(username);
    }

    @PostMapping("make-offer/{username}/{price}/{driverName}")
    public void makeOffer(@PathVariable String username, @PathVariable double price, @PathVariable String driverName) {
        driverService.makeOffer(username, price, driverName);
    }

    @GetMapping("{driverUsername}/list-user-rating")
    public HashMap<String, Double> listUserRatings(@PathVariable String driverUsername) {
        return driverService.listUserRatings(driverUsername);
    }
}
