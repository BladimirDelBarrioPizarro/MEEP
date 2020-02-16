package com.bladi.meep.test.dummy;

import com.bladi.meep.model.dto.VehicleDTO;
import com.bladi.meep.model.entity.Vehicle;

import java.util.Collections;
import java.util.List;

public class VehicleDummy {
    public static List<VehicleDTO> vehicleDTOListDummy() {
        return Collections.singletonList(vehicleDTODummy());
    }

    public static List<Vehicle> vehicleListDummy(){
        return Collections.singletonList(vehicleDummy());
    }

    private static Vehicle vehicleDummy() {
        return Vehicle.builder()
                .id("1")
                .batteryLevel(1)
                .companyZoneId(1)
                .engineType("engineType")
                .licencePlate("licensePlate")
                .model("model")
                .name("name")
                .pricePerMinuteDriving(1F)
                .range(1)
                .seats(1)
                .pricePerMinuteParking(1F)
                .realTimeData(true)
                .resourceImageId("resourceImageId")
                .resourceType("resorceType")
                .x(1F)
                .y(1F)
                .build();
    }

    private static VehicleDTO vehicleDTODummy() {
        return VehicleDTO.builder()
                .id("1")
                .batteryLevel(1)
                .companyZoneId(1)
                .engineType("engineType")
                .licencePlate("licensePlate")
                .model("model")
                .name("name")
                .pricePerMinuteDriving(1F)
                .range(1)
                .seats(1)
                .pricePerMinuteParking(1F)
                .realTimeData(true)
                .resourceImageId("resourceImageId")
                .resourceType("resorceType")
                .x(1F)
                .y(1F)
                .build();
    }
}
