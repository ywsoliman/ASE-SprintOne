package com.example.demo.Decorator;

import com.example.demo.Core.Ride;
import com.example.demo.Database.AppSystem;

public class PublicHoliday extends Discount{
    public PublicHoliday(IRide ride, Ride concreteRide) {
        super(ride, concreteRide);
    }

    @Override
    public double calculatePrice() {
        System.out.println(concreteRide.getStarted().substring(0, 5));
        if (AppSystem.getAppSystem().retrievePublicHolidays().contains(concreteRide.getStarted().substring(0, 5)))
            return ride.calculatePrice() * 0.95;
        return ride.calculatePrice();
    }
}
