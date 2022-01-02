package com.example.demo.Core;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.HashMap;

public class Driver extends Member implements Observer {

    private String nationalID;
    private String drivingLicense;
    private boolean verified;
    private boolean available;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Ride activeRide = new Ride();
    private double averageRating;
    private ArrayList<String> favoriteAreas = new ArrayList<String>();
    private ArrayList<Ride> nearbyRequests = new ArrayList<Ride>();
    private HashMap<String, Double> userRatings = new HashMap<String, Double>();

    public Driver() {
        this.available = true;
    }

    public Driver(String username, String password, String email, String mobileNumber, String nationalID, String drivingLicense) {
        super(username, password, email, mobileNumber);
        this.nationalID = nationalID;
        this.drivingLicense = drivingLicense;
        this.verified = false;
        this.available = true;
        this.averageRating = 0.0;
    }

    public Ride getActiveRide() {
        return activeRide;
    }

    public void setActiveRide(Ride activeRide) {
        this.activeRide = activeRide;
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

    public ArrayList<String> getFavoriteAreas() {
        return favoriteAreas;
    }


    public HashMap<String, Double> getUserRatings() {
        return userRatings;
    }

    public void setUserRatings(HashMap<String, Double> userRatings) {
        this.userRatings = userRatings;
    }

    @Override
    public String toString() {
        return "Driver{" +
                "nationalID='" + nationalID + '\'' +
                ", drivingLicense='" + drivingLicense + '\'' +
                ", verified=" + verified +
                ", available=" + available +
                ", activeRide=" + activeRide +
                ", averageRating=" + averageRating +
                ", favoriteAreas=" + favoriteAreas +
                ", nearbyRequests=" + nearbyRequests +
                ", userRatings=" + userRatings +
                '}';
    }

    @Override
    public void update(Ride ride) {
        nearbyRequests.add(ride);
    }

}
