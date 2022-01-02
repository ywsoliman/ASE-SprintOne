package com.example.demo;

public class Discount implements IRide{

    IRide ride;
    Ride concreteRide;
    public Discount(IRide ride, Ride concreteRide){
        this.ride = ride;
        this.concreteRide = concreteRide;
    }
    @Override
    public double calculatePrice(){
        return ride.calculatePrice();
    }
}
