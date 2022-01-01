package com.example.demo;

import com.fasterxml.jackson.annotation.JsonIgnore;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Map;
import java.util.Scanner;
@RestController
public class User extends Member {

    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
    Ride ride = new Ride();

    public User(){

    }
    public User(String username, String password, String email, String mobileNumber) {
        super(username, password, email, mobileNumber);

    }
    public void acceptOffer(Offer offer) {
        Date date = new Date();
        offer.setTimeAccepted(formatter.format(date));
        offer.getDriver().setAvailable(false);

        System.out.println("Please rate the driver from 1 to 5");

        Scanner input = new Scanner(System.in);
        double rating = input.nextDouble();
        input.nextLine();

        while(rating < 1 || rating > 5) {
            System.out.println("Invalid rating. Please enter a number from 1 to 5.");
            rating = input.nextDouble();
            input.nextLine();
        }
        offer.getDriver().setAvailable(true);
        rateDriver(offer.getDriver(), rating);
        for (Driver d : ride.interestedDrivers) {
            d.getNearbyRequests().remove(ride);
        }

        ride.interestedDrivers.clear();
    }
    public Ride getRide() {
        return ride;
    }
    public void setRide(Ride ride) {
        this.ride = ride;
    }
    @GetMapping("/users/offers")
    public ArrayList<Offer> getOffers() {
        return ride.allOffers;
    }
    public void listOffers() {
        for(Offer offer : ride.allOffers) {
            System.out.println("Driver: " + offer.getDriver().getUsername() + " Average Rating:  " + offer.getDriver().getAverageRating() + " Offer: $" + offer.getPrice());
        }
    }
    public void rateDriver(Driver driver, double rating) {
        driver.getUserRatings().put(this.getUsername(), rating);
        double sum = 0.0;
        for (Map.Entry<String, Double> entry : driver.getUserRatings().entrySet()) {
            sum += entry.getValue();
        }
        driver.setAverageRating(sum / driver.getUserRatings().size());
    }
    public void requestRide(String source, String destination, AppSystem system, int numberOfPassengers) {
        Ride ride = new Ride(this, source, destination, numberOfPassengers);
        ride.subscribe(source, destination, system);
        ride.update();
        this.ride = ride;
    }
}
