package com.example.demo;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
@RestController
public class Driver extends Member implements Observer {

    String nationalID;
    String drivingLicense;
    boolean verified;
    boolean available;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    Ride activeRide = new Ride();
    double averageRating;
    ArrayList<String> favoriteAreas = new ArrayList<String>();
    ArrayList<Ride> nearbyRequests = new ArrayList<Ride>();
    HashMap<String, Double> userRatings = new HashMap<String, Double>();

    public Driver(){
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
    @PostMapping("/drivers/add-fav/{username}/{area}")
    public void addFavArea(@PathVariable String username, @PathVariable String area) {
        for(Driver driver : AppSystem.getAppSystem().retrieveDrivers()){
            if(driver.getUsername().equals(username)){
                driver.getFavoriteAreas().add(area);
                break;
            }
        }
    }
    @PostMapping("/drivers/arrived-to-location/{username}")
    public void arrivedToLocation(@PathVariable String username){
        for(Driver driver : AppSystem.retrieveDrivers()) {
            if(driver.getUsername().equals(username)){
                SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
                Date date = new Date();
                driver.getActiveRide().setStarted(formatter.format(date));
                break;
            }
        }
    }
    @PostMapping("/drivers/arrived-to-destination/{username}")
    public void arrivedToDestination(@PathVariable String username){
        for(Driver driver : AppSystem.retrieveDrivers()) {
            if(driver.getUsername().equals(username)){
                driver.getActiveRide().getUser().setNumberOfRides(driver.getActiveRide().getUser().getNumberOfRides() + 1);
                SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
                Date date = new Date();
                driver.getActiveRide().setEnded(formatter.format(date));
                driver.setAvailable(true);
                Ride newRide = driver.getActiveRide();
                IRide ride = new PublicHoliday(new TwoPassengers(new UserBirthday(new DiscountedAreas(new FirstRide(newRide, newRide), newRide), newRide), newRide), newRide);
                newRide.setDiscountedPrice(ride.calculatePrice());
                System.out.println(newRide.getDiscountedPrice());
                AppSystem.getAppSystem().retrieveRides().add(newRide);
                break;
            }

        }
    }
//    @GetMapping("/drivers/fav-areas")
    public ArrayList<String> getFavoriteAreas() {
        return favoriteAreas;
    }

    @PostMapping("/drivers/make-offer/{username}/{price}/{driverName}")
    public void makeOffer(@PathVariable String username, @PathVariable double price, @PathVariable String driverName) {
        for(Driver driver : AppSystem.getAppSystem().retrieveDrivers()){
            if(driver.getUsername().equals(driverName)){
                for (Ride ride: driver.getNearbyRequests()) {
                    if(ride.getUser().getUsername().equals(username)){
                        Offer offer = new Offer(price, driver);
                        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
                        Date date = new Date();
                        offer.setTimeMade(formatter.format(date));
                        ride.getAllOffers().add(offer);
                        break;
                    }
                }
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
        //this.ride = ride;
        nearbyRequests.add(ride);
    }

}
