package com.bladi.meep.model.mapper;

import com.bladi.meep.model.dto.VehicleDTO;
import com.bladi.meep.model.entity.Vehicle;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class VehicleMapper {


    public static List<Vehicle> mapVehicleArrayToVehicleList(Vehicle[] objectData) {
        return Arrays.asList(objectData);
    }

    public static List<VehicleDTO> mapVehicleListToVehicleDTOList(List<Vehicle> vehicleList) {
        return vehicleList.stream().map(VehicleMapper::mapVehicleToVehicleDTO).collect(Collectors.toList());
    }

    public static VehicleDTO mapVehicleToVehicleDTO(Vehicle vehicle) {
        return VehicleDTO.builder()
                .id(vehicle.getId())
                .batteryLevel(vehicle.getBatteryLevel())
                .y(vehicle.getY())
                .x(vehicle.getX())
                .companyZoneId(vehicle.getCompanyZoneId())
                .engineType(vehicle.getEngineType())
                .licencePlate(vehicle.getLicencePlate())
                .model(vehicle.getModel())
                .name(vehicle.getName())
                .pricePerMinuteDriving(vehicle.getPricePerMinuteDriving())
                .pricePerMinuteParking(vehicle.getPricePerMinuteParking())
                .range(vehicle.getRange())
                .realTimeData(vehicle.getRealTimeData())
                .resourceImageId(vehicle.getResourceImageId())
                .resourceType(vehicle.getResourceType())
                .seats(vehicle.getSeats())
                .engineType(vehicle.getEngineType())
                .build();

    }
}

/*

 {
        "id": "DriveNow_12708820",
        "name": "M-DX8437",
        "x": -9.1873,
        "y": 38.7392,
        "licencePlate": "M-DX8437",
        "range": 0,
        "batteryLevel": 50,
        "seats": 4,
        "model": "MINI",
        "resourceImageId": "vehicle_gen_dn",
        "pricePerMinuteParking": 15.0,
        "pricePerMinuteDriving": 29.0,
        "realTimeData": true,
        "engineType": "DIESEL",
        "resourceType": "CAR",
        "companyZoneId": 545
    },

/
 */