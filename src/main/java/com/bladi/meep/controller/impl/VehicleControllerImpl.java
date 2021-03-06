package com.bladi.meep.controller.impl;

import com.bladi.meep.controller.VehicleController;
import com.bladi.meep.model.dto.VehicleDTO;
import com.bladi.meep.service.VehicleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import java.util.List;

@Slf4j
public class VehicleControllerImpl implements VehicleController {

    private VehicleService vehicleService;



    public VehicleControllerImpl(VehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }


    @Override
    public ResponseEntity<List<VehicleDTO>> getVehicles() {
        log.info(" -- GET /vehicles");
        return new ResponseEntity(vehicleService.getVehicles(), HttpStatus.OK);
    }
}
