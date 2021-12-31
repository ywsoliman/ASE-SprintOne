package com.example.demo;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Offer {
    private String timeMade;
    private String timeAccepted;
    Driver driver;
    Double price;
    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

    public String getTimeMade() {
        return timeMade;
    }

    public void setTimeMade(String timeMade) {
        this.timeMade = timeMade;
    }

    public String getTimeAccepted() {
        return timeAccepted;
    }

    public void setTimeAccepted(String string) {
        this.timeAccepted = string;
    }

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }



    Offer(double price, Driver driver){
        this.price = price;
        this.driver = driver;
        Date date = new Date();
        this.timeMade = formatter.format(date);
    }
}