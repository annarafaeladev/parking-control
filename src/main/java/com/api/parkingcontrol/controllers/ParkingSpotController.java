package com.api.parkingcontrol.controllers;

import com.api.parkingcontrol.services.ParkingSpotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/parking-spot")
@CrossOrigin(origins = "*", maxAge = 3600)
public class ParkingSpotController {

    @Autowired
    private ParkingSpotService parkingSpotService;

}
