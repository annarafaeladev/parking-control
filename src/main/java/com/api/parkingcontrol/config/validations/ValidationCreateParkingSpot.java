package com.api.parkingcontrol.config.validations;

import com.api.parkingcontrol.dtos.ParkingSpotDto;

public interface ValidationCreateParkingSpot {

    String validation(ParkingSpotDto parkingSpotDto);
}
