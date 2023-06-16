package com.api.parkingcontrol.controllers;

import com.api.parkingcontrol.config.validations.ValidationCreateParkingSpot;
import com.api.parkingcontrol.dtos.ParkingSpotDto;
import com.api.parkingcontrol.models.ParkingSpotModel;
import com.api.parkingcontrol.services.ParkingSpotService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/parking-spot")
@CrossOrigin(origins = "*", maxAge = 3600)
public class ParkingSpotController {

    @Autowired
    private ParkingSpotService parkingSpotService;

    @Autowired
    private ValidationCreateParkingSpot validationCreateParkingSpot;

    @PostMapping
    public ResponseEntity<Object> create(@RequestBody @Valid ParkingSpotDto parkingSpotDto, UriComponentsBuilder uriComponentsBuilder){
        var messageError = validationCreateParkingSpot.validation(parkingSpotDto);

        if (messageError != null){
            return ResponseEntity.status(HttpStatus.CONFLICT).body(messageError);
        }

        var parkingSpotModel = new ParkingSpotModel(parkingSpotDto);
        URI uri = uriComponentsBuilder.path("/parking-spot/{id}").buildAndExpand(parkingSpotModel.getId()).toUri();

        return ResponseEntity.created(uri).body(parkingSpotService.save(parkingSpotModel));
    }

}
