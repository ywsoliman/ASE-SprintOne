package com.example.demo.Application;

import java.util.HashMap;

public interface IDriverService {

    void addFavArea(String username, String area);
    void arrivedToLocation(String username);
    void arrivedToDestination(String username);
    void makeOffer(String username, double price, String driverName);
    HashMap<String, Double> listUserRatings(String driverUsername);


}
