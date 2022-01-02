package com.example.demo.Application;

public interface IUserService {

    void acceptOffer(String driverName, String username);
    void rateDriver(String userUsername, String driverUsername, double rating);
    void requestRide(String source, String destination, int numberOfPassengers, String username);

}
