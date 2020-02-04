package com.bladi.meep.service;

import com.bladi.meep.model.dto.VehicleDTO;
import java.util.List;

public interface VehicleService {
    List<VehicleDTO> getVehicles();
}
