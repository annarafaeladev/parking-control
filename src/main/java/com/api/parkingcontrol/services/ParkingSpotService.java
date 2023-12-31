package com.api.parkingcontrol.services;

import com.api.parkingcontrol.config.exceptions.ValidationException;
import com.api.parkingcontrol.dtos.ParkingSpotCreateDto;
import com.api.parkingcontrol.models.ParkingSpotModel;
import com.api.parkingcontrol.repositories.ParkingSpotRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.swing.text.html.Option;
import java.util.Optional;
import java.util.UUID;

@Service
public class ParkingSpotService {

    @Autowired
    private ParkingSpotRepository  parkingSpotRepository;

    @Transactional
    public ParkingSpotModel save(ParkingSpotModel parkingSpotModel) {
        return parkingSpotRepository.save(parkingSpotModel);
    }

    public boolean existsByLicensePlateCar(String licensePlateCar) {
        return parkingSpotRepository.existsByLicensePlateCar(licensePlateCar);
    }

    public boolean existsByParkingSpotNumber(String parkingSpotNumber) {
        return parkingSpotRepository.existsByParkingSpotNumber(parkingSpotNumber);
    }

    public boolean existsByApartmentAndBlock(String apartment, String block) {
        return parkingSpotRepository.existsByApartmentAndBlock(apartment, block);
    }

    public Page<ParkingSpotModel> findAll(Pageable pagination) {
        return parkingSpotRepository.findAll(pagination);
    }

    public ParkingSpotModel findOne(UUID id) {
        var parkingSpot = parkingSpotRepository.findById(id);

        if (!parkingSpot.isPresent())
            throw  new ValidationException("Parking Spot id Not found");

        return parkingSpot.get();
    }

    @Transactional
    public void delete(UUID id) {
        var parkingSpot = parkingSpotRepository.findById(id);

        if (!parkingSpot.isPresent())
            throw  new ValidationException("Cancel op: delete. Parking Spot id Not found");

        parkingSpotRepository.delete(parkingSpot.get());
    }


    @Transactional
    public ParkingSpotModel update(UUID id, ParkingSpotCreateDto data) {
        var parkingSpotDb = parkingSpotRepository.findById(id);

        if (!parkingSpotDb.isPresent())
            throw  new ValidationException("Cancel op: update. Parking Spot id Not found");

        var parkingSpotModel = new ParkingSpotModel();
        BeanUtils.copyProperties(data, parkingSpotModel);
        parkingSpotModel.setId(parkingSpotDb.get().getId());
        parkingSpotModel.setRegistrationDate(parkingSpotDb.get().getRegistrationDate());

        parkingSpotRepository.save(parkingSpotModel);

        return parkingSpotModel;
    }
}
