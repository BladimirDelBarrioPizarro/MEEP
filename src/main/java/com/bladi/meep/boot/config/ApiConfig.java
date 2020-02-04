package com.bladi.meep.boot.config;

import com.bladi.meep.boot.properties.Properties;
import com.bladi.meep.controller.VehicleController;
import com.bladi.meep.controller.impl.VehicleControllerImpl;
import com.bladi.meep.dao.VehicleDao;
import com.bladi.meep.service.VehicleService;
import com.bladi.meep.service.impl.VehicleServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApiConfig {

    @Bean
    public Properties properties(){
        return new Properties();
    }

    @Bean
    public VehicleService vehicleService(VehicleDao vehicleDao){
        return new VehicleServiceImpl(vehicleDao);
    }


    @Bean
    public VehicleController vehicleController(VehicleService vehicleService){
        return new VehicleControllerImpl(vehicleService);
    }



}
