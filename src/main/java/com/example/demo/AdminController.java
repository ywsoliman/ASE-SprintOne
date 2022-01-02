package com.example.demo;

import com.example.demo.Application.AdminService;
import com.example.demo.Application.IAdminService;
import com.example.demo.Core.Driver;
import com.example.demo.Core.Ride;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping(path = "/admin")
public class AdminController {

    private final IAdminService adminService;

    @Autowired
    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    @PutMapping("/verify/{username}")
    public void verifyDriver(@PathVariable String username) {
        adminService.verifyDriver(username);
    }

    @PutMapping("/drivers/suspend/{username}")
    public void suspendDriver(@PathVariable String username) {
        adminService.suspendDriver(username);
    }

    @PutMapping("/users/suspend/{username}")
    public void suspendUser(@PathVariable String username) {
        adminService.suspendUser(username);
    }

    @GetMapping("/pending-registration")
    public ArrayList<Driver> listPendingRegistrations() {
        return adminService.listPendingRegistrations();
    }

    @GetMapping("list-rides")
    public ArrayList<Ride> listRides() {
        return adminService.listRides();
    }

    @PostMapping("add-discounted-area/{destination}")
    public void addDiscountedArea(@PathVariable String destination) {
        adminService.addDiscountedArea(destination);
    }
}
