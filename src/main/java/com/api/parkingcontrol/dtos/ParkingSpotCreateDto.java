package com.api.parkingcontrol.dtos;

import jakarta.validation.constraints.*;

public record ParkingSpotCreateDto(
        @NotBlank
        String parkingSpotNumber,
        @NotBlank
        @Size(max = 7)
        String licensePlateCar,
        @NotBlank String brandCar,
        @NotBlank
        String modelCar,
        @NotBlank
        String colorCar,
        @NotBlank
        String responsibleName,
        @NotBlank
        String apartment,
        @NotBlank
        String block
) {
}
