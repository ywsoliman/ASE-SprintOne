package com.example.demo.Application;

import com.example.demo.Core.Driver;
import com.example.demo.Core.Offer;
import com.example.demo.Core.Ride;
import com.example.demo.Database.AppSystem;
import com.example.demo.Decorator.*;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

@Service
public class DriverService implements IDriverService {

    public void addFavArea(String username, String area) {
        for(Driver driver : AppSystem.getAppSystem().retrieveDrivers()){
            if(driver.getUsername().equals(username)){
                driver.getFavoriteAreas().add(area);
                break;
            }
        }
    }

    public void arrivedToLocation(String username) {
        for(Driver driver : AppSystem.retrieveDrivers()) {
            if(driver.getUsername().equals(username)){
                SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
                Date date = new Date();
                driver.getActiveRide().setStarted(formatter.format(date));
                break;
            }
        }
    }

    public void arrivedToDestination(String username) {

        for(Driver driver : AppSystem.retrieveDrivers()) {

            if(driver.getUsername().equals(username)) {

                driver.getActiveRide().getUser().setNumberOfRides(driver.getActiveRide().getUser().getNumberOfRides() + 1);
                SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
                Date date = new Date();
                driver.getActiveRide().setEnded(formatter.format(date));
                driver.setAvailable(true);
                Ride newRide = driver.getActiveRide();
                IRide ride = new PublicHoliday(new TwoPassengers(new UserBirthday(new DiscountedAreas(new FirstRide(newRide, newRide), newRide), newRide), newRide), newRide);
                newRide.setDiscountedPrice(ride.calculatePrice());
                System.out.println(newRide.getDiscountedPrice());
                AppSystem.getAppSystem().retrieveRides().add(newRide);
                break;

            }

        }
    }

    public void makeOffer(String username, double price, String driverName) {

        for(Driver driver : AppSystem.getAppSystem().retrieveDrivers()) {

            if(driver.getUsername().equals(driverName)) {

                for (Ride ride: driver.getNearbyRequests()) {

                    if(ride.getUser().getUsername().equals(username)){
                        Offer offer = new Offer(price, driver);
                        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
                        Date date = new Date();
                        offer.setTimeMade(formatter.format(date));
                        ride.getAllOffers().add(offer);
                        break;
                    }

                }
                break;
            }
        }
    }

    public HashMap<String, Double> listUserRatings(String driverUsername) {

        for (Driver driver : AppSystem.getAppSystem().retrieveDrivers()) {

            if (driver.getUsername().equals(driverUsername))
                return driver.getUserRatings();

        }

        return null;
    }


}
