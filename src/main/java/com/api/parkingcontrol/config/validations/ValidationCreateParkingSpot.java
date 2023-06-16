package com.api.parkingcontrol.config.validations;

import com.api.parkingcontrol.dtos.ParkingSpotCreateDto;

public interface ValidationCreateParkingSpot {

    String validation(ParkingSpotCreateDto parkingSpotDto);
}
