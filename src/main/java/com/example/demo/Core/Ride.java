package com.example.demo.Core;

import com.example.demo.Database.AppSystem;
import com.example.demo.Decorator.IRide;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;

public class Ride implements Observable, IRide {

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    ArrayList<Driver> interestedDrivers = new ArrayList<Driver>();
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    ArrayList<Offer> allOffers = new ArrayList<Offer>();
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)

    private Offer acceptedOffer;
    private String started;
    private String ended;
    private User user;
    private String source;
    private String destination;
    private int numberOfPassengers;
    private static int counter = 0;
    private int ID;
    private double basePrice;
    private double discountedPrice;

    public Ride() {

    }
    public Ride(User user, String source, String destination, int numberOfPassengers){
        counter++;
        this.user = user;
        this.source = source;
        this.destination = destination;
        this.ID = counter;
        this.numberOfPassengers = numberOfPassengers;
    }

    public int getNumberOfPassengers() {
        return numberOfPassengers;
    }

    public double getBasePrice() {
        return basePrice;
    }

    public void setBasePrice(double basePrice) {
        this.basePrice = basePrice;
    }

    public double getDiscountedPrice() {
        return discountedPrice;
    }

    public void setDiscountedPrice(double discountedPrice) {
        this.discountedPrice = discountedPrice;
    }

    public String getSource() {
        return source;
    }

    public String getDestination() {
        return destination;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public void setDestination(String destination) {
        this.destination = destination;
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
        return this.allOffers;
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

    @Override
    public void subscribe(String source, String destination) {

        for(Driver driver : AppSystem.getAppSystem().retrieveDrivers()) {

            if(driver.getFavoriteAreas().contains(source) && !driver.isSuspended() && driver.isVerified() && driver.isAvailable()) {
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

        for (Driver driver : interestedDrivers) {
            driver.update(this);
        }
    }

    @Override
    public double calculatePrice() {
        return acceptedOffer.getPrice();
    }
}
