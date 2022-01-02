package com.example.demo.Decorator;

import com.example.demo.Core.Ride;

public class FirstRide extends Discount{

    public FirstRide(IRide ride, Ride concreteRide) {
        super(ride, concreteRide);
    }

    @Override
    public double calculatePrice() {
        if(concreteRide.getUser().getNumberOfRides() > 1){
            return ride.calculatePrice();
        }

        return ride.calculatePrice() * 0.9;

    }
}
