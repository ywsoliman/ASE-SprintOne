package com.example.demo;

public class TwoPassengers extends Discount{
    public TwoPassengers(IRide ride, Ride concreteRide) {
        super(ride, concreteRide);
    }

    @Override
    public double calculatePrice() {
        if(concreteRide.getNumberOfPassengers() > 1){
            return ride.calculatePrice() * 0.95;
        }
        return ride.calculatePrice();
    }
}
