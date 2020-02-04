package com.bladi.meep.service.impl;

import com.bladi.meep.dao.VehicleDao;
import com.bladi.meep.service.VehicleService;

public class VehicleServiceImpl implements VehicleService {

    private VehicleDao vehicleDao;

    public VehicleServiceImpl(VehicleDao vehicleDao) {
        this.vehicleDao = vehicleDao;
    }
}
