package com.example.demo;

public class UserBirthday extends Discount{
    public UserBirthday(IRide ride, Ride concreteRide) {
        super(ride, concreteRide);
    }

    @Override
    public double calculatePrice() {
        if(concreteRide.getUser().getBirthDay().equals(concreteRide.getStarted().substring(0, 5))){
            return ride.calculatePrice() * 0.9;
        }
        return ride.calculatePrice();
    }
}
