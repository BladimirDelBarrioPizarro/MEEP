package com.bladi.meep.controller.impl;

import com.bladi.meep.controller.VehicleController;
import com.bladi.meep.service.VehicleService;

public class VehicleControllerImpl implements VehicleController {

    private VehicleService vehicleService;

    public VehicleControllerImpl(VehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }
}
