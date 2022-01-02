package com.example.demo.Application;

import com.example.demo.Core.Driver;
import com.example.demo.Core.Ride;

import java.util.ArrayList;

public interface IAdminService {

    void verifyDriver(String username);
    void suspendDriver(String username);
    void suspendUser(String username);
    ArrayList<Driver> listPendingRegistrations();
    ArrayList<Ride> listRides();
    void addDiscountedArea(String destination);

}
