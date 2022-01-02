package com.example.demo.Decorator;

import com.example.demo.Core.Ride;
import com.example.demo.Database.AppSystem;

public class DiscountedAreas extends Discount {
    public DiscountedAreas(IRide ride, Ride concreteRide) {
        super(ride, concreteRide);
    }

    @Override
    public double calculatePrice() {
        if(AppSystem.getAppSystem().retrieveDiscountedAreasCopy().contains(concreteRide.getDestination())){
            return ride.calculatePrice() * 0.9;
        }

        return ride.calculatePrice();

    }
}
