package com.bladi.meep.dao;

import com.bladi.meep.model.entity.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VehicleDao extends JpaRepository<Vehicle,String> {
}
