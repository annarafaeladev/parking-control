package com.api.parkingcontrol.models;

import com.api.parkingcontrol.dtos.ParkingSpotDto;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.UUID;

@Entity
@Table(name = "TB_PARKING_SPOT")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class ParkingSpotModel implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    @Column(nullable = false, unique = true, length = 10)
    private String parkingSpotNumber;
    @Column(nullable = false, unique = true, length = 7)
    private String licensePlateCar;
    @Column(nullable = false, length = 70)
    private String brandCar;
    @Column(nullable = false, length = 70)
    private String modelCar;
    @Column(nullable = false, length = 70)
    private String colorCar;
    @Column(nullable = false)
    private LocalDateTime registrationDate;
    @Column(nullable = false, length = 130)
    private String responsibleName;
    @Column(nullable = false, length = 30)
    private String apartment;
    @Column(nullable = false, length = 30)
    private String block;

    public ParkingSpotModel(ParkingSpotDto parkingSpotDto){
        this.parkingSpotNumber = parkingSpotDto.parkingSpotNumber();
        this.licensePlateCar = parkingSpotDto.licensePlateCar();
        this.brandCar = parkingSpotDto.brandCar();
        this.modelCar = parkingSpotDto.modelCar();
        this.colorCar = parkingSpotDto.colorCar();
        this.registrationDate = LocalDateTime.now(ZoneId.of("UTC"));
        this.responsibleName = parkingSpotDto.responsibleName();
        this.apartment = parkingSpotDto.apartment();
        this.block = parkingSpotDto.block();

    }

}