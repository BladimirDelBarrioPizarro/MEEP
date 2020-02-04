package com.bladi.meep.dao;

import com.bladi.meep.model.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VehicleDao extends JpaRepository<Vehicle,String> {
}
