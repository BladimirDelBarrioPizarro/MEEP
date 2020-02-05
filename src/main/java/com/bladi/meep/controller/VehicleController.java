package com.bladi.meep.controller;

import com.bladi.meep.model.dto.VehicleDTO;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/api/v1")
public interface VehicleController {

    @GetMapping(path="/vehicles",produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<List<VehicleDTO>> getVehicles();
}
