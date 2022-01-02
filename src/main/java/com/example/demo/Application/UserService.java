package com.example.demo.Application;


import com.example.demo.Database.AppSystem;
import com.example.demo.Core.*;
import com.example.demo.Core.Offer;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

@Service
public class UserService implements IUserService {


    public void acceptOffer(String driverName, String username){
        for(User user : AppSystem.getAppSystem().retrieveUsers()){
            if(user.getUsername().equals(username)){
                for(Offer offer : user.getRide().getAllOffers()){
                    if (offer.getDriver().getUsername().equals(driverName)) {
                        user.getRide().setBasePrice(offer.getPrice());
                        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
                        Date date = new Date();
                        offer.setTimeAccepted(formatter.format(date));
                        user.getRide().setAcceptedOffer(offer);
                        offer.getDriver().setActiveRide(user.getRide());
                        offer.getDriver().setAvailable(false);
                        break;
                    }
                }
                for(Driver driver : user.getRide().getInterestedDrivers()){
                    driver.getNearbyRequests().remove(user.getRide());
                }
                user.getRide().getInterestedDrivers().clear();
                break;
            }
        }
    }


    public void rateDriver(String userUsername, String driverUsername, double rating) {

        for (User user : AppSystem.getAppSystem().retrieveUsers()) {

            if (user.getUsername().equals(userUsername)) {

                for (Driver driver : AppSystem.getAppSystem().retrieveDrivers())  {

                    if (driver.getUsername().equals(driverUsername)) {

                        driver.getUserRatings().put(userUsername, rating);

                        double sum = 0.0;

                        for (Map.Entry<String, Double> entry : driver.getUserRatings().entrySet()) {
                            sum += entry.getValue();
                        }
                        driver.setAverageRating(sum / driver.getUserRatings().size());
                        break;

                    }

                }

            }

        }

    }

    public void requestRide(String source, String destination, int numberOfPassengers, String username) {

        Ride newRide = new Ride();

        for(User user : AppSystem.getAppSystem().retrieveUsers()){

            if(user.getUsername().equals(username)) {

                newRide = new Ride(user, source, destination, numberOfPassengers);
                user.setRide(newRide);
                newRide.subscribe(source, destination);
                newRide.update();
                break;

            }
        }
    }

}
