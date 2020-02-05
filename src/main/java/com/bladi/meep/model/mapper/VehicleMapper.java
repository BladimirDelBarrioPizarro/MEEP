package com.bladi.meep.model.mapper;

import com.bladi.meep.model.dto.HttpErrorDTO;
import com.bladi.meep.model.dto.VehicleDTO;
import com.bladi.meep.model.entity.Vehicle;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.Date;
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

    public static ResponseEntity<HttpErrorDTO> buildHttpErrorDTO(Integer code, HttpStatus statusText, String url, String message, String method, Date date) {
        return new ResponseEntity<>(HttpErrorDTO.builder()
                .code(code)
                .statusText(statusText.toString())
                .url(url)
                .message(message)
                .method(method)
                .date(date.toString())
                .build(), HttpStatus.NOT_FOUND);
    }
}

