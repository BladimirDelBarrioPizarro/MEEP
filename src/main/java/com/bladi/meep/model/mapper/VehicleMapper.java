package com.bladi.meep.model.mapper;

import com.bladi.meep.model.entity.Vehicle;

import java.util.Arrays;
import java.util.List;

public class VehicleMapper {


    public static List<Vehicle> mapVehicleArrayToVehicleList(Vehicle[] objectData) {
        return Arrays.asList(objectData);
    }
}
