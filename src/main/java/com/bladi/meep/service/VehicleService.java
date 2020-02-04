package com.bladi.meep.service;

import com.bladi.meep.model.entity.Vehicle;

import java.util.List;

public interface VehicleService {
    List<Vehicle> getVehicles(String lowerwLeftLatLon, String upperRightLatLon, String companyZoneIds);
}
