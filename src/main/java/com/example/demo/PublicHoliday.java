package com.example.demo;

public class PublicHoliday extends Discount{
    public PublicHoliday(IRide ride, Ride concreteRide) {
        super(ride, concreteRide);
    }

    @Override
    public double calculatePrice() {
        return ride.calculatePrice() * 0.95;
    }
}
