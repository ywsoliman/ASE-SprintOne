package com.example.demo;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
@RestController
public class Driver extends Member implements Observer {

    String nationalID;
    String drivingLicense;
    boolean verified;
    boolean available;
    Ride ride;
    double averageRating;
    ArrayList<String> favoriteAreas = new ArrayList<String>();
    ArrayList<Ride> nearbyRequests = new ArrayList<Ride>();
    HashMap<String, Double> userRatings = new HashMap<String, Double>();

    public Driver(){

    }
    public Driver(String username, String password, String email, String mobileNumber, String nationalID, String drivingLicense) {
        super(username, password, email, mobileNumber);
        this.nationalID = nationalID;
        this.drivingLicense = drivingLicense;
        this.verified = false;
        this.available = true;
        this.averageRating = 0.0;
    }

    @GetMapping("/drivers/user-ratings")
    public HashMap<String, Double> getUserRatings() {
        return userRatings;
    }


    public boolean isAvailable() {
        return available;
    }


    public void setAvailable(boolean available) {
        this.available = available;
    }


    public ArrayList<Ride> getNearbyRequests() {
        return nearbyRequests;
    }

    public double getAverageRating() {
        return averageRating;
    }

    public void setAverageRating(double averageRating) {
        this.averageRating = averageRating;
    }

    public String getNationalID() {
        return nationalID;
    }
    public void setNationalID(String nationalID) {
        this.nationalID = nationalID;
    }
    public String getDrivingLicense() {
        return drivingLicense;
    }
    public void setDrivingLicense(String drivingLicense) {
        this.drivingLicense = drivingLicense;
    }
    public boolean isVerified() {
        return verified;
    }
    public void setVerified(boolean verified) {
        this.verified = verified;
    }
    @PostMapping("/drivers/add-fav/{area}")
    public void addFavArea(@PathVariable String area) {
        favoriteAreas.add(area);
    }
    @GetMapping("/drivers/fav-areas")
    public ArrayList<String> getFavoriteAreas() {
        return favoriteAreas;
    }

    @PostMapping("/drivers/make-offer/{username}/{price}")
    public void makeOffer(@PathVariable String username, @PathVariable double price) {
        Offer offer = new Offer(price, this);
        for (Ride ride: nearbyRequests) {
            if(ride.getUser().getUsername().equals(username)){
                ride.getUser().getOffers().add(offer);
                break;
            }
        }
    }


    public void listUserRatings() {
        for(HashMap.Entry<String, Double> entry : userRatings.entrySet()) {
            System.out.println("User: " + entry.getKey() + " Rating:  " + entry.getValue());
        }
    }

    @Override
    public String toString() {
        return "Driver [nationalID=" + nationalID + ", drivingLicense=" + drivingLicense + ", verified=" + verified
                + ", username=" + username + ", password=" + password + ", email=" + email + ", mobileNumber="
                + mobileNumber + ", suspended=" + suspended + "]";
    }

//	public User getUser() {
//		return user;
//	}

    @Override
    public void update(Ride ride) {
        this.ride = ride;
        nearbyRequests.add(ride);
    }


}
