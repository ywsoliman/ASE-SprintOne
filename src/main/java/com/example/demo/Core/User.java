package com.example.demo.Core;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

@RestController
public class User extends Member {

    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    Ride ride = new Ride();
    int numberOfRides;
    String birthDay;

    public User() {
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

    public Ride getRide() {
        return ride;
    }
    public void setRide(Ride ride) {
        this.ride = ride;
    }
    @JsonIgnore
    public ArrayList<Offer> getOffers() {
        return ride.getAllOffers();
    }

}
