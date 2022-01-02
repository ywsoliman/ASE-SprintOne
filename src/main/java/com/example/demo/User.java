package com.example.demo;

import com.fasterxml.jackson.annotation.JsonIgnore;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Map;
import java.util.Scanner;
@RestController
public class User extends Member {
    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    Ride ride = new Ride();
    int numberOfRides;
    String birthDay;

    public User(){
        numberOfRides = 0;
    }
    public User(String username, String password, String email, String mobileNumber) {
        super(username, password, email, mobileNumber);
    }
    public User(User user) {
        super(user.getUsername(), user.getPassword(), user.getEmail(), user.getMobileNumber());
    }

    public String getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(String birthDay) {
        this.birthDay = birthDay;
    }

    public int getNumberOfRides() {
        return numberOfRides;
    }

    public void setNumberOfRides(int numberOfRides) {
        this.numberOfRides = numberOfRides;
    }

    //    public void acceptOffer(Offer offer) {
//        Date date = new Date();
//        offer.setTimeAccepted(formatter.format(date));
//        offer.getDriver().setAvailable(false);
//
//        System.out.println("Please rate the driver from 1 to 5");
//
//        Scanner input = new Scanner(System.in);
//        double rating = input.nextDouble();
//        input.nextLine();
//
//        while(rating < 1 || rating > 5) {
//            System.out.println("Invalid rating. Please enter a number from 1 to 5.");
//            rating = input.nextDouble();
//            input.nextLine();
//        }
//        offer.getDriver().setAvailable(true);
//        rateDriver(offer.getDriver(), rating);
//        for (Driver d : ride.interestedDrivers) {
//            d.getNearbyRequests().remove(ride);
//        }
//
//        ride.interestedDrivers.clear();
//    }
    @PostMapping("users/accept-offer/{driverName}/{username}")
    public void acceptOffer(@PathVariable String driverName, @PathVariable String username){
        for(User user : AppSystem.getAppSystem().retrieveUsers()){
            if(user.getUsername().equals(username)){
                for(Offer offer : user.getRide().getAllOffers()){
                    if (offer.getDriver().getUsername().equals(driverName)) {
                        user.getRide().setBasePrice(offer.getPrice());
                        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
                        Date date = new Date();
                        offer.setTimeAccepted(formatter.format(date));
                        user.getRide().setAcceptedOffer(offer);
                        offer.getDriver().setActiveRide(user.getRide());
                        offer.getDriver().setAvailable(false);
                        break;
                    }
                }
                for(Driver driver : user.getRide().getInterestedDrivers()){
                    driver.getNearbyRequests().remove(user.getRide());
                }
                user.getRide().getInterestedDrivers().clear();
                break;
            }
        }
    }
    public Ride getRide() {
        return ride;
    }
    public void setRide(Ride ride) {
        this.ride = ride;
    }
    @JsonIgnore
    //@GetMapping("/users/offers")
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
    @PostMapping("/request-ride/{source}/{destination}/{numberOfPassengers}/{username}")
    public void requestRide(@PathVariable String source, @PathVariable String destination, @PathVariable int numberOfPassengers, @PathVariable String username) {
        Ride newRide = new Ride();
        for(User user : AppSystem.getAppSystem().retrieveUsers()){
            if(user.getUsername().equals(username)){
                newRide = new Ride(user, source, destination, numberOfPassengers);

                user.setRide(newRide);

                //AppSystem.getAppSystem().retrieveRides().add(ride);
                newRide.subscribe(source, destination);
                newRide.update();
                break;
            }
        }
    }
}
