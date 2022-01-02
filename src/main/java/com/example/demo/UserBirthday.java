package com.example.demo;

public class UserBirthday extends Discount{
    public UserBirthday(IRide ride, Ride concreteRide) {
        super(ride, concreteRide);
    }

    @Override
    public double calculatePrice() {
        return ride.calculatePrice() * 0.9;
    }
}
