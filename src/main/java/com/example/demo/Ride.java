package com.example.demo;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class Ride implements Observable{
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    ArrayList<Driver> interestedDrivers = new ArrayList<Driver>();
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    ArrayList<Offer> allOffers = new ArrayList<Offer>();
    Offer acceptedOffer;
    private String started;
    private String ended;
    User user;
    String source;
    String destination;
    int numberOfPassengers;
    static int counter = 0;
    int ID;

    Ride(){

    }
    Ride(User user, String source, String destination, int numberOfPassengers){
        counter++;
        this.user = user;
        this.source = source;
        this.destination = destination;
        this.ID = counter;
        this.numberOfPassengers = numberOfPassengers;
    }

    public String getStarted() {
        return started;
    }

    public void setStarted(String started) {
        this.started = started;
    }

    public String getEnded() {
        return ended;
    }

    public void setEnded(String ended) {
        this.ended = ended;
    }

    public ArrayList<Driver> getInterestedDrivers() {
        return interestedDrivers;
    }

    public ArrayList<Offer> getAllOffers() {
        return allOffers;
    }

    public User getUser() {
        return user;
    }

    public Offer getAcceptedOffer() {
        return acceptedOffer;
    }

    public void setAcceptedOffer(Offer acceptedOffer) {
        this.acceptedOffer = acceptedOffer;
    }



    @Override
    public String toString() {
        return "Ride [ID=" + ID + "]";
    }

//    public void showRideHitory() {
//        //Offers
//        for (Offer offer : allOffers) {
//            System.out.println("Offer made at " + offer.getTimeMade() + " by " + offer.getDriver() + " with price " + offer.getPrice());
//        }
//        //User accepts offer
//        System.out.println(user.getUsername() + " accepted offer at " + acceptedOffer.getTimeAccepted());
//        //Captain arrived
//        //User arrived
//    }

    @Override
    public void subscribe(String source, String destination) {

        for(Driver driver : AppSystem.getAppSystem().retrieveDrivers()) {

            if(driver.getFavoriteAreas().contains(source) && !driver.isSuspended() && driver.isVerified() /*&& driver.isAvailable()*/) {
                interestedDrivers.add(driver);
            }
        }
    }
    @Override
    public void unsubscribe(Observer o) {

        interestedDrivers.remove((Driver) o);
    }
    @Override
    public void update() {
        //ride = this;

        for (Driver driver : interestedDrivers) {

            driver.update(this);
        }
    }
}
