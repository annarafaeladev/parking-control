package com.api.parkingcontrol.config.validations;

import com.api.parkingcontrol.dtos.ParkingSpotDto;
import com.api.parkingcontrol.services.ParkingSpotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("ValidationParkingSpot")
public class ValidationParkingSpot implements  ValidationCreateParkingSpot{

    @Autowired
    private ParkingSpotService parkingSpotService;

    @Override
    public String validation(ParkingSpotDto parkingSpotDto) {
        if(parkingSpotService.existsByLicensePlateCar(parkingSpotDto.licensePlateCar())){
            return "Conflict: License Plate Car is already in use!";
        }
        if(parkingSpotService.existsByParkingSpotNumber(parkingSpotDto.parkingSpotNumber())){
            return "Conflict: Parking Spot is already in use!";
        }
        if(parkingSpotService.existsByApartmentAndBlock(parkingSpotDto.apartment(), parkingSpotDto.block())){
            return "Conflict: Parking Spot already registered for this apartment/block!";
        }

        return null;
    }
}
